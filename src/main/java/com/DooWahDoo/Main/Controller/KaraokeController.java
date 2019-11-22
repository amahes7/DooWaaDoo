package com.DooWahDoo.Main.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Model.UserQueueDetails;
import com.DooWahDoo.Main.Service.KaraokeService;

@CrossOrigin
@RestController
@RequestMapping("/Karaoke")
public class KaraokeController {

	@Autowired
	KaraokeService karaokeservice;

	@PostMapping("/createSession")
	public KaraokeSession createSession(@Valid @RequestBody Map<String, String> payload) {
		System.out.println("I'm here 1");
		List<String> idList = karaokeservice.setIdsFromPayload(payload);
		System.out.println(idList);
		return karaokeservice.createKaraokeSession(idList.get(0), idList.get(1), idList.get(2));

	}

	@GetMapping("/getUserQueue")
	public List<UserQueueDetails> getSessions() {
		return karaokeservice.getUsers();

	}
	
	@GetMapping("/sessionId/{sessionId}/getSeesionDetailsById/")
	public Optional<KaraokeSession> getSeesionDetailsById(@PathVariable("sessionId") long sessionId) {
		return karaokeservice.getSeesionDetailsById(sessionId);

	}

	@GetMapping("/gig/{gigId}/getUserQueue")
	public List<UserQueueDetails> getSessions(@PathVariable("gigId") long gigId) {
		// Implement logic for GigID in future
		// Currently Out of Scope
		return karaokeservice.getUsers();
	}
	
	@GetMapping("/gig/{gigId}/getCurrentUserQueue")
	public UserQueueDetails getCurrentUser(@PathVariable("gigId") long gigId) {
		// Implement logic for GigID in future
		// Currently Out of Scope
		return karaokeservice.getCurrentUser();

	}

//	@PostMapping("/deleteSession")
//	public void deleteSession(@Valid @RequestBody KaraokeSession karaokeSession) {
//		karaokeRepo.delete(karaokeSession);
//	}

}
