package com.DooWahDoo.Main.Model;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "first_name")
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	
	@Column(name = "profile_pic")
	private Blob profilePic;
	
	@Column(name = "contact_no")
	@NotNull
	private long contactNo;
	
	@Column(name = "user_name")
	@NotNull
	private String userName;
	
	@Column(name = "dob")
	private java.sql.Date dob;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="address_id")
	private AddressDetails addressDetails;
	
//	@OneToMany(mappedBy = "userProfile",cascade = CascadeType.ALL)
//	private List<KaraokeSession> karaokeSessions;
	
//	@OneToOne(mappedBy = "userProfile",cascade = CascadeType.ALL)
//	private SignUp signUp;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Blob getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

//	public List<KaraokeSession> getKaraokeSessions() {
//		return karaokeSessions;
//	}
//
//	public void setKaraokeSessions(List<KaraokeSession> karaokeSessions) {
//		this.karaokeSessions = karaokeSessions;
//	}

//	public SignUp getSignUp() {
//		return signUp;
//	}
//
//	public void setSignUp(SignUp signUp) {
//		this.signUp = signUp;
//	}
	
	

}
