package kz.kenzhekozy.votingsystem.controller;

import kz.kenzhekozy.votingsystem.entity.Candidate;
import kz.kenzhekozy.votingsystem.entity.Citizen;
import kz.kenzhekozy.votingsystem.repo.CandidateRepo;
import kz.kenzhekozy.votingsystem.repo.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String doLogin(@RequestParam String name, Model model, HttpSession session) {

        Citizen citizen = citizenRepo.findCitizenByName(name);
        session.setAttribute("citizen", citizen);

        if (citizen.isHasVoted()) {
            return "/alreadyVoted.html";
        } else {
            List<Candidate> candidates = candidateRepo.findAll();
            model.addAttribute("candidates", candidates);
            return "/performVote.html";
        }

    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam Integer id, HttpSession session) {
        Citizen citizen = (Citizen) session.getAttribute("citizen");

        if (citizen.isHasVoted()) {
            return "/already.html";
        }

        citizen.setHasVoted(true);
        citizenRepo.save(citizen);
        Candidate candidate = candidateRepo.findCandidateById(id);
        candidate.setNumberOfVotes(candidate.getNumberOfVotes()+1);
        candidateRepo.save(candidate);
        return "voted.html";
    }

    @RequestMapping("/results")
    public String results(@RequestParam Integer id) {
        Candidate candidate = candidateRepo.findCandidateById(id);
        return "results.html";
    }

}
