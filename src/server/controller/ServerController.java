package server.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import server.model.Player;
import server.model.Serve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerController extends Thread
{
    @FXML
    Button terminate;
    private static int PORT = 5000;
    public static ServerSocket server;
    public static List<Player> players = new ArrayList<>();

    public void init()
    {
        try
        {
            server = new ServerSocket(PORT);
            //System.out.println("This is the TCP server.");
            int playerId = 0;
            while (!terminate.isPressed())
            {
                //get a new client.
                Socket clientSock = server.accept();

                //make a player from the client and add the player to the players linked list.
                Player p = new Player(clientSock, playerId++);
                players.add(p);

                //start a thread to serve the player with
                Serve handleClient = new Serve(p);
                handleClient.start();
            }
            server.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void terminate(ActionEvent actionEvent) throws IOException {
        if (!server.isClosed())
            server.close();
    }
}
