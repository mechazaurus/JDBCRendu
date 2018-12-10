package com.polytech.bsm.view;

import com.polytech.bsm.model.Local;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class FrameLocalInformations extends JFrame
{
    private Vector<String> columnNames;
    private Vector<Vector<Object>> data;
    private JTable table;
    private DefaultTableModel model;

	public FrameLocalInformations(ArrayList<Local> locals) {
		getContentPane().setLayout(null);
		

		table = new JTable();

        columnNames = new Vector<String>();
        String [] col = new String[]{"idLocal","LocalType", "Size", "Description"};

        //Set columns name
        for (int i = 0; i<col.length; i++)
        {
            columnNames.add(col[i]);
        }

        data = new Vector<Vector<Object>>();

        for(int i =0; i<locals.size(); i++)
        {
            Vector<Object> vector = new Vector<Object>();
            vector.add(locals.get(i).getLocalID());
            vector.add(locals.get(i).getLocalType());
            vector.add(locals.get(i).getLocalSize());
            vector.add(locals.get(i).getLocalSpec());
            data.add(vector);
        }

        //Setting up the model for the JTable
        model = new DefaultTableModel(data, columnNames){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        getContentPane().setLayout(null);
        //Adding columns names
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 53, 600, 425);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        getContentPane().add(scroll);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Locals List");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(false);

	}
}
