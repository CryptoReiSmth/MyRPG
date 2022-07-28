public class Skeleton extends Character {
    public Skeleton(int hp, int strength, int agility, int xp, int coins) {
        super("Skeleton", hp, strength, agility, xp, coins);
    }
    public String toString(){
        return "Skeleton:" + "\n\t health points " + this.getHp();
    }
}