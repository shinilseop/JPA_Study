package exam;

import domain.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Exam02 {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

//    Team team = new Team();
//    team.setName("A");
//
//    Member member = new Member();
//    member.setName("test");
//    member.changeTeam(team);
//
//    em.persist(member);
//
//    Member result = em.find(Member.class, 3L);
//    System.out.println("@@name:"+result.getName());
//    System.out.println("@@name:"+result.getTeam());

    tx.commit();

    em.close();

    emf.close();
  }
}
