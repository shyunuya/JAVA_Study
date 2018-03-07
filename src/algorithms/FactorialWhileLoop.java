package algorithms;

public class FactorialWhileLoop {

    public static void main(String[] args) {
        int answer = factorial(3);
        System.out.println("answer = " + answer);
    }


    static int factorial(int n) {
        int result = 1;
        while (n != 0) {
            result *= n--;
        }
        return result;
    }
}
