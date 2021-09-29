package com.dlex.OOC.Week12.PopularLastName;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PLN_GUI {


    private final JButton selectButton;
    private final JButton outputButton;
    private final JButton extractButton;
    private final JTextField selectTextField;
    private final JTextField resultTextField;
    private final JTextField searchRankTextField;
    private final JTextField searchNameTextField;
    private final JButton searchRankButton;
    private final JButton searchNameButton;
    private final JLabel infoLabel;
    private final JLabel searchLabel;


    private String fileLocation;
    private String resultDirectory;

    private PLN_GUI() {

        ChooseFile chooseFile = new ChooseFile();
        PopularLastName popularLastName = new PopularLastName();

        selectButton = new JButton("Select File");
        selectButton.setBounds(100, 50, 150, 40);
        selectButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        outputButton = new JButton("Select Output");
        outputButton.setBounds(550, 50, 150, 40);
        outputButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        extractButton = new JButton("Extract Now");
        extractButton.setBounds(325, 230, 150,  40);
        extractButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));


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

        searchRankTextField = new JTextField();
        searchRankTextField.setBounds(25, 350, 300,  40);
        searchRankTextField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        searchRankTextField.setBorder(BorderFactory.createCompoundBorder(resultTextField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        searchNameTextField = new JTextField();
        searchNameTextField.setBounds(25, 440, 300,  40);
        searchNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        searchNameTextField.setBorder(BorderFactory.createCompoundBorder(resultTextField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        searchRankButton = new JButton("Search Rank");
        searchRankButton.setBounds(350, 350, 150,  40);
        searchRankButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        searchNameButton = new JButton("Search Name");
        searchNameButton.setBounds(350, 440, 150,  40);
        searchNameButton.setBounds(350, 440, 150,  40);
        searchNameButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        infoLabel = new JLabel();
        infoLabel.setBounds(260, 280, 350,  40);
        infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        infoLabel.setForeground(Color.GREEN);

        searchLabel = new JLabel();
        searchLabel.setBounds(325, 500, 350,  40);
        searchLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        searchLabel.setForeground(Color.GREEN);


        JPanel mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setBackground(Color.GRAY);
        mainPanel.add(selectButton);
        mainPanel.add(outputButton);
        mainPanel.add(extractButton);
        mainPanel.add(selectTextField);
        mainPanel.add(resultTextField);
        mainPanel.add(searchRankTextField);
        mainPanel.add(searchNameTextField);
        mainPanel.add(searchRankButton);
        mainPanel.add(searchNameButton);
        mainPanel.add(infoLabel);
        mainPanel.add(searchLabel);

        JFrame mainFrame = new JFrame("Popular Last Name");
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
                    System.out.println(fileLocation);
                } catch (Exception err) {
                    System.err.println(err);
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
                    System.err.println(err);
                }
            }
        });

        extractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!fileLocation.isEmpty() && !resultDirectory.isEmpty()) {
                        popularLastName.ReadFile(fileLocation, resultDirectory);
                        infoLabel.setText("");
                        infoLabel.setText("Extract Successful");
                    }
                } catch (Exception err) {
                    System.err.println(err);
                    infoLabel.setText("You have to select file and output directory");
                }
            }
        });

        searchRankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (popularLastName.checkData()) {
                    infoLabel.setText("Please select file and extract first before search");
                } else {
                    try {
                        String data = popularLastName.searchByRank(Integer.parseInt(searchRankTextField.getText()));
                        searchLabel.setText("");
                        searchLabel.setText("Rank " + searchRankTextField.getText() + " is " + data);
                    } catch (Exception err) {
                        System.err.println(err);
                        searchLabel.setText("Invalid input, please try again");
                    }
                }
            }
        });

        searchNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (popularLastName.checkData()) {
                    infoLabel.setText("Please select file and extract first before search");
                } else  {
                    try {
                        int data = popularLastName.searchByName(searchNameTextField.getText());
                        infoLabel.setText("");
                        if (data != -1) {
                            searchLabel.setText(searchNameTextField.getText() + " is in the rank of " + data);
                        } else {
                            searchLabel.setText("No Match of this User");
                        }
                    } catch (Exception err) {
                        System.err.println(err);
                        searchLabel.setText("Invalid input, please try again");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new PLN_GUI();
    }

    private static class ChooseFile {

        private final JFrame frame;
        private final JFileChooser chooser = new JFileChooser();

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