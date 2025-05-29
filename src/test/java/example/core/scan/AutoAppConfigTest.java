package example.core.scan;

import example.core.AutoAppConfig;
import example.core.member.MemberService;
import example.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    public void BasicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);


        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);

    }
}
