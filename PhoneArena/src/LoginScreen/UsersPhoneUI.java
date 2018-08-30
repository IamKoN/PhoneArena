/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import PhoneFunctions.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.*;

public class UsersPhoneUI extends JPanel {  
    private JButton searchButton = new JButton("Search");
    private JButton ratingButton = new JButton("Rate Phone");
    private JButton firstButton = new JButton("First");
    private JButton prevButton = new JButton("Previous");
    private JButton nextButton = new JButton("Next");
    private JButton lastButton = new JButton("Last");
 
    private JTextField fieldMK = new JTextField(30);
    private JTextField fieldMD = new JTextField(30);
    private JTextField fieldMM = new JTextField(30);
    private JTextField fieldPR = new JTextField(30);
    private JTextField fieldRM = new JTextField(30);
    private JTextField fieldSC = new JTextField(30);
    private JTextField fieldAR = new JTextField(30);
  
    private phoneBean bean = new phoneBean();
    String userN;
    
    public UsersPhoneUI(String userN) {
        this.userN = userN;
        setBorder(new TitledBorder (new EtchedBorder(),"Phone Details"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER);
        setFieldData(bean.moveFirst());
    }
    private JPanel initButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        panel.add(searchButton);
        searchButton.addActionListener(new ButtonHandler());
        panel.add(firstButton);
        firstButton.addActionListener(new ButtonHandler());
        panel.add(prevButton);
        prevButton.addActionListener(new ButtonHandler());
        panel.add(nextButton);
        nextButton.addActionListener(new ButtonHandler());
        panel.add(lastButton);
        lastButton.addActionListener(new ButtonHandler());
        panel.add(ratingButton);
        ratingButton.addActionListener(new ButtonHandler());
        
        return panel;
  
   }
    private JPanel initFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        //fieldID.setEnabled(false);
        //fieldMK.setVisible(false);
        panel.add(new JLabel("make"), "align label");
        panel.add(fieldMK, "wrap");
        fieldMK.setEnabled(false);
        
        panel.add(new JLabel("model"), "align label");
        panel.add(fieldMD, "wrap");
        fieldMD.setEnabled(true);
        
        panel.add(new JLabel("mem"), "align label");
        panel.add(fieldMM, "wrap");
        fieldMM.setEnabled(false);
        
        panel.add(new JLabel("price"), "align label");
        panel.add(fieldPR, "wrap");
        fieldPR.setEnabled(false);
        
        panel.add(new JLabel("ram"), "align label");
        panel.add(fieldRM, "wrap");
        fieldRM.setEnabled(false);
        
        panel.add(new JLabel("screen"), "align label");
        panel.add(fieldSC, "wrap");
        fieldSC.setEnabled(false);
        
