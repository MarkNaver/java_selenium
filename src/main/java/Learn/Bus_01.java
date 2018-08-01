package Learn;

class Bus{
    String name;
    String color;
    int wheel;
    public void run(){
        if (wheel == 6) {
            System.out.println("~~~~正在飙车~~~~~~~");
        }else {
            System.out.println("车胎爆炸了，快去修理吧");
        }
    }
}
class Xiulichang{
    String name;
    String tel;
    String address;
    public void repair(Bus bus) throws InterruptedException {
        if (bus.wheel < 6) {
            System.out.println("车已经进了修理厂，正在修理中。。。");
            Thread.sleep(1000);
            System.out.println("预计修理时间3秒。。。");
            Thread.sleep(1000);
            System.out.println("预计修理时间2秒。。。");
            Thread.sleep(1000);
            System.out.println("预计修理时间1秒。。。");
            Thread.sleep(1000);
            bus.wheel = 6;
            System.out.println("车已经修好了，拿去飙车吧");
        }else {
            System.out.println("没坏呢，不修了");
        }
    }
}


public class Bus_01 {
    public static void main(String[] args) throws InterruptedException {
        Bus bus = new Bus();
        bus.wheel = 6;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            bus.run();
        }
        bus.wheel = 5;
        bus.run();
        Thread.sleep(1000);

        //修理厂
        new Xiulichang().repair(bus);
        bus.run();
    }
}
