package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            NewMember member = new NewMember();
            Team team = new Team();
            team.setTeamName("team1");

            member.setName("aa");
            member.setTeam(team);

            em.persist(team);

            Team team1 = em.find(Team.class, team.getId());
            em.remove(team1);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
