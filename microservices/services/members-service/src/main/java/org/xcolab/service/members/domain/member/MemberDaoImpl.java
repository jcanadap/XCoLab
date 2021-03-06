package org.xcolab.service.members.domain.member;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.xcolab.commons.SortColumn;
import org.xcolab.model.tables.MemberCategoryTable;
import org.xcolab.model.tables.MemberTable;
import org.xcolab.model.tables.Users_RolesTable;
import org.xcolab.model.tables.pojos.Member;
import org.xcolab.model.tables.records.MemberRecord;
import org.xcolab.service.utils.PaginationHelper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.coalesce;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.countDistinct;
import static org.jooq.impl.DSL.ltrim;
import static org.jooq.impl.DSL.max;
import static org.jooq.impl.DSL.nullif;
import static org.jooq.impl.DSL.sum;
import static org.jooq.impl.DSL.val;
import static org.xcolab.model.Tables.ACTIVITY_ENTRY;
import static org.xcolab.model.Tables.LOGIN_LOG;
import static org.xcolab.model.Tables.MEMBER;
import static org.xcolab.model.Tables.MEMBER_CATEGORY;
import static org.xcolab.model.Tables.POINTS;
import static org.xcolab.model.Tables.USERS_ROLES;

@Repository
public class MemberDaoImpl implements MemberDao {

    private final DSLContext dslContext;

    @Autowired
    public MemberDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Member> findByGiven(PaginationHelper paginationHelper, String partialName,
            String partialEmail, String roleName, String email, String screenName, Long facebookId,
            String googleId, String colabSsoId, String climateXId, List<Long> roleIds) {
        final MemberTable member = MEMBER.as("member");
        final Users_RolesTable usersRoles = USERS_ROLES.as("usersRoles");
        final MemberCategoryTable memberCategory = MEMBER_CATEGORY.as("memberCategory");

        final SelectQuery<Record> query = dslContext.selectDistinct(member.fields())
                .from(member)
                .where(member.STATUS.eq(0))
                .getQuery();

        if (roleName != null || roleIds != null) {
            query.addJoin(usersRoles, member.ID_.equal(usersRoles.USER_ID));
        }
        if (roleName != null) {
            query.addJoin(memberCategory, memberCategory.ROLE_ID.equal(usersRoles.ROLE_ID));
        }

        if (partialName != null || partialEmail != null) {
            addSearchCondition(partialName, partialEmail, query,member);
        }
        if (roleName != null) {
            query.addConditions(memberCategory.DISPLAY_NAME.eq(roleName));
        }
        if (roleIds != null) {
            query.addConditions(usersRoles.ROLE_ID.in(roleIds));
        }
        if (screenName != null) {
            query.addConditions(member.SCREEN_NAME.eq(screenName));
        }
        if (email != null) {
            query.addConditions(member.EMAIL_ADDRESS.eq(email));
        }
        if (facebookId != null) {
            query.addConditions(member.FACEBOOK_ID.eq(facebookId));
        }
        if (googleId != null) {
            query.addConditions(member.GOOGLE_ID.eq(googleId));
        }
        if (colabSsoId != null) {
            query.addConditions(member.COLAB_SSO_ID.eq(colabSsoId));
        }
        if (climateXId != null) {
            query.addConditions(member.CLIMATE_X_ID.eq(climateXId));
        }
        if (roleName != null) {
            Users_RolesTable userRolesInner = USERS_ROLES.as("userRolesInner");
            MemberCategoryTable memberCategoryInner = MEMBER_CATEGORY.as("memberCategoryInner");

            query.addConditions(usersRoles.ROLE_ID.eq(
                    dslContext.select(userRolesInner.ROLE_ID)
                    .from(userRolesInner)
                    .innerJoin(memberCategoryInner).on(userRolesInner.ROLE_ID.eq(memberCategoryInner.ROLE_ID))
                    .where(userRolesInner.USER_ID.eq(member.ID_))
                    .orderBy(memberCategoryInner.SORT_ORDER.desc())
                    .limit(0,1)
            ));
        }

        for (SortColumn sortColumn : paginationHelper.getSortColumns()) {
            switch (sortColumn.getColumnName()) {
                case "createDate":
                    query.addOrderBy(sortColumn.isAscending()
                            ? member.CREATE_DATE.asc() : member.CREATE_DATE.desc());
                    break;
                case "screenName":
                    query.addOrderBy(sortColumn.isAscending()
                            ? member.SCREEN_NAME.asc() : member.SCREEN_NAME.desc());
                    break;
                case "displayName":
                    Field<String> displayName = getDisplayName(member);
                    query.addOrderBy(sortColumn.isAscending()
                            ? displayName.asc() :  displayName.desc());
                    break;
                case "activityCount":
                    //TODO COLAB-2608: this property is owned by the activities-service
                    Field<Object> activityCount = this.dslContext.selectCount()
                            .from(ACTIVITY_ENTRY)
                            .where(ACTIVITY_ENTRY.MEMBER_ID.equal(member.ID_))
                            .asField("activityCount");
                    query.addSelect(activityCount);
                    query.addSelect(member.fields());
                    query.addOrderBy(sortColumn.isAscending()
                            ? activityCount.asc() : activityCount.desc());
                    break;
                    //TODO COLAB-2607: this sorting doesn't work
                case "roleName":
                    Field<Object> roleNameField = dslContext.select(max(MEMBER_CATEGORY.SORT_ORDER))
                            .from(MEMBER_CATEGORY)
                            .join(USERS_ROLES).on(USERS_ROLES.ROLE_ID.eq(MEMBER_CATEGORY.ROLE_ID))
                            .where(USERS_ROLES.USER_ID.eq(member.ID_))
                            .asField("roleName");
                    query.addSelect(roleNameField);
                    query.addOrderBy(sortColumn.isAscending()
                            ? roleNameField.asc()
                            : roleNameField.desc());
                    break;
                case "points":
                    Field<Object> points =
                            this.dslContext.select(sum(POINTS.MATERIALIZED_POINTS))
                                    .from(POINTS)
                                    .where(POINTS.USER_ID.equal(member.ID_))
                                    .asField("points");
                    query.addSelect(points);
                    query.addOrderBy(sortColumn.isAscending()
                            ? points.asc() : points.desc());
                    break;
                default:
            }
        }
        query.addLimit(paginationHelper.getStartRecord(), paginationHelper.getCount());
        return query.fetchInto(Member.class);
    }

