package AirlineManagement;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Flight_info extends JFrame {

    public Flight_info(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT * FROM FLIGHTS");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,0,800,450);
        add(jsp);


        setSize(800, 450);
        setLocation(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Flight_info();
    }
    
}
