package com.sendtk.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Settings")
public class Settings implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 48038790944903367L;
	
	@Id @GeneratedValue 
	private int Id;
	private String Reference; /** */
	private int Msg_Per_IP; 
	private int Seed;
	private int xDelay;
	private int countDelay;
	private int Fraction;
	private int _Index;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity= Campaign.class)
	private  Campaign Campaign;
	
	public Settings(){}
	
	public Settings(int MSGIP, int SED, int DELAY, int COUNT, int FRACT, int I){
		
		Msg_Per_IP= MSGIP;
		Seed		  = SED;
		xDelay	  = DELAY;
		countDelay= COUNT;
		Fraction  = FRACT;
		_Index     = I;
	} 
	
	
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
	 * @return the msg_Per_IP
	 */
	public int getMsg_Per_IP() {
		return Msg_Per_IP;
	}
	/**
	 * @param msg_Per_IP the msg_Per_IP to set
	 */
	public void setMsg_Per_IP(int msg_Per_IP) {
		Msg_Per_IP = msg_Per_IP;
	}
	/**
	 * @return the sed
	 */
	public int getSed() {
		return Seed;
	}
	/**
	 * @param sed the sed to set
	 */
	public void setSed(int sed) {
		Seed = sed;
	}
	/**
	 * @return the xDelay
	 */
	public int getxDelay() {
		return xDelay;
	}
	/**
	 * @param xDelay the xDelay to set
	 */
	public void setxDelay(int xDelay) {
		this.xDelay = xDelay;
	}
	/**
	 * @return the countDelay
	 */
	public int getCountDelay() {
		return countDelay;
	}
	/**
	 * @param countDelay the countDelay to set
	 */
	public void setCountDelay(int countDelay) {
		this.countDelay = countDelay;
	}
	/**
	 * @return the fraction
	 */
	public int getFraction() {
		return Fraction;
	}
	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(int fraction) {
		Fraction = fraction;
	}

	/**
	 * @return the _Index
	 */
	public int get_Index() {
		return _Index;
	}

	/**
	 * @param _Index the _Index to set
	 */
	public void set_Index(int _Index) {
		this._Index = _Index;
	}
	

	public int IncrementIndex(){
		return _Index++;
	}

	/**
	 * @return the campaign
	 */
	public Campaign getCampaign() {
		return Campaign;
	}

	/**
	 * @param campaign the campaign to set
	 */
	public void setCampaign(Campaign campaign) {
		Campaign = campaign;
	}
	
}
	
