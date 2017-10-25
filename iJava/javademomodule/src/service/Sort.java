package service;

import entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by LiuQu on 2017/10/25.
 */
public class Sort {
    public void setSort() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("David", 2));
        list.add(new Person("John", 1));
        list.add(new Person("Tom", 3));

        Collections.sort(list, (o1, o2) -> o2.getOrder().compareTo(o1.getOrder()));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }


        list.forEach(item-> System.out.println(item.getName()));
    }
}
