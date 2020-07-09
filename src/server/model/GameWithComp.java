/*
Author: Manohar
Date: ___DATE__
*/
package server.model;

public class GameWithComp extends Thread
{
    private Player player;

    public GameWithComp(Player player)
    {
        this.player = player;
    }


    @Override
    public void run() {
        super.run();
    }
}
