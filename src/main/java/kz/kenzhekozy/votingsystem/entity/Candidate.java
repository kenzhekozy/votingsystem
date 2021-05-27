package kz.kenzhekozy.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = "candidates")
@Entity
public class Candidate {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "candidate_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candidate() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Candidate(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name = "NumberOfVotes")
    private Integer numberOfVotes;

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
