package com.polytech.bsm.model;

import java.util.ArrayList;

/**
 * This class will contain informations about a flat :
 *     - Its locals
 *     - Its address
 *     - Its description
 *     - Its state
 * @author Yohann BENETREAULT
 * @author Irteza SHEIKH MUHAMMAD
 * @version 0.1a
 *
 */

public class Flat {

	// Attributes
	private Integer flatID;
	private String flatAddress;
	private String flatDescription;
	private FlatState flatState;
	private ArrayList<Local> flatLocals;
	
	// Constructors
	public Flat() {
		this(null, null, null);
	}
	
	public Flat(Integer id, String address, String desc) {
		this.flatID = id;
		this.flatAddress = address;
		this.flatDescription = desc;
		this.flatState = FlatState.UNDER_CONSTRUCTION;
		this.flatLocals = new ArrayList<Local>();
	}
	
	// Getters and setters
	public Integer getFlatID() {
		return flatID;
	}
	public void setFlatID(Integer flatID) {
		this.flatID = flatID;
	}
	public String getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(String flatAddress) {
		this.flatAddress = flatAddress;
	}
	public String getFlatDescription() {
		return flatDescription;
	}
	public void setFlatDescription(String flatDescription) {
		this.flatDescription = flatDescription;
	}
	public FlatState getFlatState() {
		return flatState;
	}
	public void setFlatState(FlatState flatState) {
		this.flatState = flatState;
	}
	public ArrayList<Local> getFlatLocals() {
		return flatLocals;
	}
	public void setFlatLocals(ArrayList<Local> flatLocals) {
		this.flatLocals = flatLocals;
	}

	// Manage locals
	public void addLocal(Local local) throws Exception {
		
		if(!flatLocals.contains(local)) {
			flatLocals.add(local);
		} else {
			throw new Exception("Local already in the list.");
		}
	}
	
	public void removeLocal(Local local) throws Exception {
		
		if(flatLocals.contains(local)) {
			flatLocals.remove(local);
		} else {
			throw new Exception("Local doesn't exist in the list.");
		}
	}
}
