package com.DooWahDoo.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "sign_up")
public class SignUp {
	
	
	@Id
	@Column(name = "email_id")
	@NotNull
	private String emailId;
	
	@Column(name = "password")
	@NotNull
	@Transient
	private String password;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;
	
	@OneToOne
	@JoinColumn(name="dj_id")
	private DjProfile djProfile;

	@Column(name="user_type")
	private boolean userType; //0 for Singer, 1 for dj;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public DjProfile getDjProfile() {
		return djProfile;
	}

	public void setDjProfile(DjProfile djProfile) {
		this.djProfile = djProfile;
	}

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}



	
	
}
