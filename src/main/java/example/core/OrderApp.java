package example.core;

import example.core.member.Grade;
import example.core.member.MemberService;
import example.core.member.MemberServiceImpl;
import example.core.order.Order;
import example.core.order.OrderService;
import example.core.order.OrderServiceImpl;
import example.core.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        순수 java config로 지정해줬을때
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


//      spring으로 bean을 써서 : 스프링 컨테이너 사용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order.toString() = " + order.toString());
    }
}
