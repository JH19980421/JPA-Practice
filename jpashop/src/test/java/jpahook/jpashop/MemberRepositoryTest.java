package jpahook.jpashop;

import jpahook.jpashop.domain.Member;
import jpahook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // EntityManager에서 수행하는 모든 로직은 트랜잭션 안에서 수행되야 한다.
    @Rollback(false)
    public void testMember() throws Exception {
        //given
        Member member = new Member("memberA");
        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findOne(member.getId());

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMemeber == member : " + (findMember == member));
    }
}