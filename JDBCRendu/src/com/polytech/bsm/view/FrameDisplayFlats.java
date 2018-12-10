package com.polytech.bsm.view;
import com.polytech.bsm.model.Flat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class FrameDisplayFlats extends JFrame {

	private static final long serialVersionUID = 1L;
	private Vector<String> columnNames;
    private Vector<Vector<Object>> data;
    private JTable table;
    private DefaultTableModel model;

    public FrameDisplayFlats(ArrayList<Flat> flats)
    {
        columnNames = new Vector<String>();
        String [] col = new String[]{"IdFlat", "Address", "Description", "State"};

        //Set columns name
        for (int i = 0; i<col.length; i++)
        {
            columnNames.add(col[i]);
        }

        data = new Vector<Vector<Object>>();

        for(int i =0; i<flats.size(); i++)
        {
            Vector<Object> vector = new Vector<Object>();
            vector.add(flats.get(i).getFlatID());
            vector.add(flats.get(i).getFlatDescription());
            vector.add(flats.get(i).getFlatAddress());
            vector.add(flats.get(i).getFlatState());
            data.add(vector);
        }

        //System.out.println(columnNames);
        //System.out.println(data);

        //Setting up the model for the JTable
        model = new DefaultTableModel(data, columnNames){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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


        this.add(scroll);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Appartments List");
        setLocationRelativeTo(null);
        setVisible(false);
        setSize(600, 500);

    }


    public void addDoubleClickListener(MouseAdapter e)
    {
        table.addMouseListener(e);
    }


}