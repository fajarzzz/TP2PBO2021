package com.tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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

    int row, col;
    DefaultTableModel dtm;
    String[] header = new String[]{"No", "Merk", "Plat", "Warna", "Jenis"};
    Connection connect;

    public App() {
        createUIComponents();
        connectDB();
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
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String merk = merkTb.getText();
                String plat = platTb.getText();
                String warna = warnaTb.getText();
                String jenis = jenisBox.getSelectedItem().toString();

                if(merk.equals("") || plat.equals("") || warna.equals("") || jenis.equals("")){
                    JOptionPane.showMessageDialog(null, "Tidak boleh ada data yang kosong");
                } else {
                    try {
                        PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO mobil" + "  (merk, plat, warna, jenis) VALUES " + " (?, ?, ?, ?);");
                        preparedStatement.setString(1, merk);
                        preparedStatement.setString(2, plat);
                        preparedStatement.setString(3, warna);
                        preparedStatement.setString(4, jenis);
                        preparedStatement.executeUpdate();
                    } catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    merkTb.setText("");
                    platTb.setText("");
                    warnaTb.setText("");
                }
            }
        });
    }

    public void connectDB() {
        try{
            this.connect = (Connection) DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/tp2_java", "root", "");
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }

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
        dataTabel = new JTable();

        dataTabel.setBackground(new Color(225,225,225));
        dataTabel.setBorder(new javax.swing.border.MatteBorder(null));
        dataTabel.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }
        ));

        jenisBox = new JComboBox<>();
        jenisBox.setModel(new DefaultComboBoxModel<>(new String[] { "Biasa", "Balap", "Sport", "Truk" }));


    }
}
