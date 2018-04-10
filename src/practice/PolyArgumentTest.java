package practice;

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Computer());
        System.out.println("remaining = " + b.money);
        System.out.println("Bonus point = " + b.bonusPoint);
    }

}

class Product {
    int price;
    int bonusPoint;

    Product (int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    void buy (Product p) {
        if (money < p.price) {
            System.out.println("no money dude");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + " sold");

    }
}