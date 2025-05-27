package example.core.member;

public class MemberServiceImpl implements MemberService{

    //하향식으로 인터페이스 = new 구현체 DIP 위반
//    private final MemberRepository memberRepository= new MemoryMemberRepository();

    // 생성자를 통해서 컨택
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
