package com.polytech.bsm.launcher;

import java.sql.SQLException;
import com.polytech.bsm.model.BDD;
import com.polytech.bsm.view.MainApp;

public class Main {
	
    public static void main(String [] args) {
    	
        try {
            @SuppressWarnings("unused")
			BDD bdd = new BDD();
            /*
            String query = "SELECT * FROM Flat";
            ResultSet rs = bdd.executeQuery(query);

            JPanel panel = new PanelSpecifiedSearch();
            panel.setOpaque(true);
            
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("Scrollable JTable");
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);*/
            
            @SuppressWarnings("unused")
			MainApp main = new MainApp();
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
