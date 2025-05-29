package example.core.order;

import example.core.annotation.MainDiscountPolicy;
import example.core.discount.DiscountPolicy;
import example.core.member.Member;
import example.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



//@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService{


    //주문하기전에 회원을 찾아야함 그리고 DIP 위반 -> config로 설정
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // DIP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    롬복이 만들어줌
@Autowired
public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
//    위에꺼를 밑에꺼로
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member FM = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(FM, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
