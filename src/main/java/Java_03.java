class VIP{
    private int age;
    private char sex;
    String userName;

    public void setAge(int a) {
        if (a < 0) {
            System.out.println("年龄输入有误");
            age = 0;
        }else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }

    public void setSex(char s) {
        if (s == '男' || s == '女') {
            sex = s;
        }else {
            System.out.println("性别输入错误");
            sex = '男';
        }
    }

    public char getSex() {
        return sex;
    }
}


public class Java_03 {
    public static void main(String[] args) {
        VIP vip = new VIP();
        vip.setAge(-2);
        vip.setSex('牛');
        System.out.println("Age:" + vip.getAge());
        System.out.println("Sex:" + vip.getSex());
    }
}
