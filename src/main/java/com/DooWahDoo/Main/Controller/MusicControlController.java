package com.DooWahDoo.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Service.MusicControlService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MusicControlController {

	@Autowired
	MusicControlService musicControlService;

	@GetMapping("/sessionId/{sessionId}/play")
	public String playSong(@PathVariable("sessionId") long sessionId) {
		return musicControlService.playSong(sessionId);
	}

	@GetMapping("/sessionId/{sessionId}/stop")
	public String stopSong(@PathVariable("sessionId") long sessionId) {
		return musicControlService.stopSong(sessionId);
	}

}
