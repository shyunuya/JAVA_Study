package practice;

public class CastingTest {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
        //cat.water() <----Compile error. reference variable can't call water()
        fe2 = (FireEngine)car;
        fe2.water();

    }
}

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("Drive,Brrrrr!!!");
    }

    void stop() {
        System.out.println("Stop!!!!!");
    }

}

class FireEngine extends Car {
    void water() {
        System.out.println("Water!!!!!");
    }
}