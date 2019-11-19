package com.DooWahDoo.Main.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Repo.MusicLibRepo;
import com.DooWahDoo.Main.SearchSong.MusicSearch;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MusicSearchService {
	@Autowired
	private MusicLibRepo musicLibRepo;

	public List<MusicSearch> getAllSongs() {

		List songsList = new ArrayList<>();
		songsList = musicLibRepo.findAll();
		return songsList;
	}

	public List<MusicSearch> getAllSongsByArtistName(String artist) {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		artist = extractString(artist);
		ObjectMapper oMapper = new ObjectMapper();
		List filteredSongs = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (String.valueOf(map.get("artist")).equalsIgnoreCase(artist)) {
				filteredSongs.add(song);
			}
		}
		return filteredSongs;
	}

	private String extractString(String artist) {
		return artist.substring(1, artist.length() - 1);
	}

	public List<MusicSearch> getAllSongsByTitle(String title) {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		title = extractString(title);
		ObjectMapper oMapper = new ObjectMapper();
		List filteredSongs = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (String.valueOf(map.get("title")).equalsIgnoreCase(title)) {
				filteredSongs.add(song);
			}
		}
		return filteredSongs;
	}

	public List<MusicSearch> getAllSongsByGenre(String genre) {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		genre = extractString(genre);
		ObjectMapper oMapper = new ObjectMapper();
		List filteredSongs = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (String.valueOf(map.get("genre")).equalsIgnoreCase(genre)) {
				filteredSongs.add(song);
			}
		}
		return filteredSongs;
	}

	public List<String> getAllSongsByArtistLetter(String artist) {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		artist = extractString(artist);
		ObjectMapper oMapper = new ObjectMapper();
		List<String> filteredArtist = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (String.valueOf(map.get("artist")).substring(0, artist.length()).equalsIgnoreCase(artist)) {
				if (!filteredArtist.contains(String.valueOf(map.get("artist"))))
					filteredArtist.add(String.valueOf(map.get("artist")));
			}
		}
		return filteredArtist;
	}

	public List<MusicSearch> getAllSongsByTitleLetter(String title) {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		title = extractString(title);
		ObjectMapper oMapper = new ObjectMapper();
		List filteredSongs = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (String.valueOf(map.get("title")).substring(0, title.length()).equalsIgnoreCase(title)) {
				filteredSongs.add(song);
			}
		}
		return filteredSongs;
	}

	public List<String> getAllGenre() {
		List songsList = new ArrayList<>();
		songsList = getAllSongs();
		ObjectMapper oMapper = new ObjectMapper();
		List<String> allGenre = new ArrayList<>();
		for (Object song : songsList) {
			Map<String, Object> map = oMapper.convertValue(song, Map.class);
			if (!allGenre.contains(String.valueOf(map.get("genre")).toUpperCase())) {
				allGenre.add(String.valueOf(map.get("genre")).toUpperCase());
			}
		}
		return allGenre;
	}

}
