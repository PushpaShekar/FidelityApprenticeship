import java.util.Scanner;

class Game {
    private String name;
    private int maxNumPlayers;
    public Game(String name, int maxNumPlayers) {
        this.name = name;
        this.maxNumPlayers = maxNumPlayers;
    }
    public String getName() {
        return name;
    }
    public int getMaxNumPlayers() {
        return maxNumPlayers;
    }

    public String play() {
        return "Game: " + name + ", Maximum Number of Players: " + maxNumPlayers;
    }
}

public class GameProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number of games: ");
        int numberOfGames = sc.nextInt();
        sc.nextLine();

        Game[] games = new Game[numberOfGames];

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("enter the name of the game: ");
            String gameName = sc.nextLine();

            System.out.print("enter the max number of players: ");
            int maxPlayers = sc.nextInt();
            sc.nextLine();

            games[i] = new Game(gameName, maxPlayers);
        }
        System.out.println("\n Games Information: ");
        for(Game game : games) {
            System.out.println(game.toString());
        }
        sc.close();
    }
}
