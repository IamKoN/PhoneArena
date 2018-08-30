/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserFunctions;

import javax.swing.*;
import java.awt.*;

public class usersMain {
   
   public static void main(String[] args) {
      boolean isAdmin;
      JFrame f=new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
      f.getContentPane().add(new usersUI(isAdmin));
      f.setSize(600, 300);
      f.setVisible(true);
   }
}