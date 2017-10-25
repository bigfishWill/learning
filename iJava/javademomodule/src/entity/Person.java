package entity;

/**
 * Created by LiuQu on 2017/10/25.
 */
public class Person {
    private String name;

    private Integer order;

    public Person(String name,Integer order){
        this.name=name;
        this.order=order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
