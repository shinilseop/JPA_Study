package testDomain;

import domain.Member;
import domain.Order;
import domain.OrderItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class MemberUpdateTest {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();


//    EntityManager em2 = emf.createEntityManager();
    EntityTransaction tx2 = em.getTransaction();

    Long id = 0L;

    try {
      tx.begin();
      TestMember member = new TestMember();
      member.setName("test4");

      System.out.println("---1");
      em.persist(member);
      id = member.getId();
      tx.commit();

      tx2.begin();
      System.out.println("---2");
      TestMember find = em.find(TestMember.class, id);

      System.out.println("member == find :: "+(member == find));

      find.setName("hello");
      tx2.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
//      em2.close();
      emf.close();
    }

  }
}
