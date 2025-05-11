package AirlineManagement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
// import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class BoardingPassUI extends JFrame {
    public BoardingPassUI(String pnr) {
        setTitle("Boarding Pass");
        setSize(950, 360);
        setLocationRelativeTo(null);
        setLayout(null);

        // Fetch passenger data using PNR
        Passenger p = new Passenger(pnr);
        try {
            p.fetchDetailsFromDatabase(); // This fetches and fills all passenger details
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching passenger data: " + e.getMessage());
            return;
        }

        // Get data from passenger object
        String passengerNameStr = p.getName();
        String source = p.getSource();
        String destination = p.getDestination();
        String date = p.getDate();
        String terminal = p.getTerminal();
        String gate = p.getGate();
        String seat = p.getSeat();
        String flightNumber = p.getFlight(); 
        String sourceCode = p.getSourceCode();
        String destinationCode = p.getDestinationCode();

        JPanel passPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        passPanel.setLayout(null);
        passPanel.setBounds(10, 10, 910, 260);
        passPanel.setBackground(Color.WHITE);
        add(passPanel);

        // Top blue header
        JPanel header = new JPanel();
        header.setBackground(new Color(88, 120, 255));
        header.setBounds(0, 0, 910, 40);
        header.setLayout(null);
        JLabel title = new JLabel("BOARDING PASS");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setBounds(20, 10, 200, 20);
        header.add(title);
        passPanel.add(header);

        // Airline Name on Right
        JLabel airline = new JLabel("Lorem Airlines");
        airline.setFont(new Font("SansSerif", Font.PLAIN, 14));
        airline.setBounds(750, 10, 150, 20);
        airline.setForeground(Color.WHITE);
        header.add(airline);

        // FROM
        JLabel from = new JLabel("FROM:");
        from.setFont(new Font("SansSerif", Font.PLAIN, 12));
        from.setBounds(30, 50, 100, 20);
        passPanel.add(from);

        JLabel fromCode = new JLabel(sourceCode);
        fromCode.setForeground(new Color(88, 120, 255));
        fromCode.setFont(new Font("SansSerif", Font.BOLD, 36));
        fromCode.setBounds(30, 65, 100, 40);
        passPanel.add(fromCode);

        JLabel fromCity = new JLabel(source.toUpperCase());
        fromCity.setForeground(new Color(88, 120, 255));
        fromCity.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fromCity.setBounds(30, 105, 100, 20);
        passPanel.add(fromCity);

        JLabel fromDate = new JLabel(date + " 05:50 PM");
        fromDate.setFont(new Font("SansSerif", Font.PLAIN, 12));
        fromDate.setBounds(30, 125, 200, 20);
        passPanel.add(fromDate);

        // Arrow
        JLabel arrow = new JLabel("➝");
        arrow.setFont(new Font("SansSerif", Font.BOLD, 37));
        arrow.setBounds(160, 75, 50, 30);
        passPanel.add(arrow);

        // TO
        JLabel to = new JLabel("TO:");
        to.setFont(new Font("SansSerif", Font.PLAIN, 12));
        to.setBounds(250, 50, 100, 20);
        passPanel.add(to);

        JLabel toCode = new JLabel(destinationCode);
        toCode.setForeground(new Color(88, 120, 255));
        toCode.setFont(new Font("SansSerif", Font.BOLD, 36));
        toCode.setBounds(250, 65, 100, 40);
        passPanel.add(toCode);

        JLabel toCity = new JLabel(destination.toUpperCase());
        toCity.setForeground(new Color(88, 120, 255));
        toCity.setFont(new Font("SansSerif", Font.PLAIN, 14));
        toCity.setBounds(250, 105, 100, 20);
        passPanel.add(toCity);

        JLabel toDate = new JLabel(date + " 07:20 AM");
        toDate.setFont(new Font("SansSerif", Font.PLAIN, 12));
        toDate.setBounds(250, 125, 200, 20);
        passPanel.add(toDate);

        // Left bottom info – styled to match exact design
        JLabel passenger = new JLabel("Passenger");
        passenger.setFont(new Font("SansSerif", Font.PLAIN, 12));
        passenger.setBounds(30, 160, 100, 15);
        passPanel.add(passenger);

        JLabel passengerName = new JLabel(passengerNameStr.toUpperCase());
        passengerName.setForeground(new Color(88, 120, 255));
        passengerName.setFont(new Font("SansSerif", Font.BOLD, 14));
        passengerName.setBounds(30, 175, 150, 20);
        passPanel.add(passengerName);

        JLabel flight = new JLabel("Flight");
        flight.setFont(new Font("SansSerif", Font.PLAIN, 12));
        flight.setBounds(37, 210, 100, 15);
        passPanel.add(flight);

        JLabel flightVal = new JLabel(flightNumber);
        flightVal.setForeground(new Color(88, 120, 255));
        flightVal.setFont(new Font("SansSerif", Font.BOLD, 13));
        flightVal.setBounds(30, 225, 150, 18);
        passPanel.add(flightVal);

        JLabel terminalLabel = new JLabel("Terminal");
        terminalLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        terminalLabel.setBounds(180, 210, 100, 15);
        passPanel.add(terminalLabel);

        JLabel terminalVal = new JLabel(terminal);
        terminalVal.setForeground(new Color(88, 120, 255));
        terminalVal.setFont(new Font("SansSerif", Font.BOLD, 14));
        terminalVal.setBounds(180, 225, 100, 20);
        passPanel.add(terminalVal);

        JLabel gateLabel = new JLabel("Gate");
        gateLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        gateLabel.setBounds(320, 210, 100, 15);
        passPanel.add(gateLabel);

        JLabel gateVal = new JLabel(gate);
        gateVal.setForeground(new Color(88, 120, 255));
        gateVal.setFont(new Font("SansSerif", Font.BOLD, 14));
        gateVal.setBounds(320, 225, 100, 20);
        passPanel.add(gateVal);

        JLabel seatLabel = new JLabel("Seat");
        seatLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        seatLabel.setBounds(440, 210, 100, 15);
        passPanel.add(seatLabel);

        JLabel seatVal = new JLabel(seat);
        seatVal.setForeground(new Color(88, 120, 255));
        seatVal.setFont(new Font("SansSerif", Font.BOLD, 14));
        seatVal.setBounds(440, 225, 100, 20);
        passPanel.add(seatVal);

        // Right side section (unchanged for now)
        JPanel rightCard = new JPanel();
        rightCard.setLayout(null);
        rightCard.setBounds(640, 50, 240, 200);
        rightCard.setBackground(new Color(245, 245, 245));
        rightCard.setBorder(BorderFactory.createLineBorder(Color.blue));
        passPanel.add(rightCard);

        JLabel pLabel = new JLabel("PASSENGER");
        pLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        pLabel.setBounds(10, 10, 100, 15);
        rightCard.add(pLabel);

        JLabel pName = new JLabel(passengerNameStr.toUpperCase());
        pName.setForeground(new Color(88, 120, 255));
        pName.setFont(new Font("SansSerif", Font.BOLD, 14));
        pName.setBounds(10, 25, 200, 20);
        rightCard.add(pName);

        JLabel classLabel = new JLabel("CLASS");
        classLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        classLabel.setBounds(120, 10, 100, 15);
        rightCard.add(classLabel);

        JLabel classVal = new JLabel("ECONOMY");
        classVal.setForeground(new Color(88, 120, 255));
        classVal.setFont(new Font("SansSerif", Font.BOLD, 13));
        classVal.setBounds(120, 25, 100, 20);
        rightCard.add(classVal);

        JLabel dateLabel = new JLabel("DATE");
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        dateLabel.setBounds(10, 60, 100, 15);
        rightCard.add(dateLabel);

        JLabel dateVal = new JLabel(date.toUpperCase());
        dateVal.setForeground(new Color(88, 120, 255));
        dateVal.setFont(new Font("SansSerif", Font.BOLD, 11));
        dateVal.setBounds(10, 75, 100, 20);
        rightCard.add(dateVal);

        JLabel boardLabel = new JLabel("BOARDING");
        boardLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        boardLabel.setBounds(90, 60, 100, 15);
        rightCard.add(boardLabel);

        JLabel boardVal = new JLabel("05:20 PM");
        boardVal.setForeground(new Color(88, 120, 255));
        boardVal.setFont(new Font("SansSerif", Font.BOLD, 12));
        boardVal.setBounds(90, 75, 100, 20);
        rightCard.add(boardVal);

        JLabel departLabel = new JLabel("DEPART");
        departLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        departLabel.setBounds(170, 60, 100, 15);
        rightCard.add(departLabel);

        JLabel departVal = new JLabel("05:50 PM");
        departVal.setForeground(new Color(88, 120, 255));
        departVal.setFont(new Font("SansSerif", Font.BOLD, 12));
        departVal.setBounds(170, 75, 100, 20);
        rightCard.add(departVal);

        JLabel barcode = new JLabel("▌▌ ▌ ▌▌ ▌▌ ▌▌▌ ▌▌ ▌▌");
        barcode.setFont(new Font("Monospaced", Font.PLAIN, 22));
        barcode.setHorizontalAlignment(SwingConstants.CENTER);
        barcode.setBounds(10, 110, 210, 40);
        rightCard.add(barcode);

        JButton printButton = new JButton("PRINT BOARDING PASS");
        printButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        printButton.setBounds(380, 280, 200, 30);
        printButton.setBackground(new Color(88, 120, 255));
        printButton.setForeground(Color.WHITE);
        printButton.setBorder(null);
        
        printButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Capture the boarding pass panel as an image
        BufferedImage printImage = new BufferedImage(passPanel.getWidth(), passPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = printImage.createGraphics();
        passPanel.paint(g2);
        g2.dispose();

        // Optional: Save the image to a file
        try {
            File outputfile = new File("boarding_pass.png");
            ImageIO.write(printImage, "png", outputfile);
            System.out.println("Image saved as boarding_pass.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Now setup printing
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Boarding Pass Print");

        job.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
                if (pageIndex > 0) return NO_SUCH_PAGE;

                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());

                double pageWidth = pf.getImageableWidth();
                double pageHeight = pf.getImageableHeight();
                int imgWidth = printImage.getWidth();
                int imgHeight = printImage.getHeight();

                double scaleX = pageWidth / imgWidth;
                double scaleY = pageHeight / imgHeight;
                double scale = Math.min(scaleX, scaleY);

                double x = (pageWidth - (imgWidth * scale)) / 2;
                double y = (pageHeight - (imgHeight * scale)) / 2;

                g2d.translate(x, y);
                g2d.scale(scale, scale);
                g2d.drawImage(printImage, 0, 0, null);

                return PAGE_EXISTS;
            }
        });

        // Show print dialog
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
});


        add(printButton);
        
      setVisible(true);
    }
}




