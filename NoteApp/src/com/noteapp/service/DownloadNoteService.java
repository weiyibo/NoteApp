package com.noteapp.service;

import java.util.List;

import com.noteapp.model.Note;

public interface DownloadNoteService {
	List<Note> getNoteList();
	void setNoteList(List<Note> noteList);
	void deleteNoteList(Note note);
	Note matchElementFromData(Note note);
	void createNewNote(Note note);
}
