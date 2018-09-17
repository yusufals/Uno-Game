package UNO;

import Exceptions.MaxPlayerReachedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusufals on 14/09/2018.
 */
public class PlayerStorage {

    private List<Player> playerDatabase = new ArrayList<Player>();


    public PlayerStorage() {

        Player player1 = new Player("Player One");
        Player player2 = new Player("Player Two");
        Player player3 = new Player("Player Three");
        Player player4 = new Player("Player Four");
        Player player5 = new Player("Player Five");
        Player player6 = new Player("Player Six");
        Player player7 = new Player("Player Seven");
        Player player8 = new Player("Player eight");
        Player player9 = new Player("Player Nine");
        Player player10 = new Player("Player Ten");


        playerDatabase.add(player1);
        playerDatabase.add(player2);
        playerDatabase.add(player3);
        playerDatabase.add(player4);
        playerDatabase.add(player5);
        playerDatabase.add(player6);
        playerDatabase.add(player7);
        playerDatabase.add(player8);
        playerDatabase.add(player9);
        playerDatabase.add(player10);

    }


    public Player getFirstPlayer() {
        Player x = playerDatabase.get(0);
        playerDatabase.remove(0);
        return x;
    }

    public void removePlayerFromGame(Player player)throws MaxPlayerReachedException{
        if(playerDatabase.size()>10){
            throw new MaxPlayerReachedException();
        }else
        playerDatabase.add(player);

    }

    public int getSizeOfDatabase() {
        return playerDatabase.size();
    }
}









