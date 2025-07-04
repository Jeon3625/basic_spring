package example.core.discount;

import example.core.annotation.MainDiscountPolicy;
import example.core.member.Grade;
import example.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Qualifier("mainDiscountPolicy")
@Component
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override

    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) return price * discountPercent /100;
        else return 0;
    }
}
