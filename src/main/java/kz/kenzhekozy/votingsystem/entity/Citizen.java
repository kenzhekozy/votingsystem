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
    private Integer id;

    public Citizen() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Citizen(Integer id, String name, Boolean hasVoted) {
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
