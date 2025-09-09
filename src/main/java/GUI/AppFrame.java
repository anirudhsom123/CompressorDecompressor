package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {
    JButton CompressButton;
    JButton DecompressButton;
    AppFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CompressButton=new JButton("SELECT File to Compress");
    CompressButton.setBounds(20,100,200,30);
    DecompressButton=new JButton("Selct file to decompress");
    DecompressButton.setBounds(250,100,200,30);

    this.add(CompressButton);
    this.add(DecompressButton);
    this.setSize(1000,500);
    this.getContentPane().setBackground(Color.green);
    this.setVisible(true);
    }
    @Override
    public  void actionPerformed(ActionEvent e){

    }

}