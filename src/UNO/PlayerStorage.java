package UNO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusufals on 14/09/2018.
 */
public class PlayerStorage {

    private List<Player> playerDatabase = new ArrayList<Player>();



    public PlayerStorage(){

        Player player1= new Player();
        Player player2= new Player();
        Player player3= new Player();
        Player player4= new Player();
        Player player5= new Player();
        Player player6= new Player();
        Player player7= new Player();
        Player player8= new Player();
        Player player9= new Player();
        Player player10= new Player();


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



    public Player getFirstPlayer(){
        Player x= playerDatabase.get(0);
        playerDatabase.remove(0);
        return x;
    }

    public int getSizeOfDatabase(){
        return playerDatabase.size();
    }
    }









