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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Campaign")
public class Campaign implements Serializable{
	
	/**
	 * 
	 */
	public static final long serialVersionUID = -1609607067392949672L;
	
	@Id @GeneratedValue 
	private int Id;
	private String Ref;
	private String Headers;
	@Column(name = "Body")
	@Type(type="text")
	private String Body;
	@Column(name = "Date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Date;
	private String Status;
	
	/**
	 * Related Objects
	 **/
	@ManyToOne(fetch = FetchType.LAZY)
	private  Offer  Offer;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity= User.class)
	private  User Mailer;
	
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = MailList.class)
	@JoinTable(name="MailList_Campaign", 
			   joinColumns={@JoinColumn(name="MailList_ID")}, 
			   inverseJoinColumns={@JoinColumn(name="Campaign_ID")})
    private Set<MailList> mailLists = new HashSet<MailList>(0);
	
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = VirtualServer.class)
    private Set<VirtualServer> Server = new HashSet<VirtualServer>(0);
	
	@ManyToMany(fetch = FetchType.LAZY ,targetEntity = Liste.class)
    private Set<Liste> Listes = new HashSet<Liste>(0);
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity= Settings.class)
	private  Settings Settings;
	
	
	/**                       Getters & Setters                       */
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
	 * @return the ref
	 */
	public String getRef() {
		return Ref;
	}

	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		Ref = ref;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return Date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		Date = date;
	}

	/**
	 * @return the offer
	 */
	@ManyToOne	
	public Offer getOffer() {
		return this.Offer;
	}

	/**
	 * @param offer the offer to set
	 */
	
	public void setOffer( Offer offer) {
		Offer = offer;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the mailer
	 */
	public User getMailer() {
		return Mailer;
	}

	/**
	 * @param mailer the mailer to set
	 */
	public void setMailer(User mailer) {
		Mailer = mailer;
	}

	/**
	 * @return the mailLists
	 */
	public Set<MailList> getMailLists() {
		return mailLists;
	}

	/**
	 * @param mailLists the mailLists to set
	 */
	public void setMailLists(Set<MailList> mailLists) {
		this.mailLists = mailLists;
	}

	/**
	 * @return the headers
	 */
	public String getHeaders() {
		return Headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String headers) {
		Headers = headers;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return Body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		Body = body;
	}

	/**
	 * @return the server
	 */
	@ManyToMany
	public Set<VirtualServer> getServer() {
		return Server;
	}

	/**
	 * @param server the server to set
	 */
	@ManyToMany
	public void setServer(Set<VirtualServer> server) {
		Server = server;
	}

	/**
	 * @return the settings
	 */
	public Settings getSettings() {
		return Settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
		Settings = settings;
	}

	/**
	 * @return the listes
	 */
	public Set<Liste> getListes() {
		return Listes;
	}

	/**
	 * @param listes the listes to set
	 */
	public void setListes(Set<Liste> listes) {
		Listes = listes;
	}
	
	
}
