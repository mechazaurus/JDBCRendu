package com.polytech.bsm.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class PanelDisplayRecords extends JPanel {

	private static final long serialVersionUID = 1L;
	private Vector<String> columnNames;
    private Vector<Vector<Object>> data;
    private JTable table;
    private DefaultTableModel model;

    public PanelDisplayRecords(ResultSet rs)
    {
        initializeUI();
        columnNames = new Vector<String>();
        data = new Vector<Vector<Object>>();
        try
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            int columnCount = rs.getMetaData().getColumnCount();
            for (int column = 1; column <= columnCount; column++)
            {
                columnNames.add(rs.getMetaData().getColumnName(column));
            }

            //  Get rows data
            while (rs.next())
            {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columns; columnIndex++)
                    {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);

            }

            //System.out.println(columnNames);
            //System.out.println(data);

            //Setting up the model for the JTable
            model = new DefaultTableModel(data, columnNames);

            //Adding columns names
            table = new JTable();
            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);

            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            table.setEnabled(false);

            this.add(scroll);
        }
        catch (SQLException sql)
        {
            System.out.println("error construtor PanelDisplayRecords "+sql);
        }

    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 400));
    }

    private static void showFrame() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PanelDisplayRecords.showFrame();
            }
        });
    }
}