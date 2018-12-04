package com.polytech.bsm.model;

import java.util.ArrayList;

/**
 * This class will contain informations about a local :
 *     - Its links
 *     - Its size
 *     - Its specs
 * @author Yohann BENETREAULT
 * @author Irteza SHEIKH MUHAMMAD
 * @version 0.1a
 */

public class Local {

	// Attributes
	private LocalType localType;
	private Integer localSize;
	private Integer localSpec;
	private ArrayList<Local> localLinks;
	
	// Constructors	
	public Local(LocalType type, Integer size, Integer spec) {
		this.localType = type;
		this.localSize = size;
		this.localSpec = spec;
	}

	// Getters and setters
	public LocalType getLocalType() {
		return localType;
	}
	public void setLocalType(LocalType localType) {
		this.localType = localType;
	}
	public Integer getLocalSize() {
		return localSize;
	}
	public void setLocalSize(Integer localSize) {
		this.localSize = localSize;
	}
	public Integer getLocalSpec() {
		return localSpec;
	}
	public void setLocalSpec(Integer localSpec) {
		this.localSpec = localSpec;
	}
}
