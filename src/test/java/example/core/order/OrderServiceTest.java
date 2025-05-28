package example.core.order;

import example.core.AppConfig;
import example.core.member.Grade;
import example.core.member.Member;
import example.core.member.MemberService;
import example.core.member.MemberServiceImpl;
import example.core.order.OrderService;
import example.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void  beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();


    }
    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(100);
    }

}
