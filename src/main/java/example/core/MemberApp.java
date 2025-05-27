package example.core;

import example.core.member.Grade;
import example.core.member.Member;
import example.core.member.MemberService;
import example.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    // psvm 단축키
    public static void main(String[] args) {

        // config 클래스에서 @Configuration, @Bean 안붙이고 java식으로 DI컨테이너 만들때 이렇게 만들었었음
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


        // spring 생성하는법
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // Appconfig에서 memberService()를 호출할 때, 두번째 인자는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member FM = memberService.findMember(1L);
        // soutv 단축키
        System.out.println("member = " + member.getName());
        System.out.println("FM = " + FM.getName());
    }
}
