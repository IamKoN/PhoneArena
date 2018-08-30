package PhoneFunctions;

import UserFunctions.usersUI;
import RatingFunctions.ratingsUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.*;

public class phoneUI extends JPanel {
    private JButton ratingButton = new JButton("Rating Table");
    private JButton userButton = new JButton("User Table");
    
    private JButton searchButton = new JButton("Search");
    private JButton createButton = new JButton("New...");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton firstButton = new JButton("First");
    private JButton prevButton = new JButton("Previous");
    private JButton nextButton = new JButton("Next");
    private JButton lastButton = new JButton("Last");
    
        //private JTextField fieldID = new JTextField(10);
    private JTextField fieldMK = new JTextField(30);
    private JTextField fieldMD = new JTextField(30);
    private JTextField fieldMM = new JTextField(30);
    private JTextField fieldPR = new JTextField(30);
    private JTextField fieldRM = new JTextField(30);
    private JTextField fieldSC = new JTextField(30);
    private JTextField fieldAR = new JTextField(30);
  
    private phoneBean bean = new phoneBean();
    private boolean admin;

    public phoneUI() {
        setBorder(new TitledBorder (new EtchedBorder(),"Phone Details"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER);
        setFieldData(bean.moveFirst());
    }
    private JPanel initButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        panel.add(userButton);
        userButton.addActionListener(new ButtonHandler());
        panel.add(ratingButton);
        ratingButton.addActionListener(new ButtonHandler());
        
        panel.add(searchButton);
        searchButton.addActionListener(new ButtonHandler());
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

        //fieldID.setEnabled(false);
        //fieldMK.setVisible(false);
        panel.add(new JLabel("make"), "align label");
        panel.add(fieldMK, "wrap");
        panel.add(new JLabel("model"), "align label");
        panel.add(fieldMD, "wrap");
        panel.add(new JLabel("mem"), "align label");
        panel.add(fieldMM, "wrap");
        panel.add(new JLabel("price"), "align label");
        panel.add(fieldPR, "wrap");
        panel.add(new JLabel("ram"), "align label");
        panel.add(fieldRM, "wrap");
        panel.add(new JLabel("screen"), "align label");
        panel.add(fieldSC, "wrap");
        panel.add(new JLabel("AvgR"), "align label");
        panel.add(fieldAR, "wrap");
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
                case "User Table":
                    JFrame f=new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                    f.getContentPane().add(new usersUI(admin));
                    f.setSize(1200, 500);
                    f.setVisible(true);
                    break;
                case "Rating Table":
                    JFrame jf=new JFrame();
                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                    jf.getContentPane().add(new ratingsUI());
                    jf.setSize(1200, 500);
                    jf.setVisible(true);
                    break;
                
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
            case "Save":
                if (isEmptyFieldData()) {
                    JOptionPane.showMessageDialog(null,
                    "Cannot create an empty record");
                    return;
                }
                if (bean.create(p) != null)
                    JOptionPane.showMessageDialog(null,
                    "New user created successfully.");
                createButton.setText("New...");
                break;
            case "New...":
                //p.setID(new Random().nextInt(Integer.MAX_VALUE) + 1);
                p.setMK("");
                p.setMD("");
                p.setMM("");
                p.setPR("");
                p.setRM("");
                p.setSC("");
                p.setAR("");
                setFieldData(p);
                createButton.setText("Save");
                break;
            case "Update":
                if (isEmptyFieldData()) {
                    JOptionPane.showMessageDialog(null,"Cannot update an empty record");
                    return;
                }
                if (bean.update(p) != null)
                    JOptionPane.showMessageDialog(null,"Phone with make:"
                    + String.valueOf(p.getMK() + " is updated successfully"));
                break;
            case "Delete":
                if (isEmptyFieldData()) {
                   JOptionPane.showMessageDialog(null,"Cannot delete an empty record");
                   return;
                }
                p = bean.getCurrent();
                bean.delete();
                JOptionPane.showMessageDialog(null,"Phone with make:"
                + String.valueOf(p.getMK() + " is deleted successfully"));
                break;
            case "First":
                setFieldData(bean.moveFirst()); break;
            case "Previous":
                setFieldData(bean.movePrevious()); break;
            case "Next":
                setFieldData(bean.moveNext()); break;
            case "Last":
                setFieldData(bean.moveLast()); break;
            default:
                JOptionPane.showMessageDialog(null,"invalid command");
         }
      }
   }
}
