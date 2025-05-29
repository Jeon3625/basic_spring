package example.core;


import lombok.Getter;
import lombok.Setter;


//롬복 이용하면 간단해짐
@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(19);
        helloLombok.setName("AA");
    }
}
