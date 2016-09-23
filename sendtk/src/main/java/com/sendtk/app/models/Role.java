package com.sendtk.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="role")
public class Role  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288259080163292779L;
	
	@Id
	@GeneratedValue
	private int Id;
	private String RoleName;
	
	@OneToMany(fetch = FetchType.LAZY ,targetEntity = User.class)
	@ElementCollection(targetClass= User.class)
	private Set<User> User = new HashSet<User>(0);

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
	 * @return the roleName
	 */
	public String getRoleName() {
		return RoleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	/**
	 * @return the user
	 */
	public Set<User> getUser() {
		return User;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Set<User> user) {
		User = user;
	}
	

}
