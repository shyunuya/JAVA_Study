package practice;

public class RepairableTest {
    public static void main(String[] args) {
        Tank t = new Tank();
        Dropship d = new Dropship();
        Marine m = new Marine();

        SCV s = new SCV();

        s.repair(t);
        s.repair(d);
        //s.repair(m);

    }
}

interface Repairable {}

class Units {
    int hitPoint;
    final int MAX_HP;
    Units(int hp) {
        MAX_HP = hp;
    }
}

class GroundUnit extends Units {
    GroundUnit (int hp) {
        super(hp);
    }
}

class AirUnit extends Units {
    AirUnit (int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
}

class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125);
        hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "Dropship";
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
}

class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r) {
        if (r instanceof Units) {
            Units u = (Units) r;
            while (u.hitPoint != u.MAX_HP) {
                u.hitPoint ++;
            }
            System.out.println(u.toString() + " repaired completely, good");
        }
    }
}


