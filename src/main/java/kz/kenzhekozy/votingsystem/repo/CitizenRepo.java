package kz.kenzhekozy.votingsystem.repo;

import kz.kenzhekozy.votingsystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {

}
