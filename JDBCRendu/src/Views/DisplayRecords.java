package Views;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DisplayRecords extends JPanel {

    ArrayList columnNames = new ArrayList();
    ArrayList data = new ArrayList();
    ResultSet resultSet;

    public DisplayRecords(ResultSet rs)
    {
        initializeUI();
        columnNames = new ArrayList();
        data = new ArrayList();
        resultSet = new ResultSet();

    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 200));


        add(pane, BorderLayout.CENTER);
    }

    private static void showFrame() {
        JPanel panel = new DisplayRecords();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DisplayRecords.showFrame();
            }
        });
    }
}