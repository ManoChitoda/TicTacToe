package client.controller;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientWinController
{
    //CONNECTION VARIABLES.
    private static final int PORT = 5000;
    private static String HOSTNAME;
    private static Socket socket;
    private static DataOutputStream out = null;
    private static DataInputStream in = null;

    @FXML
    Label score;

    public void init()
    {
        this.score.setText("0");
    }

}
