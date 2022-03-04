package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    private List<NewMember> member = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NewMember> getMember() {
        return member;
    }

    public void setMember(List<NewMember> member) {
        this.member = member;
    }
}
