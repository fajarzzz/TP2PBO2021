package com.tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class App {
    private JPanel Main;
    private JButton formButton;
    private JButton tentangButton;
    private JButton lihatDataButton;
    private JPanel HeaderPanel;
    private JPanel ButtonPanel;
    private JPanel DynamicContainer;
    private JPanel WelcomePanel;
    private JLabel WelcomeLb;
    private JPanel FormPanel;
    private JLabel merkLb;
    private JLabel platLb;
    private JLabel warnaLb;
    private JLabel jenisLb;
    private JComboBox jenisBox;
    private JTextField warnaTb;
    private JTextField merkTb;
    private JTextField platTb;
    private JButton submitButton;
    private JPanel DisplayData;
    private JTable dataTabel;
    private JPanel InfoPanel;
    private JLabel namaLb;
    private JPanel imagePan;
    private JLabel showImage;
    private JLabel nimLb;

    ArrayList<Mobil> arrMobil;
    int row, col;
    DefaultTableModel dtm;
    String[] header = new String[]{"No", "Merk", "Plat", "Warna", "Jenis"};

    public App(){
        createUIComponents();
        arrMobil = new ArrayList<>();
        this.namaLb.setText("Nama : Fajar Zuliansyah Trihutama");
        this.nimLb.setText("NIM   : 1905394");
        dtm = new DefaultTableModel(header, 0);
        dataTabel.setModel(dtm);
        formButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DynamicContainer.removeAll();
                DynamicContainer.repaint();
                DynamicContainer.revalidate();

                DynamicContainer.add(FormPanel);
                DynamicContainer.repaint();
                DynamicContainer.revalidate();
            }
        });
        lihatDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DynamicContainer.removeAll();
                DynamicContainer.repaint();
                DynamicContainer.revalidate();

                DynamicContainer.add(DisplayData);
                DynamicContainer.repaint();
                DynamicContainer.revalidate();
            }
        });
        tentangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DynamicContainer.removeAll();
                DynamicContainer.repaint();
                DynamicContainer.revalidate();

                DynamicContainer.add(InfoPanel);
                DynamicContainer.repaint();
                DynamicContainer.revalidate();
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("App");
        frame.setPreferredSize(new Dimension(350,650));
        frame.setContentPane(new App().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        showImage = new JLabel(new ImageIcon("image\\PAS FOTO BEBAS.jpg"));
    }
}
