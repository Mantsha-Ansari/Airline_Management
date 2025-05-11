package AirlineManagement;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Book_flight extends JFrame implements ActionListener {

    JTextField nameField,nationField,adharField,addressField,genderlabel,sourceField,destiField,fNameField,fCodeField,DtravelField;
    JLabel name,nationality,adhar,address,source,gender, destination,fName,fCode,Dtravel;
    JButton Bflight,fetchflight,fetchbtn;
    JDateChooser date;
    Choice sourceChoice,desChoice ;

    public Book_flight() {

        JPanel imgpanel = new JPanel();
        imgpanel.setBackground(Color.white);
        imgpanel.setLayout(new BorderLayout());

        JPanel OtherPanel = new JPanel();
        OtherPanel.setBackground(Color.WHITE);
        OtherPanel.setLayout(null); 


        setLayout(null);
        setSize(800, 600); 
        setLocation(300,100);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(140, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(new Color(179, 136, 255));
        OtherPanel.add(heading);

        adhar = new JLabel("Adhar: ");
        adhar.setBounds(40, 80, 100, 25);
        adhar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        adhar.setForeground(Color.BLACK);
        OtherPanel.add(adhar);

        adharField = new JTextField();
        adharField.setBounds(100, 80, 180, 25);
        OtherPanel.add(adharField);

        fetchbtn = new JButton("Fetch User");
        fetchbtn.setBounds(300, 80, 100, 25);
        fetchbtn.setBackground(new Color(205, 171, 255));
        fetchbtn.setForeground(Color.WHITE);
        fetchbtn.addActionListener(this);
        OtherPanel.add(fetchbtn);

        name = new JLabel("Name: ");
        name.setBounds(40, 120, 100, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 12));
        name.setForeground(Color.BLACK);
        OtherPanel.add(name);

        nameField= new JTextField();
        nameField.setBounds(100, 120, 180, 25);
        OtherPanel.add(nameField);

        nationality = new JLabel("Nationality: ");
        nationality.setBounds(40, 160, 100, 25);
        nationality.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nationality.setForeground(Color.BLACK);
        OtherPanel.add(nationality);

        nationField = new JTextField();
        nationField.setBounds(100, 160, 180, 25);
        OtherPanel.add(nationField);

        address = new JLabel("Address : ");
        address.setBounds(40, 200, 100, 25);
        address.setFont(new Font("Tahoma", Font.PLAIN, 12));
        address.setForeground(Color.BLACK);
        OtherPanel.add(address);

        addressField  = new JTextField();
        addressField.setBounds(100, 200, 180, 25);
        OtherPanel.add(addressField);

        gender = new JLabel("Gender : ");
        gender.setBounds(40, 240, 100, 25);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gender.setForeground(Color.BLACK);
        OtherPanel.add(gender);

        genderlabel = new JTextField();
        genderlabel.setBounds(100, 240, 180, 25);
        OtherPanel.add(genderlabel);

        source= new JLabel("Source: ");
        source.setBounds(40, 280, 90, 25);
        source.setFont(new Font("Tahoma", Font.PLAIN, 12));
        source.setForeground(Color.BLACK);
        OtherPanel.add(source);

        sourceChoice = new Choice();
        sourceChoice.setBounds(135, 280, 130, 25);
        OtherPanel.add(sourceChoice);

        destination= new JLabel("Destination: ");
        destination.setBounds(35, 320, 100, 25);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 12));
        destination.setForeground(Color.BLACK);
        OtherPanel.add(destination);

        desChoice = new Choice();
        desChoice.setBounds(135, 320, 130, 25);
        OtherPanel.add(desChoice);

        fetchflight = new JButton("Fetch Flight");
        fetchflight.setBounds(280, 320, 104, 22);
        fetchflight.setBackground(new Color(205, 171, 255));
        fetchflight.setForeground(Color.WHITE);
        fetchflight.addActionListener(this);
        OtherPanel.add(fetchflight);

        // source destination database work
        try {
            conn c = new conn();
            String query = "SELECT * FROM FLIGHTS";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                sourceChoice.add(rs.getString("SOURCE"));
                desChoice.add(rs.getString("DESTINATION"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        fName = new JLabel("Flight Name: ");
        fName.setBounds(32, 360, 100, 25);
        fName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        fName.setForeground(Color.BLACK);
        OtherPanel.add(fName);

        fNameField  = new JTextField();
        fNameField.setBounds(105, 360, 180, 25);
        OtherPanel.add(fNameField);

        fCode = new JLabel("Flight Code: ");
        fCode.setBounds(32, 400, 100, 25);
        fCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
        fCode.setForeground(Color.BLACK);
        OtherPanel.add(fCode);

        fCodeField  = new JTextField();
        fCodeField .setBounds(105, 400, 180, 25);
        OtherPanel.add(fCodeField );

        Dtravel = new JLabel("Date of Travel: ");
        Dtravel.setBounds(25, 440, 100, 25);
        Dtravel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Dtravel.setForeground(Color.BLACK);
        OtherPanel.add(Dtravel);

        date = new JDateChooser();
        date.setBounds(106, 440, 180, 25);
        OtherPanel.add(date);


        Bflight = new JButton("Book Flight");
        Bflight.setBounds(140, 495, 100, 30);
        Bflight.setBackground(new Color(205, 171, 255));
        Bflight.setForeground(Color.WHITE);
        Bflight.addActionListener(this);
        OtherPanel.add(Bflight);

        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("AirlineManagement\\images\\ticket.png");
        Image image = imageIcon.getImage().getScaledInstance(500, 462, Image.SCALE_SMOOTH); // Scale the image
        JLabel imagLabel = new JLabel(new ImageIcon(image)); // Create JLabel with the scaled image
        imgpanel.add(imagLabel, BorderLayout.CENTER);


        add(imgpanel, BorderLayout.EAST);
        add(OtherPanel, BorderLayout.CENTER);
        imgpanel.setPreferredSize(new Dimension(360,  360));
        OtherPanel.setPreferredSize(new Dimension(400,  400));

        setVisible(true);

    }
     
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==  fetchbtn) {
        String adhar = adharField.getText();
       
            try {
                conn con = new conn();
                String query = "SELECT * FROM PASSENGER WHERE ADHAR = '"+adhar+"'";
                ResultSet rs = con.s.executeQuery(query);

                if (rs.next()) {
                    nameField.setText(rs.getString("NAME"));
                    nationField.setText(rs.getString("NATIONALITY"));
                    addressField.setText(rs.getString("ADDRESS"));
                    genderlabel.setText(rs.getString("GENDER"));
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter correct Adhar Number");
                }
                 
            } catch (Exception e) {
               e.printStackTrace();
            }
        }else if (ae.getSource() == fetchflight) {
            String src = sourceChoice.getSelectedItem();
            String dest = desChoice.getSelectedItem();
           
                try {
                    conn con = new conn();
                    String query = "SELECT * FROM FLIGHTS WHERE SOURCE = '"+src+"' and DESTINATION= '"+dest+"'";
                    ResultSet rs = con.s.executeQuery(query);
    
                    if (rs.next()) {
                        fNameField.setText(rs.getString("Flight_name"));
                        fCodeField.setText(rs.getString("Flight_Code"));
                    } else {
                        JOptionPane.showMessageDialog(null,"No Flight Found");
                    }  
                } catch (Exception e) {
                    e.printStackTrace();
                 }
        }else {
            Random random = new Random();
            String adhar = adharField.getText();
            String name =  nameField.getText();
            String nationality = nationField.getText();
            String flightName = fNameField.getText();
            String flightCode = fCodeField.getText();
            String src = sourceChoice.getSelectedItem();
            String dest = desChoice.getSelectedItem();
            String Ddate = (( JTextField) date.getDateEditor().getUiComponent()).getText();

            try {
                conn con = new conn();
                String pnr = "PNR-" + random.nextInt(1000000);
                String ticket = "TIC-" + random.nextInt(10000);
                String query = "INSERT INTO RESERVATION VALUES ( '" + pnr + "' ,'" + ticket + "', '" + adhar + "' , '" + name + "', '" + nationality + "', '" + flightName + "' , '" + flightCode + "' , '" + src + "' , '" + dest + "' , '" + Ddate + "')";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully. Your PNR is: " + pnr);
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
             }

        }   
              
    }

    public static void main(String[] args) {
        new Book_flight();
    }

    
}

    

