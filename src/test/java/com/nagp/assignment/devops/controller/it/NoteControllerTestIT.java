package com.nagp.assignment.devops.controller.it;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagp.assignment.devops.controller.NoteController;
import com.nagp.assignment.devops.model.Note;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("it")
public class NoteControllerTestIT {

	MockMvc mockMvc;

	@Autowired
	NoteController noteController;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(this.noteController).build();
	}
	
	@Test
	public void testCreateNotes() throws Exception {
		Note note = new Note();
		note.setTitle("Test Title");
		note.setContent("Test content");

		mockMvc.perform(post("/api/notes").contentType(MediaType.APPLICATION_JSON).content(asJsonString(note))).andExpect(status().isOk());
	}

	@Test
	public void testGetNotes() throws Exception {
		mockMvc.perform(get("/api/notes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@AfterEach
	public void finish() {
		List<Note> notes = noteController.getAllNotes().stream().filter(n -> n.getTitle().equals("Test Title")).collect(Collectors.toList());
		for(Note n: notes) {
			noteController.deleteNote(n);
		}
		
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  

}
