package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//@SuppressWarnings("serial")
public class Demo1 extends JFrame implements ActionListener,MouseListener{
JButton jb;
   Demo1()
{
    setTitle("Welcome");
    setSize(500,200);
    Container cnt=getContentPane();
    cnt.setLayout(new FlowLayout());
    jb=new JButton("Click me");
    jb.addActionListener(this);
    jb.addMouseListener(this);
    cnt.add(jb);
    setVisible(true);
}
public static void main(String[] args) {
    new Demo1();
}
@Override
public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "You clicked the button");
}
@Override
public void mouseClicked(MouseEvent e) {
    
}
@Override
public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
}
@Override
public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
}
@Override
public void mouseEntered(MouseEvent e) {
    JOptionPane.showMessageDialog(null, "Mouse Entered");
}
@Override
public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
}
}
