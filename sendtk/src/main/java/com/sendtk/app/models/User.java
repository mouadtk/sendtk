package com.sendtk.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;


@Entity
@Table(name="User", uniqueConstraints = @UniqueConstraint(columnNames = { "Username" }))
public class User implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1172335220262425201L;
	
	@Id
	@GeneratedValue
	private int Id;
	private String Ref;
	private String Username;
	private String Passwd;
	private String FirstName;
	private String LastName;
	private String Type;
	private String Status;
	@Type(type="date")
	private Date Date;
	
	/** Related Objects**/
	@OneToMany(fetch = FetchType.LAZY ,targetEntity = Campaign.class)
	@ElementCollection(targetClass= Campaign.class)
	private Set<Campaign> Cmps = new HashSet<Campaign>(0);
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity= Role.class)
	private Role role;
	
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}
	
	public boolean isActive(){
		return (Status == "active");
	}
}
