package AirlineManagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class journeyDetails extends JFrame implements ActionListener {

    JTextField pnrField;
    JLabel detailsLabel;
    JTable table;

    public journeyDetails() {
        getContentPane().setBackground(Color.WHITE);

        setTitle("Journey Details");
        setSize(700, 400);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Add components for journey details here
        JLabel pnrLabel = new JLabel("Enter PNR:");
        pnrLabel.setBounds(20, 50, 100, 25);
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(100, 50, 180, 25);
        add(pnrField);

        JButton fetchButton = new JButton("Show Details");
        fetchButton.setBounds(330, 50, 150, 28);
        fetchButton.setBackground(new Color(205, 171, 255));
        fetchButton.setForeground(Color.WHITE);
        fetchButton.addActionListener(this);
        add(fetchButton);

        // Customize the table
        table = new JTable();
        table.setBackground(Color.WHITE); // Set table background to white
        table.setForeground(Color.BLACK); // Set table text color to black
        table.setGridColor(Color.LIGHT_GRAY); // Set grid color
        table.setSelectionBackground(new Color(205, 171, 255)); // Set selection background color
        table.setSelectionForeground(Color.WHITE); // Set selection text color

        // Customize the table header
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(88, 120, 255)); // Set header background color
        header.setForeground(Color.WHITE); // Set header text color
        header.setFont(header.getFont().deriveFont(14f)); // Set header font size

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(6, 100, 673, 255);
        jsp.setBackground(Color.WHITE);
        jsp.setBorder(null);
        add(jsp);

        setVisible(true);
    }

    // Implement the actionPerformed method to handle button clicks and fetch data from the database
    public void actionPerformed(ActionEvent e) {
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT * FROM RESERVATION WHERE PNR = '" + pnrField.getText() + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid PNR!");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new journeyDetails();
    }
}

