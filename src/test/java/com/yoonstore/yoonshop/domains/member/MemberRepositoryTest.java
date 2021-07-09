package com.yoonstore.yoonshop.domains.member;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

   @Test
   @Transactional
   @Rollback(false)
   @DisplayName("회원 저장 테스트")
   public void saveMember_test() throws Exception {
       //arrange
       Member member = new Member();
       member.setName("happy");

       //act
       Long savedId = memberRepository.save(member);
       Member findMember = memberRepository.findOne(savedId);

       //assert
       assertThat(savedId).isEqualTo(findMember.getId());
       assertThat(member.getName()).isEqualTo(findMember.getName());
       assertThat(member).isEqualTo(findMember);
   }

}