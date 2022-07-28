import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Realm {
    private static BufferedReader br = null;
    private static Battle battleScene = null;
    private static Character player = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new Battle();
        System.out.println("Enter hero's name:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                50,
                20,
                10,
                100,
                20
        );
        else return new Skeleton(
                25,
                10,
                20,
                100,
                10
        );
    }

    public static void createNewHero(String name) {
        player = new Hero(
                name,
                60,
                20,
                20,
                0,
                0
        );
        System.out.println("Our new hero is " +  player.getName());
        printChoice();
    }

    private static void commitFight() throws IOException {
        battleScene.fight(player, createMonster(), new FightCallback() {
            public void fightWin() {
                System.out.println(player.getName() + " won!\n" + player);
                System.out.println("Continue fighting? (y/n)");
            }
            public void fightLost() {
                System.out.println("You lost. \n\nEnter new character's name:");
                player = null;
            }
        });
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            createNewHero(string);
        }
        switch (string) {
            case "1" -> commitFight();
            case "2" -> {
                System.out.println("Oooops... Choose smth else.");
                command(br.readLine());
            }
            case "3" -> System.exit(1);
            case "y" -> command("1");
            case "n" -> {
                printChoice();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printChoice() {
        System.out.println("Choose an option");
        System.out.println("1. FIGHT");
        System.out.println("2. Trader");
        System.out.println("3. Exit");
    }

}
