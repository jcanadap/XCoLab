package org.xcolab.client.proposals.pojo.team;

import java.io.Serializable;
import java.sql.Timestamp;

class AbstractMembershipRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long membershiprequestid;
    private Long companyid;
    private Long userid;
    private Timestamp createdate;
    private Long groupid;
    private String comments;
    private String replycomments;
    private Timestamp replydate;
    private Long replieruserid;
    private Integer statusid;

    public AbstractMembershipRequest() {}

    public AbstractMembershipRequest(AbstractMembershipRequest value) {
        this.membershiprequestid = value.membershiprequestid;
        this.companyid = value.companyid;
        this.userid = value.userid;
        this.createdate = value.createdate;
        this.groupid = value.groupid;
        this.comments = value.comments;
        this.replycomments = value.replycomments;
        this.replydate = value.replydate;
        this.replieruserid = value.replieruserid;
        this.statusid = value.statusid;
    }

    public AbstractMembershipRequest(
            Long membershiprequestid,
            Long companyid,
            Long userid,
            Timestamp createdate,
            Long groupid,
            String comments,
            String replycomments,
            Timestamp replydate,
            Long replieruserid,
            Integer statusid
    ) {
        this.membershiprequestid = membershiprequestid;
        this.companyid = companyid;
        this.userid = userid;
        this.createdate = createdate;
        this.groupid = groupid;
        this.comments = comments;
        this.replycomments = replycomments;
        this.replydate = replydate;
        this.replieruserid = replieruserid;
        this.statusid = statusid;
    }

    public Long getMembershipRequestId() {
        return this.membershiprequestid;
    }

    public void setMembershipRequestId(Long membershiprequestid) {
        this.membershiprequestid = membershiprequestid;
    }

    public Long getCompanyId() {
        return this.companyid;
    }

    public void setCompanyId(Long companyid) {
        this.companyid = companyid;
    }

    public Long getUserId() {
        return this.userid;
    }

    public void setUserId(Long userid) {
        this.userid = userid;
    }

    public Timestamp getCreateDate() {
        return this.createdate;
    }

    public void setCreateDate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Long getGroupId() {
        return this.groupid;
    }

    public void setGroupId(Long groupid) {
        this.groupid = groupid;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReplyComments() {
        return this.replycomments;
    }

    public void setReplyComments(String replycomments) {
        this.replycomments = replycomments;
    }

    public Timestamp getReplyDate() {
        return this.replydate;
    }

    public void setReplyDate(Timestamp replydate) {
        this.replydate = replydate;
    }

    public Long getReplierUserId() {
        return this.replieruserid;
    }

    public void setReplierUserId(Long replieruserid) {
        this.replieruserid = replieruserid;
    }

    public Integer getStatusId() {
        return this.statusid;
    }

    public void setStatusId(Integer statusid) {
        this.statusid = statusid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((membershiprequestid == null) ? 0
                : membershiprequestid.hashCode());
        result = prime * result + ((companyid == null) ? 0 : companyid.hashCode());
        result = prime * result + ((userid == null) ? 0 : userid.hashCode());
        result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
        result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((replycomments == null) ? 0 : replycomments.hashCode());
        result = prime * result + ((replydate == null) ? 0 : replydate.hashCode());
        result = prime * result + ((replieruserid == null) ? 0 : replieruserid.hashCode());
        result = prime * result + ((statusid == null) ? 0 : statusid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractMembershipRequest other = (AbstractMembershipRequest) obj;
        if (membershiprequestid == null) {
            if (other.membershiprequestid != null) {
                return false;
            }
        } else if (!membershiprequestid.equals(other.membershiprequestid)) {
            return false;
        }
        if (companyid == null) {
            if (other.companyid != null) {
                return false;
            }
        } else if (!companyid.equals(other.companyid)) {
            return false;
        }
        if (userid == null) {
            if (other.userid != null) {
                return false;
            }
        } else if (!userid.equals(other.userid)) {
            return false;
        }
        if (createdate == null) {
            if (other.createdate != null) {
                return false;
            }
        } else if (!createdate.equals(other.createdate)) {
            return false;
        }
        if (groupid == null) {
            if (other.groupid != null) {
                return false;
            }
        } else if (!groupid.equals(other.groupid)) {
            return false;
        }
        if (comments == null) {
            if (other.comments != null) {
                return false;
            }
        } else if (!comments.equals(other.comments)) {
            return false;
        }
        if (replycomments == null) {
            if (other.replycomments != null) {
                return false;
            }
        } else if (!replycomments.equals(other.replycomments)) {
            return false;
        }
        if (replydate == null) {
            if (other.replydate != null) {
                return false;
            }
        } else if (!replydate.equals(other.replydate)) {
            return false;
        }
        if (replieruserid == null) {
            if (other.replieruserid != null) {
                return false;
            }
        } else if (!replieruserid.equals(other.replieruserid)) {
            return false;
        }
        if (statusid == null) {
            if (other.statusid != null) {
                return false;
            }
        } else if (!statusid.equals(other.statusid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String sb = "MembershipRequest (" + membershiprequestid + ", " + companyid + ", " + userid
                + ", " + createdate + ", " + groupid + ", " + comments + ", " + replycomments + ", "
                + replydate + ", " + replieruserid + ", " + statusid + ")";

        return sb;
    }
}
