package com.sendtk.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Liste")
public class Liste implements Serializable{

	/**
	 * 
	 */
	public static final long serialVersionUID = -44584873287200031L;

	@Id @GeneratedValue 
	private int Id;
	private String Reference;
	private String Name;
	private String ISP;
	private String Type;
	private int Count;
	@Column(name = "DateEntree", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateEntree;
	@Column(name = "LastModif", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date LastModif;
	private String PATH_FILE;
	
	@Column(name="Active", columnDefinition="Decimal(10,2) default 1")
	private int Active;
	
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = Campaign.class)
	@JsonIgnore
	private Set<Campaign> Cmps = new HashSet<Campaign>(0);

	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return Reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		Reference = reference;
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
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * @return the iSP
	 */
	public String getISP() {
		return ISP;
	}
	/**
	 * @param iSP the iSP to set
	 */
	public void setISP(String iSP) {
		ISP = iSP;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return Count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		Count = count;
	}
	/**
	 * @return the dateEntree
	 */
	public Date getDateEntree() {
		return DateEntree;
	}
	/**
	 * @param dateEntree the dateEntree to set
	 */
	public void setDateEntree(Date dateEntree) {
		DateEntree = dateEntree;
	}
	/**
	 * @return the lastModif
	 */
	public Date getLastModif() {
		return LastModif;
	}
	/**
	 * @param lastModif the lastModif to set
	 */
	public void setLastModif(Date lastModif) {
		LastModif = lastModif;
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
	/**
	 * @return the pATH_FILE
	 */
	public String getPATH_FILE() {
		return PATH_FILE;
	}
	/**
	 * @param pATH_FILE the pATH_FILE to set
	 */
	public void setPATH_FILE(String pATH_FILE) {
		PATH_FILE = pATH_FILE;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		return Active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		Active = active;
	}
	
		
}
