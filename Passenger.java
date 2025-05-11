package AirlineManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Passenger {
    private String pnr;
    private String name;
    private String source;
    private String destination;
    private String date;
    private String flight;
    private String terminal;
    private String gate;
    private String seat;
    private String sourceCode;
    private String destinationCode;


    public Passenger(String pnr) {
        this.pnr = pnr;
    }

    private String getRandomSeatLetter() {
        char[] seatLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        Random rand = new Random();
        return String.valueOf(seatLetters[rand.nextInt(seatLetters.length)]);
    }

    public void fetchDetailsFromDatabase() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn con = new conn();
            conn = con.c; // Use the connection object from conn class
            String query =  "SELECT R.NAME, R.src, R.dest, R.Ddate, R.flightName, R.flightCode, " +
               "F.source_code, F.dest_code " +
               "FROM RESERVATION R JOIN FLIGHTS F ON R.flightCode = F.Flight_Code " +
               "WHERE R.PNR = ?";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, pnr);
            rs = stmt.executeQuery();

            if (rs.next()) {
                this.name = rs.getString("NAME");
                this.source = rs.getString("src");
                this.destination = rs.getString("dest");
                this.date = rs.getString("Ddate");
                this.flight = rs.getString("flightName");
                this.sourceCode = rs.getString("source_code");
                this.destinationCode = rs.getString("dest_code");


                // Randomly assign terminal, gate, seat
                Random rand = new Random();
                this.terminal = "T" + (rand.nextInt(3) + 1); // T1–T3
                this.gate = "G" + (rand.nextInt(20) + 1);     // G1–G20
                this.seat = (rand.nextInt(30) + 1) + getRandomSeatLetter(); // 1A–30F
            } else {
                throw new SQLException("No passenger found with PNR: " + pnr);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    } 
     // Getters
     public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getFlight() {
        return flight;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getGate() {
        return gate;
    }

    public String getSeat() {
        return seat;
    }

    public String getSourceCode() {
    return sourceCode;
   }

    public String getDestinationCode() {
    return destinationCode;
  }

    public String getPNR() {
        throw new UnsupportedOperationException("Unimplemented method 'getPNR'");
    }
}
