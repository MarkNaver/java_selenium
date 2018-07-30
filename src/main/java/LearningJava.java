public class LearningJava {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        LearningJava hello = new LearningJava();
        int a = hello.psd();
//    int a = psd();
        System.out.println(a);
        String b = hello.str();
        System.out.println(b);
        String str1 = str();
        System.out.println(str1);

        String str3 = new  Test1().method();
        System.out.println();

        int num = 5;
        int result = 1;
        for (int i = num; i > 0; i--) {
            result *= i;
        }
        System.out.println(result);
    }

    public int psd(){
        return 11111;
    }

    public static String str(){
        return "abc";
    }
    public static int str1(int a, int b){
        return a+b;
    }
}
class Test1{
    public String method(){
        System.out.println("hello1");
        return "hello2";
    }
}
