package com.sendtk.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="Server")
public class Server implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6176853723745618048L;
	
	@Id @GeneratedValue
	private int Id;
	private String Name;
	private String MainIP;
	private String Provider;
	private String User;
	private String Passwd;
	private String SSHPublicKey;
	private String SSHPrivateKey;
	private int SSHPort;
	private int SMTPPort;
	private String Status;
	
	@Column(name = "Date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateEntrer;
	
	/** Related Objects */
    @OneToMany(fetch = FetchType.LAZY ,targetEntity = VirtualServer.class)
	@ElementCollection(targetClass= VirtualServer.class)
	private Set<VirtualServer> VServer = new HashSet<VirtualServer>(0);
	
    @Transient
    private List<VirtualServer> CurrentVServer = new ArrayList<VirtualServer>(0);
	
    
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
	 * @return the mainIP
	 */
	public String getMainIP() {
		return MainIP;
	}
	/**
	 * @param mainIP the mainIP to set
	 */
	public void setMainIP(String mainIP) {
		MainIP = mainIP;
	}
	/**
	 * @return the provider
	 */
	public String getProvider() {
		return Provider;
	}
	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		Provider = provider;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return User;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		User = user;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return Passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		Passwd = passwd;
	}
	/**
	 * @return the sSHPublicKey
	 */
	public String getSSHPublicKey() {
		return SSHPublicKey;
	}
	/**
	 * @param sSHPublicKey the sSHPublicKey to set
	 */
	public void setSSHPublicKey(String sSHPublicKey) {
		SSHPublicKey = sSHPublicKey;
	}
	/**
	 * @return the sSHPrivateKey
	 */
	public String getSSHPrivateKey() {
		return SSHPrivateKey;
	}
	/**
	 * @param sSHPrivateKey the sSHPrivateKey to set
	 */
	public void setSSHPrivateKey(String sSHPrivateKey) {
		SSHPrivateKey = sSHPrivateKey;
	}
	/**
	 * @return the sSHPort
	 */
	public int getSSHPort() {
		return SSHPort;
	}
	/**
	 * @param sSHPort the sSHPort to set
	 */
	public void setSSHPort(int sSHPort) {
		SSHPort = sSHPort;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	/**
	 * @return the dateEntrer
	 */
	public Date getDateEntrer() {
		return DateEntrer;
	}
	/**
	 * @param dateEntrer the dateEntrer to set
	 */
	public void setDateEntrer(Date dateEntrer) {
		DateEntrer = dateEntrer;
	}
	public int getSMTPPort() {
		return SMTPPort;
	}
	public void setSMTPPort(int sMTPPort) {
		SMTPPort = sMTPPort;
	}
	/**
	 * @return the vServer
	 */
	
	public Set<VirtualServer> getVServer() {
		return VServer;
	}
	
	public List<VirtualServer> getCurrentVServer() {
		return this.CurrentVServer;
	}
	
	
	/**
	 * @param vServer the vServer to set
	 */
	public void setVServer(Set<VirtualServer> vServer) {
		VServer = vServer;
	}
	
	public void SetCurrentVServer(List<VirtualServer> vServer){
		CurrentVServer =  vServer;
	}
	
	public void addCurrentVServer(VirtualServer vServer){
		CurrentVServer.add(vServer);
	}
	
	@Override
    public boolean equals(Object tobj) {
       if (!(tobj instanceof Server))
            return false;
        if (tobj == this)
            return true;

        final  Server obj = (Server) tobj;
        return (obj.Id ==  this.Id || obj.MainIP == this.MainIP);
    }
	
	@Override
	public int hashCode() {
	    int hash = 13;
	    return hash = 53 * hash + (this.Id != 0 ? this.MainIP.hashCode() : 0) + this.MainIP.hashCode();
	}
}
