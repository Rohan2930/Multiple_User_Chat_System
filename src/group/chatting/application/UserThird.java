package group.chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.*;

public class UserThird extends JFrame implements ActionListener, Runnable{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    
    BufferedWriter writer;
    BufferedReader reader;

    UserThird(){
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("group/chatting/application/icons/3.png"));
       Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(5, 17, 30, 30);
       p1.add(l1);
       
       l1.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent ae){
               System.exit(0);
           }
       });
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("group/chatting/application/icons/mirzapur.png"));
       Image i5 = i4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel l2 = new JLabel(i6);
       l2.setBounds(30, 3, 60, 60);
       p1.add(l2);
       
       ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("group/chatting/application/icons/video.png"));
       Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel l5 = new JLabel(i9);
       l5.setBounds(180, 20, 30, 25);
       p1.add(l5);
       
       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("group/chatting/application/icons/phone.png"));
       Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
       ImageIcon i13 = new ImageIcon(i12);
       JLabel l6 = new JLabel(i13);
       l6.setBounds(230, 20, 30, 30);
       p1.add(l6);
       
       ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("group/chatting/application/icons/3icon.png"));
       Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
       ImageIcon i16 = new ImageIcon(i15);
       JLabel l7 = new JLabel(i16);
       l7.setBounds(276, 20, 25, 35);
       p1.add(l7);
       
       
       JLabel l3 = new JLabel("Mirzapur");
       l3.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       l3.setForeground(Color.WHITE);
       l3.setBounds(84, 12, 100, 18);
       p1.add(l3);  
       
       
       JLabel l4 = new JLabel("Bablu, Guddu, Kaaleen, Sweety, IG Dubey, Shukla");
       l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 10));
       l4.setForeground(Color.WHITE);
       l4.setBounds(85, 34, 90, 17);
       p1.add(l4); 
       
       a1 = new JTextArea();
       a1.setBounds(1, 71, 298, 517);
       a1.setBackground(Color.black);
       a1.setForeground(Color.white);
       a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       a1.setEditable(true);
       a1.setLineWrap(true);
       a1.setWrapStyleWord(true);
       add(a1);
       
       
       t1 = new JTextField();
       t1.setBounds(2, 590, 220, 40);
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       add(t1);
       
       b1 = new JButton("Send");
       b1.setBounds(225, 590, 75, 40);
       b1.setBackground(new Color(7, 94, 84));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       b1.addActionListener(this);
       add(b1);
        
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setSize(300, 630);
       setLocation(623, 20); 
       setUndecorated(true);
       setVisible(true);
       
       try{
           
           Socket socketClient = new Socket("localhost", 2003);
           writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
           reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
       }catch(Exception e){}
       
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String str = "message from Bablu Bhaiya :\n"+t1.getText();
        try{
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        }catch(Exception e){}
        t1.setText("");
    }
    
    public void run(){
        try{
            String msg = "";
            while((msg = reader.readLine()) != null){
                a1.append(msg + "\n");
            }
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        UserThird one = new UserThird();
        Thread t1 = new Thread(one);
        t1.start();
    }
    
}