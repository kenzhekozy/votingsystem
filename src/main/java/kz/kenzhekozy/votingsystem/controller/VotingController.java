package kz.kenzhekozy.votingsystem.controller;

import kz.kenzhekozy.votingsystem.entity.Citizen;
import kz.kenzhekozy.votingsystem.repo.CandidateRepo;
import kz.kenzhekozy.votingsystem.repo.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VotingController {

    @Autowired
    CitizenRepo citizenRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping("/")
    public String goToVote() {
        return "vote.html";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name) {
        Citizen citizen = citizenRepo.findCitizenByName(name);

        if (!citizen.isHasVoted()) {
            return "/performVote.html";
        } else {
            return "/alreadyVoted.html";
        }
    }
}
