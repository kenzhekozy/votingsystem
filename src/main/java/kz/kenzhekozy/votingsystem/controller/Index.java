package kz.kenzhekozy.votingsystem.controller;

import kz.kenzhekozy.votingsystem.entity.Candidate;
import kz.kenzhekozy.votingsystem.entity.Citizen;
import kz.kenzhekozy.votingsystem.repo.CandidateRepo;
import kz.kenzhekozy.votingsystem.repo.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @Autowired
    CitizenRepo citizenRepo;

    @RequestMapping("/addCitizen")
    public String addCitizen() {
        citizenRepo.save(new Citizen(12l, "Bobby"));
    return "Success";
    }

    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping ("/addCandidate")
    public String addCandidate() {
        candidateRepo.save(new Candidate(11l, "Nurik"));
        return "Successful candidate";
    }

}
