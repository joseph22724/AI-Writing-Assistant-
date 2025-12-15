package org.example.controller;

import org.example.model.strategy.StrategyFactory;
import org.example.model.strategy.WritingStrategy;
import org.example.service.APIService;
import org.example.view.MainFrame;
import javax.swing.*;
import javax.swing.JOptionPane;
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

            String userText = MainController.this.view.getInputText();

            if (userText == null || userText.trim().isEmpty()) {

                JOptionPane.showMessageDialog(MainController.this.view,
                        "Cannot accept blank text",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            MainController.this.view.setStatus("Generating, please wait...");
            String mode = MainController.this.view.getSelectedMode();
            String language = MainController.this.view.getSelectedLanguage();

            (new Thread(() -> {
                try {
                    WritingStrategy strategy = StrategyFactory.getStrategy(mode);
                    String finalInstruction = strategy.getSystemInstruction();

                    if (!"English".equals(language)) {
                        finalInstruction += "IMPORTANT: Output the result in " + language;
                    }

                    String result = MainController.this.service.generateText(finalInstruction, userText);

                    SwingUtilities.invokeLater(() -> {
                        MainController.this.view.setOutputText(result);
                        MainController.this.view.setStatus("Success! ");
                    });
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        MainController.this.view.setOutputText("Error: " + ex.getMessage());
                        MainController.this.view.setStatus("Error occurred.");

                    });
                    ex.printStackTrace();
                }
            })).start();
        }
    }
}