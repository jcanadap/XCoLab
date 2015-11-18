<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:collab="http://climatecolab.org/tags/collab_1.0"
	version="2.0">
	
	<div>
        <h2> ${proposalsModel.preferences.title}<span>
            <a href="${proposalsModel.preferences.allProposalsUrl}">${proposalsModel.preferences.allProposalsTitle}</a>
        </span></h2>
        <c:forEach items="${proposalsModel.proposals}" var="proposal">
        	<div class="contestbox">
                <div class="img-wrap">
                    <a href="${proposal.proposalURL}">
                        <c:if test="${proposal.image > 0}">
                            <img src="${proposalsModel.baseImagePath}${proposal.image}" width="151" height="151" alt="${proposal.name}" />
                       	</c:if>
                        <c:if test="${empty proposal.image or proposal.image le 0}">
                            <img src="/climatecolab-theme/images/proposal_default.png" width="151" height="151" alt="${proposal.name}" style="border: 1px solid #bbb;"/>
                        </c:if>
                    </a>
                </div>
                <div class="text-wrap">
                    <h3><collab:proposalLink proposal="${proposal}" /></h3>
                    ${proposal.pitch}
                </div>
            </div> 
        </c:forEach>
 	</div>
 	
</jsp:root>