package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextArea inputArea;
    private JTextArea outputArea;
    private JComboBox<String> modeSelector;
    private JButton generateButton;
    private JLabel statusLabel;

    public MainFrame(){

        setTitle("AI Writing Assistant" );
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10 ));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Select Mode:"));

        String[] modes = {"Professional", "Creative", "Academic", "Grammar Check"};
        modeSelector = new JComboBox<>(modes);

        topPanel.add(modeSelector);

        generateButton = new JButton("Rewrite Text");
        topPanel.add(generateButton);

        add(topPanel, BorderLayout.NORTH);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.5);


        inputArea = createTextArea("Enter your text here");
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Input Text"));
        splitPane.setLeftComponent(inputScroll);


        outputArea = createTextArea("Result");
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createTitledBorder("AI Output"));
        splitPane.setRightComponent(outputScroll);

        add(splitPane, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel("Ready");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);
    }


    private JTextArea createTextArea(String placeholder){
        JTextArea area = new JTextArea();
         area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setText(placeholder);
        return area;
    }

    public String getInputText() {return inputArea.getText();}
    public void setOutputText(String text) {outputArea.setText(text) ;}
    public String getSelectedMode() {return (String) modeSelector.getSelectedItem();}
    public void setStatus(String text) {statusLabel.setText(text); }


    public void addGenerateListener(ActionListener listener){
        generateButton.addActionListener(listener);
    }
}