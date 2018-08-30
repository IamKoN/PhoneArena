
package RatingFunctions;

import javax.swing.*;
import java.awt.*;

public class ratingMain {
   public static void main(String[] args) {
      JFrame f=new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
      f.getContentPane().add(new ratingsUI());
      f.setSize(600, 300);
      f.setVisible(true);
   }
}