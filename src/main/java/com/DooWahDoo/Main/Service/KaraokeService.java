package com.DooWahDoo.Main.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.GigInfo;
import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Model.MusicLibrary;
import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Model.UserQueueDetails;
import com.DooWahDoo.Main.Repo.GigInfoRepo;
import com.DooWahDoo.Main.Repo.KaraokeRepo;
import com.DooWahDoo.Main.Repo.MusicLibRepo;
import com.DooWahDoo.Main.Repo.UserProfileRepo;

@Component
public class KaraokeService {
	@Autowired
	private KaraokeRepo karaokeRepo;
	@Autowired
	private UserProfileRepo userProfileRepo;
	@Autowired
	private MusicLibRepo musicLibRepo;

	@Autowired
	private GigInfoRepo gigRepo;

	public KaraokeSession createKaraokeSession(String userId, String musicId, String gigId) {
		System.out.println("I'm here 2");
		KaraokeSession karaokeSession = new KaraokeSession();
		System.out.println("I'm here 3");
		UserProfile user = userProfileRepo.getOne(Long.parseLong(userId));
		karaokeSession.setUserProfile(user);

		MusicLibrary musicLib = musicLibRepo.getOne(Long.parseLong(musicId));
		karaokeSession.setMusicLibrary(musicLib);

		GigInfo gig = gigRepo.getOne(Long.parseLong(gigId));
		karaokeSession.setGigInfo(gig);
		karaokeSession.setCurrent(false);
		karaokeSession.setDone(false);
		return karaokeRepo.save(karaokeSession);
	}

	public List<UserQueueDetails> getUsers() {
		List<KaraokeSession> sessions = karaokeRepo.findAll();
		List<UserQueueDetails> queueList = new ArrayList<>();
		for (KaraokeSession session : sessions) {
			UserQueueDetails userQueueDetails = new UserQueueDetails();
			if (!session.isDone() && !session.isCurrent()) {
				userQueueDetails.setSongName(session.getMusicLibrary().getTitle());
				userQueueDetails.setUserName(session.getUserProfile().getUserName());
				queueList.add(userQueueDetails);
			}
		}
		return queueList;

	}

	public UserQueueDetails getCurrentUser() {
		List<KaraokeSession> sessions = karaokeRepo.findAll();
		UserQueueDetails userQueueDetails = new UserQueueDetails();
		for (KaraokeSession session : sessions) {
			if (!session.isDone() && session.isCurrent()) {
				userQueueDetails.setSongName(session.getMusicLibrary().getTitle());
				userQueueDetails.setUserName(session.getUserProfile().getUserName());
				break;
			}
		}
		return userQueueDetails;

	}

	public List<String> setIdsFromPayload(Map<String, String> payload) {
		List<String> idList = new ArrayList<>();
		String userId = payload.get("userId");
		String musicId = payload.get("musicId");
		String gigId = payload.get("gigId");
		idList.add(userId);
		idList.add(musicId);
		idList.add(gigId);
		return idList;

	}

	public Optional<KaraokeSession> getSeesionDetailsById(long sessionId) {
		return karaokeRepo.findById(sessionId);
	}

}
