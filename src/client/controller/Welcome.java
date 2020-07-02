/*
Author: Manohar
Date: ___DATE__
*/
package client.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Welcome
{
    @FXML
    TextField server_ip1, server_ip2, server_ip3, server_ip4;

    public void init()
    {
        limiterForIP(server_ip1, server_ip2);
        limiterForIP(server_ip3, server_ip4);
    }

    private void limiterForIP(TextField server_ip1, TextField server_ip2) {
        server_ip1.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (server_ip1.getText().length() >= 3) { server_ip1.setText(server_ip1.getText().substring(0, 3));
                }}});
        server_ip2.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (server_ip2.getText().length() >= 3) { server_ip2.setText(server_ip2.getText().substring(0, 3));
                }}});
    }

    public void connect(ActionEvent event)
    {
        
    }

    public void cancel(ActionEvent event)
    {
        System.exit(0);
    }
}
