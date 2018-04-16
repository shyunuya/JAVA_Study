package practice;

public class InterfaceTest3 {
    public static void main(String[] args) {
        Aa a = new Aa();
        a.methodA();
    }

}

class Aa {
    void methodA() {
        I2 i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}

interface I2 {
    public abstract void methodB();
}

class Bb implements I2 {
    public void methodB() {
        System.out.println("methodB in B class");
    }

    public String toString() {
        return "class B";
    }
}

class InstanceManager {
    public static I2 getInstance() {
        return new Bb();
    }
}
