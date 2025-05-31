package example.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    public void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        bean1.addCount();
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        bean2.addCount();

        Assertions.assertThat(bean1.getCount()).isEqualTo(1);
        Assertions.assertThat(bean2.getCount()).isEqualTo(1);


    }

    @Test
    public void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(CLientBean.class, PrototypeBean.class);
        CLientBean bean1 = ac.getBean(CLientBean.class);
        int count1 = bean1.logic();
        CLientBean bean2 = ac.getBean(CLientBean.class);
        int count2 = bean2.logic();

        Assertions.assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
    public static class CLientBean{

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanPrivider;

        public int logic(){
            // getObject를 호출하면 그때서야 스프링컨테이너에서 프로토타입빈을 찾아서 반환함
            PrototypeBean prototypeBean = prototypeBeanPrivider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    public static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count++;

        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }

    }
}
