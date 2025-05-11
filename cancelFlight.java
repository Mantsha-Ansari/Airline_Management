package AirlineManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cancelFlight extends JFrame implements ActionListener {

    JTextField pnrField,nameField,cancelField,fcodeField,CdateField;
    JLabel pnr, name,cancel,fcode,Cdate;
    JButton fetchbtn,cancelbtn ;

    public cancelFlight() {

        Random random = new Random();

        JPanel Pinkpanel = new JPanel();
        Pinkpanel.setBackground(Color.lightGray);
        Pinkpanel.setLayout(new BorderLayout());

        JPanel OtherPanel = new JPanel();
        OtherPanel.setBackground(Color.WHITE);
        OtherPanel.setLayout(null); 

        // Adding heading for the login form
        JLabel headingLabel = new JLabel("CANCELLATION");
        headingLabel.setBounds(90, 8, 200, 30); // Positioning the heading
        headingLabel.setFont(headingLabel.getFont().deriveFont(22.0f)); // Set font size
        headingLabel.setForeground(new Color(179,136,255));
        OtherPanel.add(headingLabel);

        pnr = new JLabel("PNR Number: ");
        pnr.setBounds(20, 80, 100, 25);
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pnr.setForeground(Color.BLACK);
        OtherPanel.add(pnr);

        pnrField= new JTextField();
        pnrField.setBounds(100, 80, 140, 25);
        OtherPanel.add(pnrField);


        fetchbtn = new JButton("Show Details");
        fetchbtn.setBounds(247, 80, 110, 23);
        fetchbtn.setBackground(new Color(205, 171, 255));
        fetchbtn.setForeground(Color.WHITE);
        fetchbtn.addActionListener(this);
        OtherPanel.add(fetchbtn);

        name = new JLabel("Name: ");
        name.setBounds(20, 120, 100, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 12));
        name.setForeground(Color.BLACK);
        OtherPanel.add(name);

        nameField= new JTextField();
        nameField.setBounds(105, 120, 140, 25);
        OtherPanel.add(nameField);

        cancel = new JLabel("Cancellation No: ");
        cancel.setBounds(13, 160, 100, 25);
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cancel.setForeground(Color.BLACK);
        OtherPanel.add(cancel);

        cancelField= new JTextField("" + random.nextInt(1000000));
        cancelField.setBounds(105, 160, 140, 25);
        OtherPanel.add(cancelField);

        fcode= new JLabel("Flight Code: ");
        fcode.setBounds(13, 200, 100, 25);
        fcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
        fcode.setForeground(Color.BLACK);
        OtherPanel.add(fcode);

        fcodeField= new JTextField();
        fcodeField.setBounds(105, 200, 140, 25);
        OtherPanel.add(fcodeField);

        Cdate= new JLabel("Date: ");
        Cdate.setBounds(20, 240, 100, 25);
        Cdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Cdate.setForeground(Color.BLACK);
        OtherPanel.add(Cdate);

        CdateField= new JTextField();
        CdateField.setBounds(105, 240, 140, 25);
        OtherPanel.add(CdateField);

        cancelbtn= new JButton("Cancel");
        cancelbtn.setBounds(130, 300, 100, 30);
        cancelbtn.setBackground(new Color(205, 171, 255));
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.addActionListener(this);
        OtherPanel.add(cancelbtn);

        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("AirlineManagement\\images\\cancel.png");
        Image image = imageIcon.getImage().getScaledInstance(375, 422, Image.SCALE_SMOOTH); // Scale the image
        JLabel imagLabel = new JLabel(new ImageIcon(image)); // Create JLabel with the scaled image
        Pinkpanel.add(imagLabel, BorderLayout.CENTER);

        add(Pinkpanel, BorderLayout.EAST);
        add(OtherPanel, BorderLayout.CENTER);
        Pinkpanel.setPreferredSize(new Dimension(375,  230));
        OtherPanel.setPreferredSize(new Dimension(375,  230));

        setVisible(true);
        setSize(750, 400);
        setLocation(300, 200);       
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchbtn ) {
        String pnr = pnrField.getText();
       
            try {
                conn con = new conn();
                String query = "SELECT * FROM RESERVATION WHERE PNR = '"+pnr+"'";
                ResultSet rs = con.s.executeQuery(query);

                if (rs.next()) {
                    nameField.setText(rs.getString("NAME"));
                    fcodeField.setText(rs.getString("flightCode"));
                    CdateField.setText(rs.getString("Ddate"));
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter correct PNR");
                }
                 
            } catch (Exception e) {
               e.printStackTrace();
            }
        }else if (ae.getSource() == cancelbtn ) {
            String name = nameField.getText();
            String pnr = pnrField.getText();
            String cancelno = cancelField.getText();
            String fcode = fcodeField.getText();
            String cdate = CdateField.getText();

            try {
                conn con = new conn();
                String query = "INSERT INTO CANCEL VALUES('"+pnr+"' , '"+name+"' , '"+cancelno+"', '"+fcode+"', '"+cdate+"')";
                con.s.executeUpdate(query);
                con.s.executeUpdate("DELETE FROM RESERVATION WHERE PNR = '"+pnr+"'");
                JOptionPane.showMessageDialog(null,"Ticket Deleted Successfully");
                setVisible(false);
                 
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new cancelFlight();
    }
    
}
