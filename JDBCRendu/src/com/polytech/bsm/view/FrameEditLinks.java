package com.polytech.bsm.view;

import com.polytech.bsm.model.Local;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

public class FrameEditLinks extends JFrame  {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JLabel txtSelectedLocal;
	private JList linkedLocalList;
	private JList allLocalList;
	private JButton linkLocalBtn;
	private JComboBox localComboBox;
	private JButton unlinkLocalBtn;
	private JButton btnDone;
	private DefaultListModel<Integer> listForLinks ;

	public FrameEditLinks() {

		getContentPane().setLayout(null);

		listForLinks = new DefaultListModel<>();
		
		linkedLocalList = new JList();
		linkedLocalList.setBounds(459, 76, 193, 293);
		linkedLocalList.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		getContentPane().add(linkedLocalList);

		linkLocalBtn = new JButton("");
		linkLocalBtn.setIcon(new ImageIcon(FrameEditLinks.class.getResource("/com/polytech/bsm/view/right-arrow.png")));
		linkLocalBtn.setBounds(410, 191, 44, 29);
		getContentPane().add(linkLocalBtn);

		allLocalList = new JList<>();
		allLocalList.setBounds(212, 76, 193, 293);
		allLocalList.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		getContentPane().add(allLocalList);
		
		txtSelectedLocal = new JLabel();
		txtSelectedLocal.setText("Selected Local");
		txtSelectedLocal.setBounds(22, 90, 150, 26);
		getContentPane().add(txtSelectedLocal);

		unlinkLocalBtn = new JButton("");
		unlinkLocalBtn.setIcon(new ImageIcon(FrameEditLinks.class.getResource("/com/polytech/bsm/view/left-arrow.png")));
		unlinkLocalBtn.setBounds(410, 232, 44, 29);
		getContentPane().add(unlinkLocalBtn);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		btnDone = new JButton("Done");
		btnDone.setBounds(535, 397, 117, 29);
		getContentPane().add(btnDone);
		// Main window setup
		setTitle("Edit links");
		setSize(689, 498);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

	public void setLocalComboBox(ArrayList<Local> locals)
	{
		Vector<Integer> localID = new Vector<Integer>();
		for (int i = 0; i <locals.size(); i++)
		{
			localID.addElement(locals.get(i).getLocalID());
		}
		System.out.println(localID);


		localComboBox= new JComboBox<Integer>(localID);
		localComboBox.setBounds(22, 128, 161, 27);
		getContentPane().add(localComboBox);
	}

	public void setLocalList(ArrayList<Local> locals, int currentLocalId)
	{
		System.out.println(currentLocalId);
		DefaultListModel<Integer> listModel = new DefaultListModel<>();
		for(int i=0; i <locals.size(); i++)
		{
			if(locals.get(i).getLocalID()!=currentLocalId)
			{
				listModel.addElement(locals.get(i).getLocalID());
			}
		}
		//create the list
		allLocalList.setModel(listModel);
	}

	public int getCurrentLocalId()
	{
		return (Integer) localComboBox.getSelectedItem();
	}

	public void addJComboBoxListener(ItemListener comboBoxListener)
	{
		localComboBox.addItemListener(comboBoxListener);
	}

	public void eraseLocalList()
	{
		allLocalList.setListData(new Object[0]);

		linkedLocalList.setListData(new Object[0]);
		listForLinks = new DefaultListModel<>();
	}

	public void addLinkButtonListener(ActionListener listenerAddlink)
	{
		linkLocalBtn.addActionListener(listenerAddlink);
	}
	public void removeLinkButtonListener(ActionListener listenerRemoveLink)
	{
		unlinkLocalBtn.addActionListener(listenerRemoveLink);
	}

	public int getSelectedLocal()
	{
		return (int) allLocalList.getSelectedValue();
	}

	public void addLink(int localID)
	{
		listForLinks.addElement(localID);
		linkedLocalList.setModel(listForLinks);
	}
	public void removeLink(int localID)
	{
		for(int i=0; i<listForLinks.size(); i++)
		{
			if(listForLinks.get(i).intValue()==localID)
			{
				listForLinks.removeElementAt(i);
			}
		}
	}

	public int getSelectedLinkLocalID()
	{
		return (int) linkedLocalList.getSelectedValue();
	}

	public void addButtonDoneListener(ActionListener listenerButtonDone)
	{
		btnDone.addActionListener(listenerButtonDone);
	}

	public ArrayList<Integer> getLocalToBeLink()
	{
		ArrayList<Integer> locals = new ArrayList<>();
		for (int i =0 ;i<listForLinks.size(); i++)
		{
			locals.add(listForLinks.get(i).intValue());
		}
		return locals;
	}
}
