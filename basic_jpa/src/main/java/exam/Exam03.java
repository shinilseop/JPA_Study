package exam;

import domain.Order;
import domain.OrderItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Exam03 {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Order order = new Order();
      order.addOrderItem(new OrderItem());

      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
      emf.close();
    }
  }
}
