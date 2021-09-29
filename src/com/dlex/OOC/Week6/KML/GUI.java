package com.dlex.OOC.Week6.KML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {


    private JButton selectButton;
    private JButton outputButton;
    private JButton convertButton;
    private JTextField selectTextField;
    private JTextField resultTextField;
    private JLabel infoLabel;


    private String fileLocation;
    private String resultDirectory;

    private GUI () {

        ChooseFile chooseFile = new ChooseFile();
        KML kml = new KML();

        selectButton = new JButton("Select Coordinates");
        selectButton.setBounds(100, 50, 150, 40);
        selectButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        outputButton = new JButton("Select Output");
        outputButton.setBounds(550, 50, 150, 40);
        outputButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        convertButton = new JButton("Convert Now");
        convertButton.setBounds(325, 300, 150,  40);
        convertButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        selectTextField = new JTextField("File Location");
        selectTextField.setBounds(25, 150, 300,  40);
        selectTextField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        selectTextField.setBorder(BorderFactory.createCompoundBorder(selectTextField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        selectTextField.setEditable(false);


        resultTextField = new JTextField("Output Location");
        resultTextField.setBounds(475, 150, 300,  40);
        resultTextField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        resultTextField.setBorder(BorderFactory.createCompoundBorder(resultTextField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        resultTextField.setEditable(false);


        infoLabel = new JLabel();
        infoLabel.setBounds(250, 400, 300,  40);
        infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        infoLabel.setForeground(Color.GREEN);


        JPanel mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(800, 500));
        mainPanel.setBackground(Color.GRAY);
        mainPanel.add(selectButton);
        mainPanel.add(outputButton);
        mainPanel.add(convertButton);
        mainPanel.add(selectTextField);
        mainPanel.add(resultTextField);
        mainPanel.add(infoLabel);

        JFrame mainFrame = new JFrame("Keyhole Markup Language");
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.add(mainPanel);
        mainFrame.pack();


        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File temp = chooseFile.chooseFile();
                    selectTextField.setText(temp.toString());
                    fileLocation = temp.toString();
                } catch (Exception err) {
                    System.err.println(err.toString());
                }

            }
        });

        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File temp = chooseFile.chooseDirectory();
                    resultTextField.setText(temp.toString());
                    resultDirectory = temp.toString();
                } catch (Exception err) {
                    System.err.println(err.toString());
                }
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!fileLocation.isEmpty() && !resultDirectory.isEmpty()) {
                        kml.ReadFile(fileLocation, resultDirectory);
                        infoLabel.setText("");
                        infoLabel.setText("Convert Successful");
                    }
                } catch (Exception err) {
                    System.err.println(err.toString());
                    infoLabel.setText("You have to select file and output directory");
                }
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }

    private static class ChooseFile {

        private JFrame frame;
        private JFileChooser chooser = new JFileChooser();

        ChooseFile() {
            frame = new JFrame();
            frame.setVisible(false);
            BringToFront();
        }

        File chooseFile() {
            if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
                frame.setVisible(false);
                return chooser.getSelectedFile();
            }
            return null;
        }


        File chooseDirectory() {
            chooser.setApproveButtonText("Choose directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
                frame.setVisible(false);
                return chooser.getSelectedFile();
            }
            return null;
        }

        private void BringToFront() {
            frame.setExtendedState(JFrame.ICONIFIED);
            frame.setExtendedState(JFrame.NORMAL);
        }

    }
}
