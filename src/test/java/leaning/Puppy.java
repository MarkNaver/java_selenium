package leaning;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午2:17 2018/10/17
 * @Modified By:
 */
public class Puppy {
    private Puppy(String name) {
        System.out.println("小狗的名字是：" + name);
    }

    String string = "hello";

    static String string1 = "q";


    public static void main(String[] args) {
        Puppy myPuppy = new Puppy("fdsfsfsd");
    }
}
