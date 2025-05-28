package example.core.discount;

import example.core.member.Grade;
import example.core.member.Member;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) return discountFixAmount;
        else return 0;
    }
}
