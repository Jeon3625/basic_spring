package example.core.discount;

import example.core.member.Member;

public interface DiscountPolicy {

    // return 값은 할인 대상 금액
    int discount(Member member, int price);
}
