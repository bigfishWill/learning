
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyThread t= new MyThread();
        t.start();

//        StringBuilder sb = new StringBuilder(222);
//        pring("000","111");
//
//        Employee employee=new Coder();
//        Object obj = new Coder();
//        Coder coder=new Coder();
//        Coder coder1=new Coder();
//        long aa=coder.hashCode();
//        long bb=obj.hashCode();
//        long dd=coder1.hashCode();
//        Date date = new Date();
//        long cc=date.hashCode();
//        String str1="111";
//        String str2="111";
//        System.out.println(str1.hashCode()+" "+str2.hashCode());
//        pring("000","111");

//        calendarTest();
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, 30);
//        System.out.println(cal.getTime());
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        IdWorker worker2 = new IdWorker(2);
//        int i = 0;
//        while (i < 100) {
//            System.out.println(worker2.nextId());
//            i++;
//        }
//
//        //FixedThreadPool
//        ExecutorService exec = Executors.newFixedThreadPool(5);
//        for (int j = 0; j < 5; j++)
//            exec.execute(new LiftOff());
//        exec.shutdown();
//
//        for (int j = 0; j < 5; j++) {
//            new testFinal().run();
//        }

        //泛型搞搞
//        String middle = ArrayAlg.<String>getMiddle("John", "Q.", "public");
//        System.out.println("middle is :"+middle);
//
//        double dmiddle = ArrayAlg.getMiddle(3.14,1729,0);

//        print("sdf","dsfsd","dsfsd");

        LocalDateTime localDateTime = LocalDateTime.now();
        Long epo = localDateTime.toEpochSecond(ZoneOffset.UTC);
        System.out.println(epo);
        Calendar cal = Calendar.getInstance();
        Long calLong = cal.getTimeInMillis();
        System.out.println(calLong);
        cal.add(Calendar.DATE,-1);
        Long pastLong = cal.getTimeInMillis();
        System.out.println(pastLong);

    }

    public static void print(String... strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        List<String> list = new ArrayList<>();
        List<String> linkList = new LinkedList<>();
        linkList.add("111");
        linkList.add("222");
        for (String ss : linkList) {
            System.out.println(ss);
        }
        Map map = new HashMap();
        if (map.containsKey("aa")) {

        }
    }

    public static void calendarTest() {
        Calendar cal = Calendar.getInstance();

        Long calUtc = cal.getTimeInMillis();//获取utc时间

        Date date = new Date();
        Date date111 = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        cal.add(Calendar.DATE, 1);//往后推一天
        cal.add(Calendar.MONTH, 2);

        System.out.println("Current Date: " + cal.getTime());
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Day of Week: " + dow);
        System.out.println("Day of Month: " + dom);
        System.out.println("Day of Year: " + doy);
    }

    /**
     * 时间
     */
    public static void localtimeTest(){
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(13,15,10);
        LocalDateTime startDate = localDate.atStartOfDay();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        LocalDate d = localDate.withMonth(10);
        LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate secondDayOfMonth = localDate.withDayOfMonth(2);
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate plusDay = lastDayOfMonth.plusDays(1);
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 =
                LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


        System.out.println(localDate);
    }

    /**
     * 排序
     */
    public static void testSort(){
        String a ="a";
        String b="b";
        System.out.println(a.compareTo(b));
    }
    public static class MyThread  extends Thread{
        @Override
        public void run() {
            long beginTime=System.currentTimeMillis();
            int count=0;
            for (int i=0;i<50000000;i++){
                count=count+(i+1);
                Thread.yield();
            }
            long endTime=System.currentTimeMillis();
            System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
        }
    }
}

//
//class Coder extends Employee {
//    private String keyboard;
//
//    public void setKeyboard() {
//        keyboard = "aaa";
//    }
//
//    public boolean equals(Object object) {
//        if (object == null) {
//            return false;
//        }
//        return false;
//    }
//}
//
//class Employee {
//    private String name;
//    private String sex;
//
//}
//
//class LiftOff implements Runnable {
//    protected int countDown = 10;
//    private static int taskCount = 0;
//    private final int id = taskCount++;
//
//    public LiftOff() {
//    }
//
//    public LiftOff(int countDown) {
//        this.countDown = countDown;
//    }
//
//    public String status() {
//        return "#" + id + "(" +
//                (countDown > 0 ? countDown : "Liftoff!") + ").";
//    }
//
//    public void run() {
//        while (countDown-- > 0) {
//            System.out.println(status());
//            Thread.yield();
//        }
//    }
//}
//
//class testFinal {
//    private int j = 0;
//    private int x = j++;
//    private static int i = 0;
//    private final int id = i++;
//
//    public void run() {
//        System.out.println(id);
//    }
//}
//
//class MyException extends Exception {
//    public MyException() {
//
//    }
//
//    public MyException(String message) {
//        super(message);
//    }
//}
//
//class ArrayAlg {
//    public static <T> T getMiddle(T... a) {
//        return a[a.length / 2];
//    }
//}