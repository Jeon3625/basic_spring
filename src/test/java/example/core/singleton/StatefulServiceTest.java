package example.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    public void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB : B사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        // 이러면 결과눈?
        int price = statefulService1.getPrice();

        // 만원이 나올줄 알았는데 B의 영향으로 2만원이 되었다.
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

        // 위 같은 문제가 생긴다 그래서 지역변수를 이용해서 인스턴스가 공유 안되게끔 해야함
        // 그럼 StatefilService의 order 함수를 int return 식으로 바꾸고 Test에서는 지역변수에 할당

    }

    @Configuration
    public static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}