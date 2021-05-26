package kz.kenzhekozy.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = "citizens")
@Entity
public class Citizen {
    @Id
    @Column (name = "id")
    private Long id;

    public Citizen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "citizen_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Citizen(Long id, String name, Boolean hasVoted) {
        this.id = id;
        this.name = name;
        this.hasVoted = hasVoted;
    }

    @Column(name = "hasvoted")
    private Boolean hasVoted;

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
