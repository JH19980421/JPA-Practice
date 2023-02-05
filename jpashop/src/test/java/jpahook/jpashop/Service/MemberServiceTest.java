package jpahook.jpashop.Service;

import jpahook.jpashop.domain.Member;
import jpahook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //JUnit을 실행할 때 스프링도 같이 실행할 수 있도록 한다.
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;
    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member("kim");

        //when
        Long saveId = memberService.createUser(member);

        //then
//        entityManager.flush(); // 실제 쿼리문이 작성되는 구문을 볼수 있다.
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class) //
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member("kim");
        Member member2 = new Member("kim");

        //when
        memberService.createUser(member1);
        memberService.createUser(member2);

        //then
        fail("예외가 발생하였습니다.");
    }
}