package com.polytech.bsm.view;
import com.polytech.bsm.controler.FlatDAO;
import com.polytech.bsm.model.Flat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class PanelDisplayRecords extends JFrame {

	private static final long serialVersionUID = 1L;
	private Vector<String> columnNames;
    private Vector<Vector<Object>> data;
    private JTable table;
    private DefaultTableModel model;

    public PanelDisplayRecords(ArrayList<Flat> flats)
    {
        columnNames = new Vector<String>();
        String [] col = new String[]{"IdFlat", "Address", "Description", "State"};

        //Set columns name
        for (int i = 0; i<col.length; i++)
        {
            columnNames.add(col[i]);
        }

        data = new Vector<Vector<Object>>();
        try
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();


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

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("Appartments List");
            setLocationRelativeTo(null);
            setVisible(false);
            setSize(600, 500);
        }
        catch (SQLException sql)
        {
            System.out.println("error construtor PanelDisplayRecords "+sql);
        }

    }


}