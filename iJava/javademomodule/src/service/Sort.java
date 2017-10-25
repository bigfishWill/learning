package service;

import entity.Person;

import java.util.*;

/**
 * Created by LiuQu on 2017/10/25.
 */
public class Sort {
    public void setListSort() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("David", 2));
        list.add(new Person("John", 1));
        list.add(new Person("Tom", 3));

        //Collections sort method with lambda
        Collections.sort(list, (o1, o2) -> o2.getOrder().compareTo(o1.getOrder()));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

        //use foreach() instead of for()
        list.forEach(item -> System.out.println(item.getName()));

        setMapSort();
    }

    public void setMapSort() {
        //HashMap是无序的
        //TreeMap默认是按key升序的,如果要改变排序方式，则实现Comparator接口的compare方法
//        Map<Integer, String> map = new TreeMap<>();
        Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        map.put(4, "Dog");
        map.put(3, "Cat");
        map.put(9, "Bear");
        map.put(1, "Sheep");
        map.put(2, "Cow");
        map.forEach((k, v) -> System.out.println("key:" + k + " ,value:" + v));


        //实现按照value排序
        List<Map.Entry<Integer,String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,((o1, o2) -> o1.getValue().compareTo(o2.getValue())));
        list.forEach(item->System.out.println("key:" + item.getKey() + " ,value:" + item.getValue()));
    }
}
