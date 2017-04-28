package org.xcolab.view.pages.proposals.view.proposal.tabs;

import edu.mit.cci.roma.client.Simulation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.modeling.roma.RomaClientUtil;
import org.xcolab.util.IdListUtil;
import org.xcolab.util.exceptions.InternalException;
import org.xcolab.view.pages.proposals.utils.context.ProposalsContext;
import org.xcolab.view.pages.proposals.tabs.ProposalTab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/contests/{contestYear}/{contestUrlName}")
public class ProposalLegacyModelTabController extends BaseProposalTabController {

    private final ProposalsContext proposalsContext;

    @Autowired
    public ProposalLegacyModelTabController(ProposalsContext proposalsContext) {
        this.proposalsContext = proposalsContext;
    }

    @GetMapping(value = "c/{proposalUrlString}/{proposalId}", params = "tab=ACTIONS_IMPACTS")
    public String show(Model model, HttpServletRequest request,
            @RequestParam(required = false) boolean edit) {

        setCommonModelAndPageAttributes(request, model, ProposalTab.ACTIONS_IMPACTS);
        return "proposals/proposalModel";
    }

    private Map<Long, String> getModelIdsAndNames(long contestPK) {
        List<Long> modelIds = getModelIds(contestPK);

        Map<Long, String> ret = new HashMap<>();
        for (Long modelId: modelIds) {
            try {
                Simulation s = RomaClientUtil.client().getSimulation(modelId);
                ret.put(s.getId(), s.getName());

            } catch (IOException e) {
                throw new InternalException(e);
            }
        }
        return ret;
    }

    private List<Long> getModelIds(long contestPK) {
        Contest contest = ContestClientUtil.getContest(contestPK);

        List<Long> modelIds = new ArrayList<>();

        if (StringUtils.isNotBlank(contest.getOtherModels())) {
            modelIds.addAll(IdListUtil.getIdsFromString(contest.getOtherModels()));
        }
        if (!modelIds.contains(contest.getDefaultModelId())) {
            modelIds.add(contest.getDefaultModelId());
        }

        return modelIds;
    }

}