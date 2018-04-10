package practice;

import java.util.*;

public class PolyArgumentTest3 {
    public static void main(String[] args) {
        Buyer3 b = new Buyer3();
        Tv3 tv = new Tv3();
        Computer3 com = new Computer3();
        Audio3 audio = new Audio3();
        b.buy(tv);
        b.buy(com);
        b.buy(audio);
        b.summary();
        b.refund(com);
        b.summary();

        System.out.println("remaining money = $" + b.money);
        System.out.println("Bonus point = " + b.bonusPoint);
    }

}

class Product3 {
    int price;
    int bonusPoint;

    Product3 (int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }

    Product3() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv3 extends Product3 {
    Tv3() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer3 extends Product3 {
    Computer3() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio3 extends Product3 {
    Audio3 () {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer3 {
    int money = 1000;
    int bonusPoint = 0;
    Vector item = new Vector(); // list of buying products

    void buy (Product3 p) {
        if (money < p.price) {
            System.out.println("no money dude");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println("You bought " + p);

    }

    void refund(Product3 p) {
        if(item.remove(p)) {
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println("you just returned " + p);
        } else {
            System.out.println("you don't have this item in your list");
        }
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        if (item.isEmpty()) {
            System.out.println("Nothing is in your list");
            return;
        }

        // for loop to summarize total spent and items
        for (int i=0; i < item.size(); i++) {
            Product3 p = (Product3)item.get(i);
            sum += p.price;
            itemList += (i==0) ? "" + p : ", " + p;
        }

        System.out.println("Total = $" + sum);
        System.out.println("Items - " + itemList);

    }
}