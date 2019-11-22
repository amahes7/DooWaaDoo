package com.DooWahDoo.Main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Repo.KaraokeRepo;

@Component
public class MusicControlService {

	@Autowired
	private KaraokeRepo karaokeRepo;

	public String playSong(long sessionId) {
		boolean flag = false;
		List<KaraokeSession> sessionList = karaokeRepo.findAll();
		for (KaraokeSession session : sessionList) {
			if (session.getSessionId() == sessionId) {
				session.setCurrent(true);
				karaokeRepo.save(session);
				flag = true;
				break;
			}
		}
		if (flag) {
			return "Success";
		} else {
			return "Fail";
		}
	}

	public String stopSong(long sessionId) {
		boolean flag = false;
		List<KaraokeSession> sessionList = karaokeRepo.findAll();
		for (KaraokeSession session : sessionList) {
			if (session.getSessionId() == sessionId) {
				session.setDone(true);
				session.setCurrent(false);
				karaokeRepo.save(session);
				flag = true;
				break;
			}
		}
		if (flag) {
			return "Success";
		} else {
			return "Fail";
		}
	}

}
