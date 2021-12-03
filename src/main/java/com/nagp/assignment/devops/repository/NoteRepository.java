package com.nagp.assignment.devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.assignment.devops.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}


