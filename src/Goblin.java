public class Goblin extends Character {
    public Goblin(int hp, int strength, int agility, int xp, int coins) {
        super("Goblin", hp, strength, agility, xp, coins);
    }
    public String toString(){
        return "Goblin:" + "\n\t health points " + this.getHp();
    }
}
