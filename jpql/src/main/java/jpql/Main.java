package jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import jpql.entity.Member;
import jpql.entity.MemberDTO;

public class Main {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Member member = new Member();
      member.setUsername("member1");
      member.setAge(20);
      em.persist(member);

      em.flush();
      em.clear();

      List<Member> query1 = em.createQuery("select m from Member m",
          Member.class).getResultList();

      for (Member m : query1) {
        System.out.println(m.getUsername());
      }

      List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m").getResultList();
      Object[] result = resultList.get(0);
      System.out.println("result = " + result[0]);
      System.out.println("result = " + result[1]);

      List<MemberDTO> resultList2 = em.createQuery("select new jpql.entity.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
          .setFirstResult(1)
          .setMaxResults(10)
          .getResultList();

      for (MemberDTO m : resultList2) {
        System.out.println("username : "+m.getUsername());
        System.out.println("age : "+m.getAge());
      }



      tx.commit();

    } catch (Exception e) {

    } finally {
      em.close();
      emf.close();
    }
  }
}
