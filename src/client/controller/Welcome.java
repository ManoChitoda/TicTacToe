/*
Author: Manohar
Date: ___DATE__
*/
package client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Welcome
{
    @FXML
    TextField server_ip1, server_ip2, server_ip3, server_ip4;

    public void connect(ActionEvent event)
    {

    }

    public void cancel(ActionEvent event)
    {
        System.exit(0);
    }
}
