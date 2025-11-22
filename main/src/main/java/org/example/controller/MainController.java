package org.example.controller;

import org.example.model.strategy.StrategyFactory;
import org.example.model.strategy.WritingStrategy;
import org.example.service.APIService;
import org.example.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final MainFrame view;
    private final APIService service;

    public MainController(MainFrame view, APIService service) {
        this.view = view;
        this.service = service;


        this.view.addGenerateListener(new GenerateAction());
    }


    class GenerateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            view.setStatus("Generating, please wait...");

            // gets data from view
            String userText = view.getInputText() ;
            String mode = view.getSelectedMode();

            // Run on a background thread (so gui doesn't freeze)
            new Thread(() -> {
                try {
                    WritingStrategy strategy = StrategyFactory.getStrategy(mode);

                    // call API
                    String result = service.generateText(strategy.getSystemInstruction(), userText);

                    SwingUtilities.invokeLater(() -> {
                        view.setOutputText(result);
                        view.setStatus("Success! ");
                    });

                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        view.setOutputText("Error: " + ex.getMessage() );
                        view.setStatus("Error occurred.");

                    });
                    ex.printStackTrace();
                }
            }).start();
        }
    }
}