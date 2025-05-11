package AirlineManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    
    JButton closeButton, loginButton, resetbtn;
    JLabel usernameLabel, passwordLabel, logoLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    public Login(){
     
        JPanel Pinkpanel = new JPanel();
        Pinkpanel.setBackground(Color.lightGray);
        Pinkpanel.setLayout(new BorderLayout());

        JPanel OtherPanel = new JPanel();
        OtherPanel.setBackground(Color.WHITE);
        OtherPanel.setLayout(null); 

        // Adding heading for the login form
        JLabel headingLabel = new JLabel("LOGIN");
        headingLabel.setBounds(130, 8, 100, 30); // Positioning the heading
        headingLabel.setFont(headingLabel.getFont().deriveFont(20.0f)); // Set font size
        headingLabel.setForeground(new Color(179,136,255));
        OtherPanel.add(headingLabel);

        // Adding components for the login form
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(25, 50, 100, 20);
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(12.0f));
        usernameLabel.setForeground(Color.BLACK);
        usernameField = new JTextField();
        usernameField.setBounds(25, 50 + 30, 250, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(25, 120, 100, 20);
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(12.0f));
        passwordLabel.setForeground(Color.BLACK);
        passwordField = new JPasswordField();
        passwordField.setBounds(25, 120 + 30, 250, 25);

        // login button 
        loginButton = new JButton("Submit");
        loginButton.addActionListener(this);
        loginButton.setBounds(30, 200,90,30);
        loginButton.setBackground(new Color(205, 171, 255));
        loginButton.setForeground(Color.WHITE);

        // close button
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        closeButton.setBounds(180, 200,90,30);
        closeButton.setBackground(new Color(205, 171, 255));
        closeButton.setForeground(Color.WHITE);

        // reset button
        resetbtn = new JButton("Reset");
        resetbtn.addActionListener(this);
        resetbtn.setBounds(100, 250,90,30);
        resetbtn.setBackground(new Color(205, 171, 255));
        resetbtn.setForeground(Color.WHITE);


        // Adding components to OtherPanel
        OtherPanel.add(usernameLabel);
        OtherPanel.add(usernameField);
        OtherPanel.add(passwordLabel);
        OtherPanel.add(passwordField);
        OtherPanel.add(new JLabel()); // Empty cell for spacing
        OtherPanel.add(loginButton);
        OtherPanel.add(closeButton);
        OtherPanel.add(resetbtn);


        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("AirlineManagement\\images\\login.png");
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Scale the image
        JLabel imagLabel = new JLabel(new ImageIcon(image)); // Create JLabel with the scaled image
        Pinkpanel.add(imagLabel, BorderLayout.CENTER);


        add(Pinkpanel, BorderLayout.WEST);
        add(OtherPanel, BorderLayout.CENTER);
        Pinkpanel.setPreferredSize(new Dimension(300,  300));
        OtherPanel.setPreferredSize(new Dimension(300,  300));


        setVisible(true);
        setSize(650, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
            
        }

   
    public void actionPerformed(ActionEvent ae){
     if (ae.getSource() == loginButton) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            conn c = new conn();

            String query = "SELECT * FROM LOGIN WHERE username ='" + username + "' AND password = '"+ password +"' ";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                //   Login successful 
               new Home();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "invalid username or password");
                setVisible(false); 
                // usernameField.setText(""); // Clear username field
                // passwordField.setText(""); // Clear password field
            }
            
         } catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            
    }else if (ae.getSource() == closeButton) {
            setVisible(false);

    } else if (ae.getSource() == resetbtn){
            usernameField.setText("");
            passwordField.setText("");
        }
    }


    public static void main(String[] args) {
        new Login();

    }
}
