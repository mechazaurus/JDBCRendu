import Views.PanelDisplayRecords;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
    public static void main(String [] args) {
    	
        try {
            BDD bdd = new BDD();
            String query = "SELECT * FROM Flat";
            ResultSet rs = bdd.executeQuery(query);

            JPanel panel = new PanelDisplayRecords(rs);
            panel.setOpaque(true);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("Scrollable JTable");
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
