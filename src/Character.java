public abstract class Character {
    private String name;
    private int hp;
    private int xp;
    private int strength;
    private int agility;
    private int coins;

    Character(String name, int hp, int strength, int agility, int xp, int coins){
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.agility = agility;
        this.xp = xp;
        this.coins = coins;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        if(hp < 0) this.hp = 0;
        else this.hp = hp;
    }

    public int getStrength(){
        return strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getAgility(){
        return agility;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }

    public int getCoins(){
        return coins;
    }
    public void setCoins(int coins){
        this.coins = coins;
    }

    public int getXp(){
        return xp;
    }
    public void setXp(int xp){
        this.xp = xp;
    }

    public int attack(){
        if (agility * 3 > getRandomValue()) return strength;
        else return 0;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    public String toString(){
        return "Character: " + name + "\n\t health points " + hp + "\n\t experience points " + xp + "\n\t coins " + coins;
    }
}
