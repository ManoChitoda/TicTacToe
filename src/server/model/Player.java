package server.model;

import java.io.*;
import java.net.Socket;

public class Player
{
    public Socket playerSock;
    public DataInputStream in;
    public DataOutputStream out;

    public int playerId;
    public String playerName;
    public int score;

    public Player(Socket playerSock, int playerId) throws IOException
    {
        this.score = 0;
        this.playerSock = playerSock;
        this.playerId = playerId;
        this.playerName = "Player " + this.playerId;
        this.in = new DataInputStream(this.playerSock.getInputStream());
        this.out = new DataOutputStream(this.playerSock.getOutputStream());
    }

    public String toString()
    {
        return this.playerName + " : " + this.score;
    }
}
