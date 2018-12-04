package com.polytech.bsm.model;

import java.util.ArrayList;

/**
 * This classe will contain informations about a flat :
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
		this.flatState = null;
		this.flatLocals = new ArrayList<Local>();
	}
}
