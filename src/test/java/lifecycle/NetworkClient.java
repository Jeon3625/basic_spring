package lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출하는 메소드
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료시
    public void disconnect(){
        System.out.println("close = " + url);
    }


    //의존관계 주입이 끝나면 호출해주겠다.

    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close(){
        disconnect();
    }
}
//public class NetworkClient implements InitializingBean, DisposableBean {
//
//    private String url;
//
//    public NetworkClient(){
//        System.out.println("생성자 호출 url = " + url);
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    // 서비스 시작시 호출하는 메소드
//    public void connect(){
//        System.out.println("connect : " + url);
//    }
//
//    public void call(String message){
//        System.out.println("call : " + url + " message = " + message);
//    }
//
//    // 서비스 종료시
//    public void disconnect(){
//        System.out.println("close = " + url);
//    }
//
//
//    //의존관계 주입이 끝나면 호출해주겠다.
//    @Override
//    public void afterPropertiesSet() throws Exception{
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
//}