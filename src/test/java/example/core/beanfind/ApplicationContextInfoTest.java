package example.core.beanfind;

import example.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean(){
        String[] BN = ac.getBeanDefinitionNames();
        for(String Bn : BN){
            Object bean = ac.getBean(Bn);
            System.out.println("name = " + Bn + " Object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] BN = ac.getBeanDefinitionNames();
        for(String Bn : BN){
            BeanDefinition BD = ac.getBeanDefinition(Bn);

            if(BD.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(Bn);
                System.out.println("name = " + Bn + " Object = " + bean);
            }
        }
    }
}
