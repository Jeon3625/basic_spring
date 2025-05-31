package example.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);

        System.out.println("find prototypeBean1");
        prototypeBean bean1 = ac.getBean(prototypeBean.class);
        System.out.println("find prototypeBean2");
        prototypeBean bean2 = ac.getBean(prototypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);


        // close를 넣어도 안뜬다 왜?   이름 그대로 프로토타입 쓰고 버려버림
        ac.close();
        // 꼭 해야겠다면 bean1.destroy()  이런식으로
    }

    @Scope("prototype")
    public static class prototypeBean{

        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototype.destroy");
        }
    }
}
