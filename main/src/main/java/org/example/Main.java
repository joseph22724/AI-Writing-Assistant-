package org.example;

import org.example.controller.MainController;
import org.example.service.APIService;
import org.example.view.MainFrame ;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            MainFrame frame = new MainFrame();

            APIService service = new APIService();

            new MainController(frame, service);

            frame.setVisible(true);
        });
    }
}