        panel.add(new JLabel("AvgR"), "align label");
        panel.add(fieldAR, "wrap");
        fieldAR.setEnabled(false);
        return panel;
    }
    private phone getFieldData() {
        phone p = new phone();
        //p.setID(Integer.parseInt(fieldID.getText()));
        p.setMK(fieldMK.getText());
        p.setMD(fieldMD.getText());
        p.setMM(fieldMM.getText());
        p.setPR(fieldPR.getText());
        p.setRM(fieldRM.getText());
        p.setSC(fieldSC.getText());
        p.setAR(fieldAR.getText());
        return p;
    }
    private void setFieldData(phone p) {
        //fieldID.setText(String.valueOf(p.getID()));
        fieldMK.setText(p.getMK());
        fieldMD.setText(p.getMD());
        fieldMM.setText(p.getMM());
        fieldPR.setText(p.getPR());
        fieldRM.setText(p.getRM());
        fieldSC.setText(p.getSC());
        fieldAR.setText(p.getAR());
    }
    private boolean isEmptyFieldData() {
        return (fieldMK.getText().trim().isEmpty()
            && fieldMD.getText().trim().isEmpty()
            && fieldMM.getText().trim().isEmpty()
            && fieldPR.getText().trim().isEmpty()
            && fieldRM.getText().trim().isEmpty()
            && fieldSC.getText().trim().isEmpty()
            && fieldAR.getText().trim().isEmpty());
    }
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            phone p = getFieldData();
            switch (e.getActionCommand()) {
                case "Search":                   
                    if (isEmptyFieldData()) {
                        JOptionPane.showMessageDialog(null,
                        "Cannot search for an empty record");
                        return;
                    }
                    if (bean.searchPhone(p) != null) {
                        setFieldData(bean.searchPhone(p));
                        JOptionPane.showMessageDialog(null,"Phone with model: "
                        + String.valueOf(p.getMD() + " was located successfully"));
                    } else
                        JOptionPane.showMessageDialog(null,"Phone with model: "
                        + String.valueOf(p.getMD() + " was not located"));
                    break;
            case "First":
                setFieldData(bean.moveFirst()); break;
            case "Previous":
                setFieldData(bean.movePrevious()); break;
            case "Next":
                setFieldData(bean.moveNext()); break;
            case "Last":
                setFieldData(bean.moveLast()); break;
            case "Rate Phone":
                JFrame f=new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                f.getContentPane().add(new UserRatingUI(userN));
                f.setSize(1200, 500);
                f.setVisible(true);
                
                //NewJFrame njf = new NewJFrame();
                //njf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //njf.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                //njf.getContentPane().add(new NewJFrame()));
               // njf.setSize(1200, 500);
                //njf.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null,"invalid command");
         }
      }
   }
    private class NewJFrame extends javax.swing.JFrame {
        //Connection conn=null;
        //PreparedStatement pst=null;
        //ResultSet rs=null;
        private javax.swing.JComboBox<String> Select1;
        private javax.swing.JComboBox<String> Select2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTable phone1;
        private javax.swing.JTable phone2;
        
        phone p = getFieldData();

        private NewJFrame() {
            setBorder(new TitledBorder (new EtchedBorder(),"Phone Comparison"));
            setLayout(new BorderLayout(5, 5));
            //add(initComponents(), BorderLayout.CENTER);
        try{   
             /*initComponents();
             //Fills combobox 1&2
             String sql = "Select * from phone";
             String model = rs.getString("model");
             String make = rs.getString("make");
             String price = rs.getString("price");
             String ram = rs.getString("ram");
             String screen = rs.getString("screen");
             String mem = rs.getString("mem");
             String avgRating = rs.getString("avgRating");
             pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
             */
            try{
                while(bean.rowSet.next()){
                     Select1.addItem(p.getMD());
                     Select2.addItem(p.getMD());
                }
            } catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        } catch(Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE,null, ex);
        }  
    }
            
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        phone1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        phone2 = new javax.swing.JTable();
        Select1 = new javax.swing.JComboBox<>();
        Select2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        phone1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(phone1);

        phone2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(phone2);

        Select1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tom", "bob" }));
        Select1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select1ActionPerformed(evt);
            }
        });

        Select2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(Select1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Select2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Select1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Select2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>                        

        private void Select1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
            try {
                //DefultTableModel model = (DefultTableModel) phone1.getModel();
                //String sql2 = "Select * from phone where model =" + Select1.toString();
                //bean.rowSet.setCommand(sql2);
                //bean.rowSet.execute();
                phone1.setValueAt(bean.rowSet.getString("make"), 1, 1);
                phone1.setValueAt(bean.rowSet.getString("model"),2, 1);
                phone1.setValueAt(bean.rowSet.getString("price"), 3, 1);
                phone1.setValueAt(bean.rowSet.getString("ram"), 1, 4);
                phone1.setValueAt(bean.rowSet.getString("screen"), 5, 1);
                phone1.setValueAt(bean.rowSet.getString("mem"), 6, 1);
                phone1.setValueAt(bean.rowSet.getString("avgRating"), 7, 1);
            } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }                                       
    }
}