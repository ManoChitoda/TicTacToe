/*
Author: Manohar
Date: ___DATE__
*/
package server.model;

import java.util.concurrent.Semaphore;

public class Serve extends Thread
{
    Player p;
    static Player waitingPlayer;

    public Serve(Player p)
    {
        this.p = p;
    }

    @Override
    public void run()
    {
        try
        {
            Semaphore lock = new Semaphore(1);

            //response stores the user's choice: computer or random player.
            String resp = p.in.readUTF();

            if (resp.trim().equalsIgnoreCase("c"))
            {
                //game with the computer and the player starts
                GameWithComp game = new GameWithComp(p);
                game.start();
            }
            else if(resp.trim().equalsIgnoreCase("p"))
            {
                lock.acquire();
                if(waitingPlayer == null)
                {
                    waitingPlayer = p;
                    p.out.writeUTF("Waiting for another player to join; Please wait!");
                    lock.release();
                }
                else
                {
                    GameWithAnotherPlayer game = new GameWithAnotherPlayer(waitingPlayer, p);
                    p.out.writeUTF("Connecting with other player.");
                    waitingPlayer = null;
                    lock.release();
                    game.startGame();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
