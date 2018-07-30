package Learn;

public class Java_err_class {
    public static void main(String[] args) {
        try {
            int a[] = new int[2];
            System.out.println("获取第三个元素" + a[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);;
        }
    }
}
