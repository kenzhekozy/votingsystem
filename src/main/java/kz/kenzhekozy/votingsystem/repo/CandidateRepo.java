package kz.kenzhekozy.votingsystem.repo;

import kz.kenzhekozy.votingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

    public Candidate findCandidateById(Integer id);
}
