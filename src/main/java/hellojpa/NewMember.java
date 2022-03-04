package hellojpa;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
public class NewMember {

    @Id @GeneratedValue
    @Column(name = "new_member_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMember().add(this);
    }
}
