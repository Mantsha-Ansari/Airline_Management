package AirlineManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddCustomer extends JFrame implements ActionListener{

    JTextField nameField,nationField,adharField,addressField,phoneField ;
    JLabel name,nationality,adhar,address,phone,gender;
    JRadioButton malebtn, femalebtn;
    JButton save;

    public AddCustomer() {

        JPanel imgpanel = new JPanel();
        imgpanel.setBackground(Color.lightGray);
        imgpanel.setLayout(new BorderLayout());

        JPanel OtherPanel = new JPanel();
        OtherPanel.setBackground(Color.WHITE);
        OtherPanel.setLayout(null); 


        setLayout(null);
        setSize(700, 460); 
        setLocation(300,140);
        

        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(60, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(new Color(179, 136, 255));
        OtherPanel.add(heading);

        name = new JLabel("Name : ");
        name.setBounds(60, 80, 100, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 12));
        name.setForeground(Color.BLACK);
        OtherPanel.add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 80, 200, 25);
        OtherPanel.add(nameField);

        nationality = new JLabel("Nationality : ");
        nationality.setBounds(60, 120, 100, 25);
        nationality.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nationality.setForeground(Color.BLACK);
        OtherPanel.add(nationality);

        nationField = new JTextField();
        nationField.setBounds(150, 120, 200, 25);
        OtherPanel.add(nationField);

        adhar = new JLabel("Adhar Number : ");
        adhar.setBounds(60, 160, 100, 25);
        adhar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        adhar.setForeground(Color.BLACK);
        OtherPanel.add(adhar);

         adharField = new JTextField();
        adharField.setBounds(150, 160, 200, 25);
        OtherPanel.add(adharField);

        address = new JLabel("Address : ");
        address.setBounds(60, 200, 100, 25);
        address.setFont(new Font("Tahoma", Font.PLAIN, 12));
        address.setForeground(Color.BLACK);
        OtherPanel.add(address);

        addressField  = new JTextField();
        addressField.setBounds(150, 200, 200, 25);
        OtherPanel.add(addressField);

        gender = new JLabel("Gender : ");
        gender.setBounds(60, 240, 100, 25);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gender.setForeground(Color.BLACK);
        OtherPanel.add(gender);

        ButtonGroup genderGroup = new ButtonGroup();
    
        malebtn = new JRadioButton("Male");
        malebtn.setBounds(150, 240, 80, 25);
        OtherPanel.add(malebtn);
        
        femalebtn = new JRadioButton("Female");
        femalebtn.setBounds(230, 240, 80, 25);
        OtherPanel.add(femalebtn);

        genderGroup.add(malebtn);
        genderGroup.add(femalebtn);

        phone = new JLabel("Phone Number : ");
        phone.setBounds(60, 280, 100, 25);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phone.setForeground(Color.BLACK);
        OtherPanel.add(phone);

         phoneField = new JTextField();
        phoneField.setBounds(150, 280, 200, 25);
        OtherPanel.add(phoneField);

        save = new JButton("Save");
        save.setBounds(150, 350, 100, 30);
        save.setBackground(new Color(205, 171, 255));
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        OtherPanel.add(save);

        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("AirlineManagement\\images\\customer.png");
        Image image = imageIcon.getImage().getScaledInstance(450, 462, Image.SCALE_SMOOTH); // Scale the image
        JLabel imagLabel = new JLabel(new ImageIcon(image)); // Create JLabel with the scaled image
        imgpanel.add(imagLabel, BorderLayout.CENTER);


        add(imgpanel, BorderLayout.EAST);
        add(OtherPanel, BorderLayout.CENTER);
        imgpanel.setPreferredSize(new Dimension(320,  320));
        OtherPanel.setPreferredSize(new Dimension(300,  300));

        setVisible(true);

    }
     
    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String nationality = nationField.getText();
        String adhar = adharField.getText();
        String address = addressField.getText();
        String gender = null;
        if (malebtn.isSelected()) {
               gender = "Male";
            }else{
                gender = "Female";
            }
         String phone = phoneField.getText();
        
            try {
                conn con = new conn();
                String query = "INSERT INTO PASSENGER VALUES ('"+name+"', '"+nationality+"', '"+adhar+"', '"+address+"','"+gender+"','"+phone+"')";
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer details Successfully Added");
                
            } catch (Exception e) {
               e.printStackTrace();
               JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

    
}
