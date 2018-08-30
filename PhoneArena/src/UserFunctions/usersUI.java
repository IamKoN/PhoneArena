package UserFunctions;

import RatingFunctions.ratingsUI;
import PhoneFunctions.phoneUI;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.*;

public class usersUI extends JPanel {
    private JButton phoneButton = new JButton("Phone Table");
    private JButton ratingButton = new JButton("Rating Table");
    
    private JButton searchButton = new JButton("Search");
    private JButton createButton = new JButton("New...");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton firstButton = new JButton("First");
    private JButton prevButton = new JButton("Previous");
    private JButton nextButton = new JButton("Next");
    private JButton lastButton = new JButton("Last");
    
    private JTextField fieldUN = new JTextField(30);
    private JTextField fieldPW = new JTextField(30);
    private JTextField fieldFN = new JTextField(30);
    private JTextField fieldLN = new JTextField(30);
    private JTextField fieldEM = new JTextField(30);
    private JTextField fieldPN = new JTextField(30);

    //set admin to true of false based on username
    private boolean admin = true;
    private UserFunctions.usersBean bean = new UserFunctions.usersBean();

    public usersUI(boolean a) {
        this.admin = a;
        setBorder(new TitledBorder (new EtchedBorder(),"User Details"));
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
        panel.add(new JLabel("User Name"), "align label");
        panel.add(fieldUN, "wrap");
        //fieldUN.setVisible(admin);
        
        panel.add(new JLabel("Password"), "align label");
        panel.add(fieldPW, "wrap");
        //fieldPW.setVisible(admin);
        
        panel.add(new JLabel("First Name"), "align label");
        panel.add(fieldFN, "wrap");
        //fieldFN.setVisible(admin);
        
        panel.add(new JLabel("Last Name"), "align label");
        panel.add(fieldLN, "wrap");
        //fieldLN.setVisible(admin);
        
        panel.add(new JLabel("Email"), "align label");
        panel.add(fieldEM, "wrap");
        //fieldEM.setVisible(admin);
        
        panel.add(new JLabel("Phone Number"), "align label");
        panel.add(fieldPN, "wrap");
        //fieldPN.setVisible(admin);

        return panel;
    }
    private UserFunctions.users getFieldData() {
        UserFunctions.users p = new UserFunctions.users();
        //p.setID(Integer.parseInt(fieldID.getText()));
        p.setUN(fieldUN.getText());
        p.setPW(fieldPW.getText());
        p.setFN(fieldFN.getText());
        p.setLN(fieldLN.getText());
        p.setEM(fieldEM.getText());
        p.setPN(fieldPN.getText());
        return p;
    }
    private void setFieldData(UserFunctions.users p) {
        //fieldID.setText(String.valueOf(p.getID()));
        fieldUN.setText(p.getUN());
        fieldPW.setText(p.getPW());
        fieldFN.setText(p.getFN());
        fieldLN.setText(p.getLN());
        fieldEM.setText(p.getEM());
        fieldPN.setText(p.getPN());
    }
    private boolean isEmptyFieldData() {
        return (fieldUN.getText().trim().isEmpty()
            && fieldPW.getText().trim().isEmpty()
            && fieldFN.getText().trim().isEmpty()
            && fieldLN.getText().trim().isEmpty()
            && fieldEM.getText().trim().isEmpty()
            && fieldPN.getText().trim().isEmpty());
    }
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserFunctions.users p = getFieldData();
            switch (e.getActionCommand()) {
                case "Phone Table":
                    JFrame f=new JFrame();
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
                    f.getContentPane().add(new phoneUI());
                    f.setSize(1200, 500);
                    f.setVisible(true);
                    break;
                case "Rating Table":
                    JFrame jf=new JFrame();
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                    if (bean.searchUser(p) != null){
                        setFieldData(bean.searchUser(p));
                        JOptionPane.showMessageDialog(null,"User with username: "
                        + String.valueOf(p.getUN() + " was located successfully"));
                    } else
                        JOptionPane.showMessageDialog(null,"User with username: "
                        + String.valueOf(p.getUN() + " was not located"));
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
                p.setUN("");
                p.setPW("");
                p.setFN("");
                p.setLN("");
                p.setEM("");
                p.setPN("");
                setFieldData(p);
                createButton.setText("Save");
                break;
            case "Update":
                if (isEmptyFieldData()) {
                    JOptionPane.showMessageDialog(null,"Cannot update an empty record");
                    return;
                }
                if (bean.update(p) != null)
                    JOptionPane.showMessageDialog(null,"User with username:"
                    + String.valueOf(p.getUN() + " is updated successfully"));
                break;
            case "Delete":
                if (isEmptyFieldData()) {
                   JOptionPane.showMessageDialog(null,"Cannot delete an empty record");
                   return;
                }
                p = bean.getCurrent();
                bean.delete();
                JOptionPane.showMessageDialog(null,"User with username:"
                + String.valueOf(p.getUN() + " is deleted successfully"));
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
