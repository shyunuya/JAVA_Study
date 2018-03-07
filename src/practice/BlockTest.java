package practice;

public class BlockTest {
    static {
        System.out.println("static block {}");
    }

    {
        System.out.println("Instance block {} ");
    }

    BlockTest() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("BlockTest bt = new BlockTest(); ");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt = new BlockTest(); ");
        BlockTest bt2 = new BlockTest();
    }
}
