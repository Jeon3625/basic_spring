package example.core;

import example.core.discount.DiscountPolicy;
import example.core.discount.RateDiscountPolicy;
import example.core.member.MemberRepository;
import example.core.member.MemberService;
import example.core.member.MemberServiceImpl;
import example.core.member.MemoryMemberRepository;
import example.core.order.Order;
import example.core.order.OrderService;
import example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // config 리펙토링 전단계
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
//    }
//


    // 역할을 들어나게 했다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    //역할을 들어나게 했다.
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
