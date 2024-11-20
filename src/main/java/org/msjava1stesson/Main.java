package org.msjava1stesson;

import org.msjava1stesson.model.Car;
import org.msjava1stesson.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        byte a = 10;
        short b = 1000;
        int c = 100000;
        long d = 1000_000_000_0L;


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        double dou = 10.1;
        float f = 10.1f;

        System.out.println(dou);
        System.out.println(f);

        boolean boo = true;

        char ch = 'a';
        System.out.println(boo);
        System.out.println(ch);

        String str = "asdsad";
        System.out.println(str);

        int sum = a + c;
        System.out.println(sum);

        System.out.println(add(a, b));
        add(a, b, c);

        Car audi = new Car("amd",2025);
        audi.model = "Q7";
        audi.setModel("A0");
        audi.setYear(9098);
        String au = audi.getInfo();
        System.out.println(au);

        int a1 = 130;
        byte b1 = (byte)a1;
        System.out.println(b1);


        Car audi2 = new Car("amdA",2025, true);
        String au2 = audi2.getInfo();
        System.out.println(au2);

        //CarA aa = new CarA();// Проверь!!!

        var aaa = new Car("",3); // var - smart understand the type and leads it -  не можно потом менять тип, после .
        System.out.println(aaa.getInfo());


        boolean isAdult = isAadult(new User(1));
        System.out.println(isAdult);


        int[] nums = new int[]{1,2,3,4};
        int[] nums1 = new int[2];

        nums1[0] = 1;
        nums1[1] = 2;

        System.out.println(nums);
        System.out.println(nums1);

        System.out.println(Arrays.toString(nums));


        System.out.println(audi);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        for (int ele: list) {
            System.out.println(ele);
        }
        for (int ele: nums) {
            System.out.println(ele);
        }

        String name = "Anna";
        String name1 = name.toUpperCase();
        System.out.println(name);
        System.out.println(name1);

        int[] nu = {1,5,-1,1};
        System.out.println(Arrays.toString(nu));

        Arrays.sort(nu);
        System.out.println(Arrays.toString(nu));

        int[] nu1 = {1,5,-1,1};
        System.out.println(Arrays.toString(nu1));

        Arrays.sort(nu1);
        System.out.println(Arrays.toString(nu1));

        prin();

        for (int i = 0; i <111 ; i++)
        {
            System.out.println(i);
        }

        Integer ia = 1000;
        Integer ib = 1000;

        System.out.println(ia.equals(ib));

        String s1 = "abs";
        String s2 = "ab"+"s";

        String s4 = "ab";

        String s3 = s4+"s";

        System.out.println(s1==s2);


        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        Car carr = new Car("asd", 2222);
        Car carrr = new Car("asdt", 22252);
        System.out.println(carr.equals(carrr)); // Possible redefine equals method in Car.
        final int[] numbs = new int[3];
        numbs[0] = 10;
        System.out.println(numbs);

    }

    private static void prin()
    {
        System.out.println("__--_---____-_---__-");
    }

    private String getSeason(int month)
    {
        String season;
        switch (month) {
            case 1: season = "Winter"; break;
            case 2: season = "Spring"; break;
            case 3: season = "Summer"; break;
            case 4: season = "Fall"; break;
            default: season = "Invalid month";
        }

        return season;
    }

    private String getSeasonLess(int month)
    {


        return switch (month) {
            case 1,2,12  -> "Winter";
            case 3->"Summer";
            case 4->"Fall";
            default -> "Invalid month";
        };
    }

    public static void add(int a, int b, int c) {
        System.out.println("a + b + c");
        System.out.println(a + b + c);
    }

    public static int add(int a, int b) {
        System.out.println("a + b");
        return a + b;
    }

    private static boolean isAadult(User user) {

        return user.getAge()>18;
    }
}