package com.DooWahDoo.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "karaoke_session")
public class KaraokeSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "session_id")
	private long sessionId;
	
	@Column(name = "is_done")
	private boolean isDone;
	
	@Column(name = "is_current")
	private boolean isCurrent;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="user_id")
	private UserProfile userProfile;
	
	
	@ManyToOne
	@JoinColumn(name="gig_id")
	private GigInfo gigInfo;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="music_id")
	private MusicLibrary musicLibrary;

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public GigInfo getGigInfo() {
		return gigInfo;
	}

	public void setGigInfo(GigInfo gigInfo) {
		this.gigInfo = gigInfo;
	}

	public MusicLibrary getMusicLibrary() {
		return musicLibrary;
	}

	public void setMusicLibrary(MusicLibrary musicLibrary) {
		this.musicLibrary = musicLibrary;
	}
	
	

}
