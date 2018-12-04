package com.polytech.bsm.model;

import java.util.ArrayList;

/**
 * This class will contain informations about a flat :
 *     - Its locals
 *     - Its address
 *     - Its description
 *     - Its state
 * @author Yohann BENETREAULT
 * @author Irteza SEIKH MUHAMMAD
 * @version 0.1a
 *
 */

public class Flat {

	// Attributes
	private String flatAddress;
	private String flatDescription;
	private FlatState flatState;
	private ArrayList<Local> flatLocals;
	
	// Constructors
	public Flat() {
		this(null, null);
	}
	
	public Flat(String address, String desc) {
		this.flatAddress = address;
		this.flatDescription = desc;
		this.flatState = FlatState.UNDER_CONSTRUCTION;
		this.flatLocals = new ArrayList<Local>();
	}
	
	// Getters and setters
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
}
