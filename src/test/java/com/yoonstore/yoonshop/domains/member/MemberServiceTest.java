package com.yoonstore.yoonshop.domains.member;

import com.yoonstore.yoonshop.domains.member.exception.MemberNameDuplicateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext
    EntityManager entityManager;
    
    @Test
    public void join_test() throws Exception {
        //arrange
        Member member = new Member();
        member.setName("윤동환");
        
        //act
        Long savedId = memberService.join(member);
        entityManager.flush();

        //assert
        assertThat(savedId).isEqualTo(member.getId());
    }

    @Test(expected = MemberNameDuplicateException.class)
    public void memberName_duplicate_test() throws Exception {
        //arrange
        Member memberA = new Member();
        memberA.setName("Kim");

        Member memberB = new Member();
        memberB.setName("Kim");

        //act
        memberService.join(memberA);
        memberService.join(memberB);

//        try {
//            memberService.join(memberB);
//        } catch(MemberNameDuplicateException e) {
//            return;
//        }

        //assert
        fail("회원 중복 발생하지 않음");
    }

}