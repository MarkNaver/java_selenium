class Woman {
    String name;
    int age;
    char sex;

    public Woman(String myName, int myAge) {
        name = myName;
        age = myAge;
    }

    public void eat() {
        System.out.println(name + "能吃饭");
    }

    public void sleep() {
        System.out.println(name + "能睡觉");
    }

    public void work() {
        System.out.println(name + "能学习");
    }
}

class Man {
    String name;
    int age;
    char sex;

    public Man(String myName, int myAge) {
        name = myName;
        age = myAge;
    }

    public void eat() {
        System.out.println(name + "能吃饭");
    }

    public void sleep() {
        System.out.println(name + "能睡觉");
    }

    public void work() {
        System.out.println(name + "能学习");
    }
}

class People {
    String name;
    int age;

    {
        start();//构造代码块
    }

    People() {
        System.out.println("无参构造");
    }

    public People(String myNmae, int myAge) {
        name = myNmae;
        age = myAge;
        System.out.println("有参构造" + "，姓名：" + name + "，年龄：" + age +"岁");
    }
    public People (int df,int ds){
        System.out.println("123");
    }

    public void eat() {
        System.out.println(name + "能吃饭");
    }

    public void sleep() {
        System.out.println(name + "能睡觉");
    }

    public void work() {
        System.out.println(name + "能学习");
    }

    public String start() {
        System.out.println("初始");
        return "qqqqqq";
    }
    public interface A{
        public void eat();
        public void sleep();
    }
    public interface B{
        public void work();
    }
    public class C implements A,B{

//        @Override
        public void eat() {

        }

//        @Override
        public void sleep() {

        }

//        @Override
        public void work() {

        }
    }

}



class Woman1 extends People {
    //男人类
    public Woman1(String myNmae, int myAge) {
        super(myNmae, myAge);
    }
}

class Man1 extends People {
    //女人类
    public Man1(String myNmae, int myAge) {
        super(myNmae, myAge);
    }
}

class Animal {
    void eat() {
        System.out.println("animal : eat1");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("dog : eat2");
    }
    void eatTest() {
        this.eat();   // this 调用自己的方法
        super.eat();  // super 调用父类方法
    }
}

class Test13 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eatTest();
    }
}




class Print {
    public static void main(String[] args) {
        People a = new People();
        People b = new People("陶春文", 33);
//        Man1 c = new Man1("fd",123);
        People c = new People(1,2);
        String d = a.start();
        System.out.println(d);
    }
}