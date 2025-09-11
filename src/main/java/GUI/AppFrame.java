package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton CompressButton;
    JButton DecompressButton;
    AppFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CompressButton=new JButton("SELECT File to Compress");
    CompressButton.setBounds(20,100,200,30);
    CompressButton.addActionListener(this);
    DecompressButton=new JButton("Select file to decompress");
    DecompressButton.setBounds(250,100,200,30);

    DecompressButton.addActionListener(this);
    this.add(CompressButton);
    this.add(DecompressButton);
    this.setSize(1000,500);
    this.getContentPane().setBackground(Color.green);
    this.setVisible(true);
    }
    @Override
    public  void actionPerformed(ActionEvent e){

        if(e.getSource()==CompressButton){
            JFileChooser fileChooser=new JFileChooser();

            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.print(file);

                try{
                    compressor.method(file);
                } catch (Exception x){
                    JOptionPane.showMessageDialog(null,x.toString());
                }
            }
        }

        if(e.getSource()==DecompressButton){
            JFileChooser fileChooser=new JFileChooser();

            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(file);

                try{
                    decompressor.method(file);
                } catch (Exception x){
                    JOptionPane.showMessageDialog(null,x.toString());
                }
            }
        }
    }

}