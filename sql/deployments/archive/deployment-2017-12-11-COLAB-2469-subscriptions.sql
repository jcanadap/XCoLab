-- Table changes
ALTER TABLE xcolab_ActivitySubscription DROP type_;
ALTER TABLE xcolab_ActivitySubscription ADD activityCategory VARCHAR(30) NOT NULL;
ALTER TABLE xcolab_ActivitySubscription ADD categoryId BIGINT(20) NOT NULL;
ALTER TABLE xcolab_ActivitySubscription
  MODIFY COLUMN receiverId BIGINT(20) AFTER pk,
  MODIFY COLUMN activityCategory VARCHAR(30) NOT NULL AFTER receiverId,
  MODIFY COLUMN categoryId BIGINT(20) NOT NULL AFTER activityCategory;

CREATE INDEX ActivitySubscription_receiver_index ON xcolab_ActivitySubscription (receiverId);
CREATE INDEX ActivitySubscription_category_id_receiver_index
    ON xcolab_ActivitySubscription (activityCategory, categoryId, receiverId);
DROP INDEX IX_33049EE6 ON xcolab_ActivitySubscription;
DROP INDEX IX_1413A2B6 ON xcolab_ActivitySubscription;
DROP INDEX IX_61FA63BB ON xcolab_ActivitySubscription;
DROP INDEX IX_C2ED8710 ON xcolab_ActivitySubscription;


-- Activity subscription cleanup

-- Remove unknown subscriptions
delete from xcolab_ActivitySubscription where classNameId not in (39202, 1368503, 39701);

-- Delete unknown subscription
delete from xcolab_ActivitySubscription where pk = 1002547
  and (select stringValue from xcolab_ConfigurationAttribute where name = 'COLAB_NAME') = 'Climate CoLab';

-- Normalize extra data
update xcolab_ActivitySubscription set extraData = null where length(extraData) < 2 or extraData is null;

-- Populate new fields
update xcolab_ActivitySubscription set activityCategory = 'DISCUSSION' where classNameId = 39202;
update xcolab_ActivitySubscription set activityCategory = 'PROPOSAL' where classNameId = 1368503;
update xcolab_ActivitySubscription set activityCategory = 'CONTEST' where classNameId = 39701;

-- populate categoryIds
-- legacy thread subscriptions
update xcolab_ActivitySubscription set categoryId = substring_index ( substring_index ( extraData, ',', 2), ',', -1)
    where classNameId = 39202 and length(extraData) > 2;
-- regular thread subscriptions
update xcolab_ActivitySubscription set categoryId = classPK where activityCategory = 'DISCUSSION' and extraData is null;
-- category subscriptions
update xcolab_ActivitySubscription set activityCategory = 'DISCUSSION_CATEGORY', categoryId = 0 where activityCategory = 'DISCUSSION' and classPK = 0;

-- Proposal and contests
update xcolab_ActivitySubscription set categoryId = classPK where activityCategory in ('PROPOSAL', 'CONTEST');
