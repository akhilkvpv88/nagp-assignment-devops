package com.nagp.assignment.devops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignment.devops.model.Note;
import com.nagp.assignment.devops.repository.NoteRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class NoteController {
	
	@Autowired
    NoteRepository noteRepository;
	
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note note) {
		log.info("Creating note with title {}", note.getTitle());
	    return noteRepository.save(note);
	}
	
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		log.info("Fetching all notes");
	    return noteRepository.findAll();
	}
	
	@DeleteMapping("/notes")
	public void deleteNote(Note note) {
		log.info("Deleting a note");
	    noteRepository.delete(note);
	}
	
}
