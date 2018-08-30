/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import RatingFunctions.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.*;

public class UserRatingUI extends JPanel {  
    private JButton searchButton = new JButton("Search");
    private JButton createButton = new JButton("New...");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton firstButton = new JButton("First");
    private JButton prevButton = new JButton("Previous");
    private JButton nextButton = new JButton("Next");
    private JButton lastButton = new JButton("Last");
    private JButton phoneButton = new JButton("Browse Phones");
    //private JTextField fieldID = new JTextField(10);
    private JTextField fieldID = new JTextField(30);
    private JTextField fieldMK = new JTextField(30);
    private JTextField fieldMD = new JTextField(30);
    private JTextField fieldUN = new JTextField(30);
    private JTextField fieldUR = new JTextField(30);
    //private JTextField fieldCT = new JTextField(30);
    
    //set admin to true of false based on username
    private boolean admin = true;
    String N;
    private UserRatingBean bean = new UserRatingBean(N);

    public UserRatingUI(String N) {
        this.N = N;
        setBorder(new TitledBorder (new EtchedBorder(),"Review Ratings"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER);
        setFieldData(bean.moveFirst());
    }
    private JPanel initButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

        panel.add(phoneButton);
        phoneButton.addActionListener(new ButtonHandler());
        panel.add(createButton);
        createButton.addActionListener(new ButtonHandler());
        panel.add(updateButton);
        updateButton.addActionListener(new ButtonHandler());
        panel.add(deleteButton);
        deleteButton.addActionListener(new ButtonHandler());
        panel.add(firstButton);
        firstButton.addActionListener(new ButtonHandler());
        panel.add(prevButton);
        prevButton.addActionListener(new ButtonHandler());
        panel.add(nextButton);
        nextButton.addActionListener(new ButtonHandler());
        panel.add(lastButton);
        lastButton.addActionListener(new ButtonHandler());
        
        return panel;
   }
    private JPanel initFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        panel.add(new JLabel("id"), "align label");
        panel.add(fieldID, "wrap");
        fieldID.setEnabled(false);
        fieldID.setVisible(false);

        panel.add(new JLabel("make"), "align label");
        panel.add(fieldMK, "wrap");
        fieldMK.setEnabled(false);
    
        panel.add(new JLabel("model"), "align label");
        panel.add(fieldMD, "wrap");
    
        
        panel.add(new JLabel("username"), "align label");
        panel.add(fieldUN, "wrap");
        fieldUN.setEnabled(false);
        
        panel.add(new JLabel("userRating"), "align label");
        panel.add(fieldUR, "wrap");

        return panel;
    }
    private rating getFieldData() {
        rating p = new rating();
        //p.setID(Integer.parseInt(fieldID.getText()));
        p.setID(fieldID.getText());
        p.setMK(fieldMK.getText());
        p.setMD(fieldMD.getText());
        p.setUN(N);
        p.setUR(fieldUR.getText());
        return p;
    }
    private void setFieldData(rating p) {
        //fieldID.setText(String.valueOf(p.getID()));
        fieldID.setText(p.getID());
        fieldMK.setText(p.getMK());
        fieldMD.setText(p.getMD());
        fieldUN.setText(N);
        fieldUR.setText(p.getUR());
    }
    private boolean isEmptyFieldData() {
        return (fieldID.getText().trim().isEmpty()
            && fieldMK.getText().trim().isEmpty()
            && fieldMD.getText().trim().isEmpty()
            && fieldUN.getText().trim().isEmpty()
            && fieldUR.getText().trim().isEmpty());
    }
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            rating p = getFieldData();
            switch (e.getActionCommand()) {
                case "Search":
                    if (isEmptyFieldData()) {
                        JOptionPane.showMessageDialog(null,
                        "Cannot search for an empty record");
                        return;
                    }
                    if (bean.searchRating(p) != null) {
                        setFieldData(bean.searchRating(p));
                        JOptionPane.showMessageDialog(null,"Ratings for model: "
                        + String.valueOf(p.getMD() + " were located successfully"));
                    } else
                        JOptionPane.showMessageDialog(null,"Ratings for model: "
                        + String.valueOf(p.getMD() + " were not located"));
                    break;
                case "Save":
                    if (isEmptyFieldData()) {
                        JOptionPane.showMessageDialog(null, "Cannot create an empty record");
                        return;
                    }
                    if (bean.create(p) != null)
                        JOptionPane.showMessageDialog(null, "New rating created successfully.");
                    createButton.setText("New...");
                    break;
                case "New...":
                    //p.setID(new ().nextInt(Integer.MAX_VALUE) + 1);
                    
                    p.setMK("");
                    p.setMD("");
                    p.setUN(N);
                    p.setUR("");
                    setFieldData(p);
                    createButton.setText("Save");
                    break;
                case "Update":
                    if (isEmptyFieldData()) {
                        JOptionPane.showMessageDialog(null,"Cannot update an empty record");
                        return;
                    }
                    if (bean.update(p) != null)
                        JOptionPane.showMessageDialog(null,"Rating for model:"
                        + String.valueOf(p.getUN() + " was updated successfully"));
                    break;
                case "Delete":
                    if (isEmptyFieldData()) {
                       JOptionPane.showMessageDialog(null,"Cannot delete an empty record");
                       return;
                    }
                    p = bean.getCurrent();
                    bean.delete();
                    JOptionPane.showMessageDialog(null,"Rating for model:"
                    + String.valueOf(p.getUN() + " was deleted successfully"));
                    break;
                case "First":
                    setFieldData(bean.moveFirst()); break;
                case "Previous":
                    setFieldData(bean.movePrevious()); break;
                case "Next":
                    setFieldData(bean.moveNext()); break;
                case "Last":
                    setFieldData(bean.moveLast()); break;
                case "Browse Phones":
                    JFrame f=new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                    f.getContentPane().add(new UsersPhoneUI(N));
                    f.setSize(1200, 500);
                    f.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"invalid command");
         }
      }
   }
}
