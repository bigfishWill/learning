
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Alan on 2018/4/27.
 */
public class Others {
    public static void main(String[] args) {

        Long totalMoney = 1000000L;

        Long totalPrice = 7000L;//分

        BigDecimal percent = BigDecimal.valueOf(85.3);

        BigDecimal inPrice = BigDecimal.valueOf(totalPrice);
        Long money = inPrice.multiply(percent.divide(BigDecimal.valueOf(100))).longValue();
        totalMoney+= money;
        System.out.println("my money get :"+totalMoney);
        System.out.println("haha");
//        iteratorWork();
//        inOutput();


    }

    public static void iteratorWork() {
        List<String> list = new ArrayList<>();
        list.add("一");
        list.add("二");
        list.add("三");
        list.add("四");
        list.add("五");

        //虽然能正常进行，但是容易数组越界错误
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("五")) {
//                list.remove(i);
//            }
//            System.out.println(list.get(i));
//        }

//        for (String obj :
//                list) {
//            if (obj.equals("二")) {
//                list.remove(obj);
//            }
//            System.out.println(obj);
//        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("二")) {
                it.remove();
            }
            System.out.println(str);
        }
    }

    public static void inOutput() {
        Scanner in = new Scanner(System.in);

        System.out.println("what is your name?");
        String name = in.nextLine();

        System.out.println("how old are you?");
        int age = in.nextInt();

        System.out.println("your name is " + name + " and you are " + age + " years old, welcome");
    }
}
