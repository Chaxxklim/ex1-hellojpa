package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction(); // 트랜잭션 시작 선언해야함
        ts.begin();

        try {
            Student findStudent = em.find(Student.class, 1);
            System.out.println("findStudent.id = " + findStudent.getId());
            System.out.println("findStudent.name = " + findStudent.getName());
            ts.commit();
        } catch (Exception e){
        ts.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
