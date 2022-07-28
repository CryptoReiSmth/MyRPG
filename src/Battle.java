import java.io.IOException;

public class Battle {
    public void fight(Character hero, Character monster, FightCallback fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isEnded = false;
            while (!isEnded) {
                System.out.println("_______________________________________");
                if (turn++ % 2 != 0) {
                    try {
                        isEnded = makeHit(monster, hero, fightCallback);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        isEnded = makeHit(hero, monster, fightCallback);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Character defender, Character attacker, FightCallback fightCallback) throws IOException {
        int hit = attacker.attack();
        defender.setHp(defender.getHp() - hit);
        if (hit != 0) {
            System.out.println(attacker.getName() + " hit " + hit + " points");
            System.out.println(defender.getName() + " has " + defender.getHp() + " health points left");
        } else {
            System.out.println(attacker.getName() + " missed!");
        }

        if (defender.getHp() == 0 && defender instanceof Hero) {
            fightCallback.fightLost();
            return true;
        } else if(defender.getHp() == 0 && !(defender instanceof Hero)) {
            System.out.println("Enemy is dead! " + attacker.getName() + " receive " + defender.getXp() + " experience points, " + defender.getCoins() + " coins.");
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setCoins(attacker.getCoins() + defender.getCoins());
            fightCallback.fightWin();
            return true;
        } else return false;
    }
}