    private Field<String> getDisplayName(MemberTable member) {
        // Concatenate first name and last name to full name. If the full name is more than just a
        // space, return the full name. Else, return the screen name.
        Field<String> firstName = coalesce(ltrim(member.FIRST_NAME), "");
        Field<String> lastName = coalesce(ltrim(member.LAST_NAME), "");
        Field<String> fullName = ltrim(concat(firstName, val(" "), lastName));
        fullName = nullif(fullName, " ");
        Field<String> screenName = member.SCREEN_NAME;
        return coalesce(fullName, screenName);
    }

    private void addSearchCondition(String partialName, String partialEmail,
            SelectQuery<?> query, MemberTable memberTable) {
        Condition searchCondition = DSL.falseCondition();
        if (partialName != null) {
            String[] searchTerms = partialName.split("\\s");
            for (String searchTerm : searchTerms) {
                searchCondition = searchCondition
                        .or(memberTable.SCREEN_NAME.contains(searchTerm))
                        .or(memberTable.FIRST_NAME.contains(searchTerm))
                        .or(memberTable.LAST_NAME.contains(searchTerm));
            }
        }
        if (partialEmail != null) {
            searchCondition = searchCondition.or(memberTable.EMAIL_ADDRESS.contains(partialEmail));
        }
        query.addConditions(searchCondition);
    }

    @Override
    public List<Member> findByIp(String ip) {
        final SelectQuery<Record> query = dslContext
                .selectDistinct(MEMBER.fields())
                .from(MEMBER)
                .join(LOGIN_LOG).on(LOGIN_LOG.USER_ID.equal(MEMBER.ID_))
                .where(LOGIN_LOG.IP_ADDRESS.eq(ip))
                .getQuery();
        return query.fetchInto(Member.class);
    }

