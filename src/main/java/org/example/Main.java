package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.TreeHandler;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow () {
        TreeHandler treeHandler = TreeHandler
                .builder()
                .jsonObjectMapper(new ObjectMapper())
                .build();

        JFrame mainWindow = new JFrame("Jantanathor2000");
        mainWindow.setLayout(new BorderLayout());

        JPanel topSpacer = new JPanel();
        topSpacer.setPreferredSize(new Dimension(1, 300));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton showMessageButton = new JButton("Start Questions");
        showMessageButton.addActionListener(e -> treeHandler.startQuestions(mainWindow) );

        JButton editTreeRules = new JButton("Edit Tree Rules");
        editTreeRules.addActionListener(e -> treeHandler.editTreeRules(mainWindow) );

        JButton editObjective = new JButton("Edit Objectives");
        editObjective.addActionListener(e -> treeHandler.addObjecttiveToTheList(mainWindow) );

        centerPanel.add(showMessageButton);
        centerPanel.add(editTreeRules);
        centerPanel.add(editObjective);

        mainWindow.add(topSpacer, BorderLayout.NORTH);
        mainWindow.add(centerPanel, BorderLayout.CENTER);

        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainWindow.setSize(800, 800);
        mainWindow.setVisible(true);
    }
}