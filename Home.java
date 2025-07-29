package AirlineManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Home extends JFrame implements ActionListener{

    public  Home() {
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // load the image 
        ImageIcon img = new ImageIcon("AirlineManagement\\images\\home.png");
        JLabel imageLabel = new JLabel(img) {
            @Override
            protected void paintComponent(Graphics g) { 
                super.paintComponent(g);
                Image image = img.getImage();
                Dimension size = getSize();
                g.drawImage(image,0,0, size.width, size.height, this );

            }
        };
        // Add a listener to resize the image when the window is resized 
        addComponentListener(new ComponentAdapter() { 
            @Override
             public void componentResized(ComponentEvent e) { 
                imageLabel.repaint(); 
            }
            });

        //add image in the frame
       setLayout(new BorderLayout());
       add(imageLabel, BorderLayout.EAST);
       setContentPane(imageLabel);
       imageLabel.setLayout(null);

          JLabel heading = new JLabel("Air India");
          JLabel heading1 = new JLabel("WELCOMES YOU..");
          heading.setFont(new java.awt.Font("Arial", 1, 28));
          heading.setForeground(new Color(144,144,144));
          heading.setBounds(30, 90, 500, 40);
          heading1.setFont(new Font(null, Font.BOLD, 31));
          heading1.setBounds(50, 118, 350,55);
          heading1.setForeground(new Color(123,104,238));
          imageLabel.add(heading);
          imageLabel.add(heading1);
          
          // Create a menu bar
          JMenuBar menuBar = new JMenuBar();
            menuBar.setBackground(new Color(123,104,238));
            // menuBar.setForeground(Color.WHITE);
          setJMenuBar(menuBar);

         JMenu homeMenu = new JMenu("Home");
            homeMenu.setForeground(Color.WHITE);
         JMenu flightsMenu = new JMenu("flights");
            flightsMenu.setForeground(Color.WHITE);
         JMenu checkInMenu = new JMenu("Check-In");
            checkInMenu.setForeground(Color.WHITE);
         JMenu supportMenu = new JMenu("Customer Support");
            supportMenu.setForeground(Color.WHITE);
         JMenu profileMenu = new JMenu("Profile");
            profileMenu.setForeground(Color.WHITE);
         JMenu aboutMenu = new JMenu("About Us");
         aboutMenu.setForeground(Color.WHITE);
         JMenu feedbackMenu = new JMenu("Feedback/Reviews");
            feedbackMenu.setForeground(Color.WHITE);

         // Add menu items to Flights menu
       JMenuItem flightsDetails = new JMenuItem("Flight Details");
       flightsDetails.addActionListener(this);
       JMenuItem bookFlight = new JMenuItem("Book Flight");
       bookFlight.addActionListener(this);
       JMenuItem flightsCancel= new JMenuItem("Cancel Flight");
       flightsCancel.addActionListener(this);
       
       flightsMenu.add(flightsDetails);
       flightsMenu.add(bookFlight);
       flightsMenu.add(flightsCancel);

         // Add menu items to Check-In menu
         JMenuItem journey = new JMenuItem("Journey Details");
            journey.addActionListener(this);
         JMenuItem boardingPass = new JMenuItem("Boarding Pass");

            boardingPass.addActionListener(e -> {
            String pnr = JOptionPane.showInputDialog(null, "Enter PNR:");
            if (pnr != null && !pnr.trim().isEmpty()) {
                try {
                    //Passenger p = new Passenger(pnr.trim().toUpperCase());
                    new BoardingPassUI(pnr.trim().toUpperCase());  // Pass PNR string directly
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No reservation found for PNR: " + pnr);
                }
            }
        });
        
       
         checkInMenu.add(journey);
         checkInMenu.add(boardingPass);

      // About Us Menu
     JMenuItem companyInfo = new JMenuItem("Company Information");
     JMenuItem team = new JMenuItem("Team");
     JMenuItem careers = new JMenuItem("Careers");
     JMenuItem pressReleases = new JMenuItem("Press Releases");
     aboutMenu.add(companyInfo);
     aboutMenu.add(team);
     aboutMenu.add(careers);
     aboutMenu.add(pressReleases);


      // Add menu items to Profile menu
      JMenuItem login = new JMenuItem("Login");
      login.addActionListener(this);
      JMenuItem profileSettings = new JMenuItem("Profile Settings");
      JMenuItem logout = new JMenuItem("Logout");
      profileMenu.add(login);
      profileMenu.add(profileSettings);
      profileMenu.add(logout);

      // Feedback/Reviews Menu
    JMenuItem submitFeedback = new JMenuItem("Submit Feedback");
    JMenuItem customerReviews = new JMenuItem("Customer Reviews");
    JMenuItem complaints = new JMenuItem("Complaints");
    JMenuItem suggestions = new JMenuItem("Suggestions");
    feedbackMenu.add(submitFeedback);
    feedbackMenu.add(customerReviews);
    feedbackMenu.add(complaints);
    feedbackMenu.add(suggestions);

// Customer Support Menu
JMenuItem addCustomerItem = new JMenuItem("Add Customer");
addCustomerItem.addActionListener(this);
JMenuItem contactUs = new JMenuItem("Contact Us");
JMenuItem faqs = new JMenuItem("FAQs");
JMenuItem liveChat = new JMenuItem("Live Chat");
JMenuItem helpCenter = new JMenuItem("Help Center");
supportMenu.add(addCustomerItem);
supportMenu.add(contactUs);
supportMenu.add(faqs);
supportMenu.add(liveChat);
supportMenu.add(helpCenter);


    menuBar.add(homeMenu);
    menuBar.add(flightsMenu);
    menuBar.add(checkInMenu);
    menuBar.add(supportMenu);
    menuBar.add(profileMenu);
    menuBar.add(aboutMenu);
    menuBar.add(feedbackMenu);

    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();

        if(text.equals("Add Customer")) {
            new AddCustomer();
        }else if(text.equals("Login")){
            new Login();
        }else if(text.equals("Flight Details")){
            new Flight_info();
        }else if(text.equals("Book Flight")){
            new Book_flight();
        }else if(text.equals("Cancel Flight")){
            new cancelFlight();
        }else if(text.equals("Journey Details")){
            new journeyDetails();
        }else if(text.equals("Boarding Pass")){
            new BoardingPassUI(null);
        }

    }
    
    public static void main(String[] args) {
        new Home();

    }
}
