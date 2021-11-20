package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
//       엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//      엔티티 매니저는 사용하고 버리는 형식(쓰레드간에 공유 X)
//       JPA 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction(); // 트랜잭션 시작 선언해야함
        ts.begin();

        try {
//            Member member = new Member();

//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);
//            Team team = new Team();
//            team.set


//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUserName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();// 강제호출해서 쿼리문 확인가능(어차피 캐시에있는거 갖다써서 노상관)
//
//            Team findTeam = em.find(Team.class, team.getId());
////            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUserName());
//            }



            Member member = new Member();
            member.setUserName("member1");
            em.persist(member);

            Team team = new Team();
            team.setName("teamA");//
            team.getMembers().add(member);
            em.persist(team);


            ts.commit();
        } catch (Exception e){
            ts.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
