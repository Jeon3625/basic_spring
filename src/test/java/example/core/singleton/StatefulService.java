package example.core.singleton;

// 컨트룰 쉬프트 t 누르면 테스트 만들어짐
public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제다.
    }

    public int getPrice(){
        return price;
    }
}