    @Override
    public List<Member> findByScreenNameName(String name) {
        final SelectQuery<Record> query = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.SCREEN_NAME.like("%"+name+"%"))
                .or(MEMBER.FIRST_NAME.like("%"+name+"%"))
                .and(MEMBER.STATUS.eq(0))
                .orderBy(MEMBER.SCREEN_NAME)
                .getQuery();
        return query.fetchInto(Member.class);
    }

    @Override
    public int countByGiven(String partialName, String partialEmail, String roleName) {

        final MemberTable memberTable = MEMBER.as("member");
        final Users_RolesTable usersRoles = USERS_ROLES.as("usersRoles");
        final MemberCategoryTable memberCategory = MEMBER_CATEGORY.as("memberCategory");
        final SelectQuery<Record1<Integer>> query = dslContext.select(countDistinct(memberTable.ID_))
                .from(memberTable)
                .join(usersRoles).on(memberTable.ID_.equal(usersRoles.USER_ID))
                .join(memberCategory).on(memberCategory.ROLE_ID.equal(usersRoles.ROLE_ID))
                .where(memberTable.STATUS.eq(0))
                .getQuery();

        if (partialName != null || partialEmail != null) {
            addSearchCondition(partialName, partialEmail, query,memberTable);
        }
        if (roleName != null) {
            query.addConditions(memberCategory.DISPLAY_NAME.eq(roleName));
        }
        return query.fetchOne().into(Integer.class);
    }

    @Override
    public Optional<Member> getMember(long memberId) {
        final Record memberRecord = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.ID_.eq(memberId))
                .fetchOne();
        if (memberRecord == null) {
            return Optional.empty();
        }
        return Optional.of(memberRecord.into(Member.class));
    }

    @Override
    public boolean updatePassword(long memberId, String hashedPassword) {
        return dslContext.update(MEMBER)
                .set(MEMBER.HASHED_PASSWORD, hashedPassword)
                .set(MEMBER.PASSWORD_MODIFIED_DATE, DSL.currentTimestamp())
                .set(MEMBER.MODIFIED_DATE, DSL.currentTimestamp())
                .set(MEMBER.FORGOT_PASSWORD_TOKEN, (String) null)
                .set(MEMBER.FORGOT_PASSWORD_TOKEN_EXPIRE_TIME, (Timestamp) null)
                .where(MEMBER.ID_.eq(memberId))
                .execute() > 0;
    }


    @Override
    public boolean isScreenNameTaken(String screenName) {
        return dslContext.selectCount()
                .from(MEMBER)
                .where(MEMBER.SCREEN_NAME.eq(screenName))
                .fetchOne(0, Integer.class) > 0;
    }

    @Override
    public boolean isEmailUsed(String email) {
        return dslContext.selectCount()
                .from(MEMBER)
                .where(MEMBER.EMAIL_ADDRESS.eq(email))
                .fetchOne(0, Integer.class) > 0;
    }

    @Override
    public Optional<Member> findOneByScreenName(String screenName) {
        final Record record = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.SCREEN_NAME.eq(screenName))
                .fetchOne();
        if (record == null) {
            return Optional.empty();
        }
        return Optional.of(record.into(Member.class));
    }

    @Override
    public Optional<Member> findOneByEmail(String email) {
        final Record record = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.EMAIL_ADDRESS.eq(email))
                .fetchOne();
        if (record == null) {
            return Optional.empty();
        }
        return Optional.of(record.into(Member.class));
    }

    @Override
    public Optional<Member> findOneByLoginTokenId(String loginTokenId) {
        final Record record = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.LOGIN_TOKEN_ID.eq(loginTokenId))
                .fetchOne();
        if (record == null) {
            return Optional.empty();
        }
        return Optional.of(record.into(Member.class));
    }

    @Override
    public Optional<Member> findOneByForgotPasswordHash(String newPasswordToken) {
        final Record record = dslContext.select()
                .from(MEMBER)
                .where(MEMBER.FORGOT_PASSWORD_TOKEN.eq(newPasswordToken))
                .fetchOne();
        if (record == null) {
            return Optional.empty();
        }
        return Optional.of(record.into(Member.class));
    }

    @Override
    public boolean updateMember(Member member) {

        return this.dslContext.update(MEMBER)
                .set(MEMBER.UUID, member.getUuid())
                .set(MEMBER.MODIFIED_DATE, DSL.currentTimestamp())
                .set(MEMBER.SCREEN_NAME, member.getScreenName())
                .set(MEMBER.EMAIL_ADDRESS, member.getEmailAddress())
                .set(MEMBER.IS_EMAIL_CONFIRMED, member.getIsEmailConfirmed())
                .set(MEMBER.IS_EMAIL_BOUNCED, member.getIsEmailBounced())
                .set(MEMBER.OPEN_ID, member.getOpenId())
                .set(MEMBER.DEFAULT_LOCALE, member.getDefaultLocale())
                .set(MEMBER.FIRST_NAME, member.getFirstName())
                .set(MEMBER.LAST_NAME, member.getLastName())
                .set(MEMBER.LOGIN_DATE, member.getLoginDate())
                .set(MEMBER.LOGIN_IP, member.getLoginIP())
                .set(MEMBER.FACEBOOK_ID, member.getFacebookId())
                .set(MEMBER.GOOGLE_ID, member.getGoogleId())
                .set(MEMBER.COLAB_SSO_ID, member.getColabSsoId())
                .set(MEMBER.CLIMATE_X_ID, member.getClimateXId())
                .set(MEMBER.SHORT_BIO, member.getShortBio())
                .set(MEMBER.AUTO_REGISTERED_MEMBER_STATUS, member.getAutoRegisteredMemberStatus())
                .set(MEMBER.DEFAULT_LOCALE, member.getDefaultLocale())
                .set(MEMBER.COUNTRY, member.getCountry())
                .set(MEMBER.STATUS, member.getStatus())
                .set(MEMBER.PORTRAIT_FILE_ENTRY_ID, member.getPortraitFileEntryId())
                .set(MEMBER.FORGOT_PASSWORD_TOKEN, member.getForgotPasswordToken())
                .set(MEMBER.FORGOT_PASSWORD_TOKEN_EXPIRE_TIME, member.getForgotPasswordTokenExpireTime())
                .set(MEMBER.LOGIN_TOKEN_ID, member.getLoginTokenId())
                .set(MEMBER.LOGIN_TOKEN_KEY, member.getLoginTokenKey())
                .set(MEMBER.LOGIN_TOKEN_EXPIRATION_DATE, member.getLoginTokenExpirationDate())
                .where(MEMBER.ID_.equal(member.getId_()))
                .execute() > 0;
    }

    @Override
    public Member createMember(Member member) {
        final Optional<MemberRecord> memberRecord =
                dslContext.insertInto(MEMBER)
                        .set(MEMBER.UUID, member.getUuid())
                        .set(MEMBER.SCREEN_NAME, member.getScreenName())
                        .set(MEMBER.EMAIL_ADDRESS, member.getEmailAddress())
                        .set(MEMBER.IS_EMAIL_CONFIRMED, member.getIsEmailConfirmed())
                        .set(MEMBER.IS_EMAIL_BOUNCED, member.getIsEmailBounced())
                        .set(MEMBER.OPEN_ID, member.getOpenId())
                        .set(MEMBER.DEFAULT_LOCALE, member.getDefaultLocale())
                        .set(MEMBER.FIRST_NAME, member.getFirstName())
                        .set(MEMBER.LAST_NAME, member.getLastName())
                        .set(MEMBER.LOGIN_DATE, member.getLoginDate())
                        .set(MEMBER.LOGIN_IP, member.getLoginIP())
                        .set(MEMBER.HASHED_PASSWORD, member.getHashedPassword())
                        .set(MEMBER.FACEBOOK_ID, member.getFacebookId())
                        .set(MEMBER.GOOGLE_ID, member.getGoogleId())
                        .set(MEMBER.COLAB_SSO_ID, member.getColabSsoId())
                        .set(MEMBER.CLIMATE_X_ID, member.getClimateXId())
                        .set(MEMBER.SHORT_BIO, member.getShortBio())
                        .set(MEMBER.AUTO_REGISTERED_MEMBER_STATUS, member.getAutoRegisteredMemberStatus())
                        .set(MEMBER.DEFAULT_LOCALE, member.getDefaultLocale())
                        .set(MEMBER.COUNTRY, member.getCountry())
                        .set(MEMBER.STATUS, member.getStatus())
                        .set(MEMBER.PORTRAIT_FILE_ENTRY_ID, member.getPortraitFileEntryId())
                        .set(MEMBER.FORGOT_PASSWORD_TOKEN, member.getForgotPasswordToken())
                        .set(MEMBER.FORGOT_PASSWORD_TOKEN_EXPIRE_TIME, member.getForgotPasswordTokenExpireTime())
                        .set(MEMBER.LOGIN_TOKEN_ID, member.getLoginTokenId())
                        .set(MEMBER.LOGIN_TOKEN_KEY, member.getLoginTokenKey())
                        .set(MEMBER.LOGIN_TOKEN_EXPIRATION_DATE, member.getLoginTokenExpirationDate())
                        .set(MEMBER.CREATE_DATE, DSL.currentTimestamp())
                        .set(MEMBER.MODIFIED_DATE, DSL.currentTimestamp())
                        .returning(MEMBER.ID_)
                        .fetchOptional();
        if (!memberRecord.isPresent()) {
            throw new IllegalStateException("Could not fetch generated ID");
        }
        member.setId_(memberRecord.get().getValue(MEMBER.ID_));
        return member;
    }

    @Override
    public Integer getMemberMaterializedPoints(Long memberId) {
        return this.dslContext.select(sum(POINTS.MATERIALIZED_POINTS))
                .from(POINTS).where(POINTS.USER_ID.equal(memberId)).fetchOne(0, Integer.class);
    }

    @Override
    public Integer getMemberHypotheticalPoints(Long memberId) {
        return dslContext.select(sum(POINTS.HYPOTHETICAL_POINTS))
                .from(POINTS).where(POINTS.USER_ID.eq(memberId)).fetchOne(0, Integer.class);
    }
}
