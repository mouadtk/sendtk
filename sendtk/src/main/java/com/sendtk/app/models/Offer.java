package com.sendtk.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="Offer")
public class Offer  implements Serializable {
	
	/**
	 * 
	 */
	public static final long serialVersionUID = -3357423713800619481L;
	
	
	@Id @GeneratedValue 
	private int Id;
	private String Reference;
	private String Name;
	private String Description;
	private String Restrictions;
	private String GeoRestriction;
	private String Vertical;
	private String Affiliate;
	
	@ElementCollection(fetch = FetchType.EAGER) 
	@MapKeyColumn(name="id")
    @Column(name="value")	
	private Map<Integer, String> Subjects;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name="id")
    @Column(name="value")	
	private Map<Integer, String> Froms;
	
	@ElementCollection(fetch = FetchType.EAGER) 
	@MapKeyColumn(name="name")
    @Column(name="Link")
	private Map<String, String>  Creatives;
	
	private String SuppLsitLink;
	private String UnsubListLink;
	private Float  Payout;
	private String PayoutFormat;
	
	/** Related Objects**/
	
	@OneToMany(fetch = FetchType.LAZY ,targetEntity = Campaign.class, mappedBy = "Offer")
	//@ElementCollection(targetClass= Campaign.class)
	@JsonIgnore
	private Set<Campaign> Cmps = new HashSet<Campaign>(0);
	
	public Offer(){}
	
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
		this.Id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the restrictions
	 */
	public String getRestrictions() {
		return Restrictions;
	}
	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(String restrictions) {
		Restrictions = restrictions;
	}
	/**
	 * @return the geoRestriction
	 */
	public String getGeoRestriction() {
		return GeoRestriction;
	}
	/**
	 * @param geoRestriction the geoRestriction to set
	 */
	public void setGeoRestriction(String geoRestriction) {
		GeoRestriction = geoRestriction;
	}
	
	/**
	 * @return the suppLsitLink
	 */
	public String getSuppLsitLink() {
		return SuppLsitLink;
	}
	/**
	 * @param suppLsitLink the suppLsitLink to set
	 */
	public void setSuppLsitLink(String suppLsitLink) {
		SuppLsitLink = suppLsitLink;
	}
	/**
	 * @return the unsubListLink
	 */
	public String getUnsubListLink() {
		return UnsubListLink;
	}
	/**
	 * @param unsubListLink the unsubListLink to set
	 */
	public void setUnsubListLink(String unsubListLink) {
		UnsubListLink = unsubListLink;
	}
	/**
	 * @return the payout
	 */
	public Float getPayout() {
		return Payout;
	}
	/**
	 * @param payout the payout to set
	 */
	public void setPayout(Float payout) {
		Payout = payout;
	}
	/**
	 * @return the payoutFormat
	 */
	public String getPayoutFormat() {
		return PayoutFormat;
	}
	/**
	 * @param payoutFormat the payoutFormat to set
	 */
	public void setPayoutFormat(String payoutFormat) {
		PayoutFormat = payoutFormat;
	}

	public String getVertical() {
		return Vertical;
	}

	public void setVertical(String vertical) {
		Vertical = vertical;
	}

	public String getAffiliate() {
		return Affiliate;
	}

	public void setAffiliate(String affiliate) {
		Affiliate = affiliate;
	}

	/**
	 * @return the creatives
	 */
	
	public Map<String, String> getCreatives() {
		return Creatives;
	}
	
	/**
	 * @param creatives the creatives to set
	 */
	public void setCreatives(Map<String, String> creatives) {
		Creatives = creatives;
	}

	/**
	 * @return the subjects
	 */
	public Map<Integer, String> getSubjects() {
		return Subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Map<Integer, String> subjects) {
		Subjects = subjects;
	}

	/**
	 * @return the froms
	 */
	public Map<Integer, String> getFroms() {
		return Froms;
	}

	/**
	 * @param froms the froms to set
	 */
	public void setFroms(Map<Integer, String> froms) {
		Froms = froms;
	}

	/**
	 * @return the cmps
	 */
	@JsonIgnore
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
