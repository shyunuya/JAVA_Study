package practice;

public class InterfaceTest2 {
    public static void main(String[] args) {
        A a = new A();
        a.autoPlay(new B());
        a.autoPlay(new C());
    }



}

class A {
    void autoPlay(I i) {
        i.play();
    }
}

interface I {
    public abstract void play();
}

class B implements I {
    @Override
    public void play() {
        System.out.println("Play in B class");
    }
}

class C implements I {
    @Override
    public void play() {
        System.out.println("Play in C class");
    }
}
