package com.yoonstore.yoonshop.domains.member;

import com.yoonstore.yoonshop.domains.member.exception.MemberNameDuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateNameDuplication(member);
        this.memberRepository.save(member);

        return member.getId();
    }

    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long id) {
        return this.memberRepository.findOne(id);
    }

    public void validateNameDuplication(Member member) {
        List<Member> findMembers = this.memberRepository.findByName(member.getName());

        if (findMembers.size() > 0) {
            throw new MemberNameDuplicateException(member.getName());
        }
    }

}
