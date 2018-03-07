package practice;

public class MemberCall {
    int iv = 10; //instance variable
    static int cv = 20; //class variable

    int iv2 = cv;
    //static int cv2 = iv; // Error. class variable can't use instance variable;
    static int cv2 = new MemberCall().iv;

    static void staticMethod1() {
        System.out.println(cv);
        //System.out.println(iv); //Error. Can't use instance variable in Class method.
        MemberCall c = new MemberCall();
        System.out.println(c.iv);
    }

    void instanceMethod1() {
        System.out.println(cv);
        System.out.println(iv); // can use instance variable directly in instance method.
    }

    static void staticMethod2() {
        staticMethod1();
        //instanceMethod1(); //Error. Instance method can't be called in class method.
        MemberCall c = new MemberCall();
        c.instanceMethod1(); // Can be called after creating instance.
    }

    void instanceMethod2() { // instance method and static method can be called in instance class.
        staticMethod1();
        instanceMethod1();
    }
}
