package example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//컴포넌트 스캔은 스프링빈을 끌고와서 자동으로 다 올리는 놈
//필터를 쓴 이유는 기존의 AppConfig랑 충돌 날수 있어서 못불러오게 필터링
// 기존의 AppConfig랑 다른점은 @Bean으로 등록된 클래스가 하나도없다.
@Configuration
@ComponentScan(
        basePackages =  "example.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
