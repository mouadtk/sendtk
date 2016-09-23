package com.sendtk.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="VirtualServer")
public class VirtualServer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6982833125172670042L;
	
	@Id @GeneratedValue 
	private int id;
	private String IP;
	private String  Name;
	private String VMTA;
	private String Rating;
	private boolean rDNS;
	
	
	/** Related Objects*/ 
	@ManyToOne(fetch = FetchType.LAZY, targetEntity= Server.class)
    private Server Server;
	
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = Campaign.class)
	private Set<Campaign> Cmps = new HashSet<Campaign>(0);
	/** */	   	  
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the iP
	 */
	public String getIP() {
		return IP;
	}
	/**
	 * @param iP the iP to set
	 */
	public void setIP(String iP) {
		IP = iP;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the vMTA
	 */
	public String getVMTA() {
		return VMTA;
	}
	/**
	 * @param vMTA the vMTA to set
	 */
	public void setVMTA(String vMTA) {
		VMTA = vMTA;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return Rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		Rating = rating;
	}
	/**
	 * @return the rDNS
	 */
	public boolean isrDNS() {
		return rDNS;
	}
	/**
	 * @param rDNS the rDNS to set
	 */
	public void setrDNS(boolean rDNS) {
		this.rDNS = rDNS;
	}
	/**
	 * @return the server
	 */
	@ManyToOne
	public Server getServer() {
		return Server;
	}
	/**
	 * @param server the server to set
	 */
	public void setServer(Server server) {
		Server = server;
	}
	/**
	 * @return the cmps
	 */
	public Set<Campaign> getCmps() {
		return Cmps;
	}
	/**
	 * @param cmps the cmps to set
	 */
	public void setCmps(Set<Campaign> cmps) {
		Cmps = cmps;
	}
}
