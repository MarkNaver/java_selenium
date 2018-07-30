package com.config.selenium;
public class SeleniumHaaaaaa {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        SeleniumHaaaaaa hello = new SeleniumHaaaaaa();
        int a = hello.psd();
//    int a = psd();
        System.out.println(a);
        String b = hello.str();
        System.out.println(b);
        String str1 = str();
        System.out.println(str1);

        String str3 = new Test1().method(3);
        System.out.println(str3);
    }

    public int psd(){
        System.out.println("123123");
        return 111111;
    }

    public static String str(){
        return "abc";
    }
    public static int str1(int a, int b){

        return a+b;
    }
}


class Test1{
    public String method(int a){
        System.out.println("hello1:" + a);
//        return "hello2";
        return null;
    }

    public static void main(String[] args) {
        Test1 test = new Test2();
        test.method(3333);

    }
}


class Test2 extends Test1{
    @Override
    public String method(int a) {
        System.out.println("tcw");
//        return "tcw";
        return null;
    }
}
