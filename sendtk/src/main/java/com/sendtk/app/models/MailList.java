package com.sendtk.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MailList")
public class MailList implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -5735945025317117036L;
	
	@Id
	@GeneratedValue
	private int Id;
	private String Name;
	private String Rating;
	private String Type;
	private String Categorie;
	
	/**
	 * Temporary Attribute 
	 * */
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> emails;
	
	/**
	 * Related Objects
	 **/
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = Campaign.class)
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
	 * @return the categorie
	 */
	public String getCategorie() {
		return Categorie;
	}


	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		Categorie = categorie;
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