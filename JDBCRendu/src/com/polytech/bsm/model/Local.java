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
	private Integer localID;
	private LocalType localType;
	private Integer localSize;
	private Integer localSpec;
	private ArrayList<Local> localLinks;
	
	// Constructors	
	public Local(Integer id, LocalType type, Integer size, Integer spec) {
		this.localID = id;
		this.localType = type;
		this.localSize = size;
		this.localSpec = spec;
		this.localLinks = new ArrayList<Local>();
	}

	// Getters and setters
	public Integer getLocalID() {
		return localID;
	}
	public void setLocalID(Integer localID) {
		this.localID = localID;
	}
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
	public ArrayList<Local> getLocalLinks() {
		return localLinks;
	}
	public void setLocalLinks(ArrayList<Local> localLinks) {
		this.localLinks = localLinks;
	}
	
	// Manage links
	public void addLink(Local local) throws Exception {
		
		if(!localLinks.contains(local) && local.getLocalLinks().contains(this)) {
			localLinks.add(local);
			local.getLocalLinks().add(this);
		} else {
			throw new Exception("Link already exists.");
		}
	}
	
	public void removeLink(Local local) throws Exception {
		
		if(localLinks.contains(local) && local.getLocalLinks().contains(this)) {
			localLinks.remove(local);
			local.getLocalLinks().remove(this);
		} else if (!localLinks.contains(local) && local.getLocalLinks().contains(this)) {
			local.getLocalLinks().remove(this);
		} else if (localLinks.contains(local) && !local.getLocalLinks().contains(this)) {
			localLinks.remove(local);
		} else {
			throw new Exception("Link doesn't exist.");
		}
	}
}
