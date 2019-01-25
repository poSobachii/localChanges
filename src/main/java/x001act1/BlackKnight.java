package x001act1;

public class BlackKnight {
    public static short totalKnights;
    public static short aliveKnights;
    public static short deadKnights;
    public static BlackKnight[] knights;


    public String name;
    public byte arms;
    public byte legs;
    public byte head;
    public boolean alive;

    public static void setBattle (int initialNumber) {
        totalKnights = 0;
        aliveKnights = 0;
        deadKnights = 0;
        knights = new BlackKnight[initialNumber];
    }

    public BlackKnight(String name) {
        this.name = name;
        this.arms = 2;
        this.legs = 2;
        this.head = 1;
        this.alive = true;
        totalKnights++;
        aliveKnights++;
        for (int i = 0; i < knights.length; i++) {
            if (knights[i] == null) {
                knights[i] = this;
                break;
            }
        }
    }

    public String cutOffArm() {
        if (alive == false) {
            return "Only chicken beats dead!";
        } else if (this.arms != 0) {
            this.arms -=1;
            return "Bugger!";
        } else {
            return "Haah!";
        }
    }

    public String cutOffLeg() {
        if (alive == false) {
            return "Only chicken beats dead!";
        } else if (this.legs != 0) {
            this.legs -=1;
            return "Bollocks!";
        } else {
            return "Haah!";
        }
    }

    public String cutOffHead() {

        if(this.alive) {
            this.head --;
            this.alive = false;
            aliveKnights--;
            deadKnights++;
            if(aliveKnights > 0) {
                String names = "";
                for(int i = 0; i < knights.length; i++) {
                    if(knights[i].alive) {
                        if(names.isEmpty()) {
                            names += knights[i].name;
                        } else {
                            names += ", " + knights[i].name;
                        }
                    }
                }
                return "You'l newer win! " + names + " will still fight!";
            }
            return "You'l burn in hell forever!";
        }
        return "Only chicken beats dead!";
    }


    @Override
    public String toString() {
        return "BlackKnight{" +
                "name='" + name + '\'' +
                ", arms=" + arms +
                ", legs=" + legs +
                ", head=" + head +
                ", alive=" + alive +
                '}';
    }

}
