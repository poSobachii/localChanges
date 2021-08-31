package topApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        TopEarnings topEarnings = new TopEarnings();

        for (int i = 0; i < 100; i++) {
            Player p1 = new Player("Alex", i * 10);
            topEarnings.registerPlayer(p1);
        }

        List<Player> topPlayersByBalance = topEarnings.getPlayers();
        System.out.println(topPlayersByBalance.toString());
    }


}


class TopEarnings {

    private List<Player> players = new ArrayList<>();

    public void registerPlayer(Player newPlayer) {
        players.add(newPlayer);
        players.sort(Comparator.comparing(Player::getBalance).reversed());
        if(players.size() > 10) {
            players.remove(10);
        }

    }

    public List<Player> getPlayers() {
        return players;
    }
}


class Player {

    String name;
    int balance;


    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

// 2p 5 , 10
// register list
// display list top 10

