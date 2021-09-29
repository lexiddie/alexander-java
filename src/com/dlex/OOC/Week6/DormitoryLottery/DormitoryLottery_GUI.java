package com.dlex.OOC.Week6.DormitoryLottery;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DormitoryLottery_GUI {

    private final Color[] colors = {Color.GREEN, Color.RED, Color.BLUE};
    private final JPanel mainPanel;

    private DormitoryLottery_GUI() {

        mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(500, 500));
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2 ));

        JFrame mainFrame = new JFrame("Dormitory Lottery");
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.add(mainPanel);
        mainFrame.pack();

        int count = 0;
        while (count < 3) {
            count += 1;
            generateCards();
        }

    }

    public static void main(String[] args) {
        new DormitoryLottery_GUI();
    }

    private JButton randomCard(int value, int color) {
        JButton btn = new JButton(String.valueOf(value));
        btn.setForeground(Color.white);
        btn.setMargin(new Insets(20, 20, 20, 20));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btn.setBackground(colors[color]);
        btn.setPreferredSize( new Dimension(100,200));
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(true);
        btn.setFocusPainted(false);
        return btn;
    }

    private void generateCards() {
        Random random = new Random();
        int temp = random.nextInt(3);
        int value = random.nextInt(6) + 10;
        mainPanel.add(randomCard(value, temp));
    }
}


