package example.core.autowired;

import example.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowireTest {

    @Test
    public void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    public static class TestBean{

        @Autowired(required = false)
        public void setBean1(Member member){
            System.out.println("member1 = " + member);
        }
        @Autowired
        public void setBean2(@Nullable Member member){
            System.out.println("member2 = " + member);
        }
        @Autowired
        public void setBean3(Optional<Member> member){
            System.out.println("member3 = " + member );
        }

    }
}
