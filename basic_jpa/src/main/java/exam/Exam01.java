package exam;

import domain.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Exam01 {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    Member member = new Member();
    member.setName("test");

    em.persist(member);

    Member result = em.find(Member.class, member.getId());
    System.out.println("@@name:"+result.getName());

    tx.commit();

    em.close();

    emf.close();
  }
}
