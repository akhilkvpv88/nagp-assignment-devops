package com.nagp.assignment.devops.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nagp.assignment.devops.model.Note;
import com.nagp.assignment.devops.repository.NoteRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class NoteControllerTest {

	@InjectMocks
	NoteController noteController;

	@Mock
	NoteRepository noteRepository;
	
	@Test
	public void testCreateNote() {

		Note note = new Note();
		note.setTitle("Test Title");
		note.setContent("Test content");

		noteController.createNote(note);

		verify(noteRepository, (times(1))).save(note);

	}

	@Test
	public void testGetNotes() {

		Note note1 = new Note();
		note1.setTitle("Test Title");
		note1.setContent("Test content");

		Note note2 = new Note();
		note2.setTitle("Test Title2");
		note2.setContent("Test content2");

		List<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);

		when(noteRepository.findAll()).thenReturn(notes);

		List<Note> notesList = noteController.getAllNotes();

		verify(noteRepository, (times(1))).findAll();
		assertNotNull(notesList);
		assertEquals(2, notesList.size());

	}
}
