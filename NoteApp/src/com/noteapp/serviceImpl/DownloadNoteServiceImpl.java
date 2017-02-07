package com.noteapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.noteapp.model.Note;
import com.noteapp.service.DownloadNoteService;

public class DownloadNoteServiceImpl implements DownloadNoteService{
	
	private List<Note> NoteList = new ArrayList<Note>();
	
	public DownloadNoteServiceImpl(){
		List<String> lable1 = new ArrayList<String>();
		lable1.add("IT");
		
		Note williamNote = new Note();
		williamNote.setAuthor("william");
		williamNote.setContent("This is william's Note.");
		williamNote.setLabels(lable1);
		williamNote.setTitle("William IT Report");
		
		
		List<String> lable2 = new ArrayList<String>();
		lable2.add("Life");
		
		Note petterNote = new Note();
		petterNote.setAuthor("petter");
		petterNote.setContent("This is petter's Note.");
		petterNote.setLabels(lable2);
		petterNote.setTitle("petter IT Report");
		
		List<String> lable3 = new ArrayList<String>();
		lable3.add("Health");
		lable3.add("Sport");
		
		Note yuviaNote = new Note();
		yuviaNote.setAuthor("yuvia");
		yuviaNote.setContent("This is yuvia's Note.");
		yuviaNote.setLabels(lable3);
		yuviaNote.setTitle("yuvia IT Report");
		
		List<String> lable4 = new ArrayList<String>();
		lable4.add("Health");
		lable4.add("IT");
		
		Note tomNote = new Note();
		tomNote.setAuthor("tom");
		tomNote.setContent("This is tom's Note.");
		tomNote.setLabels(lable4);
		tomNote.setTitle("tom IT Report");
		
		NoteList.add(williamNote);
		NoteList.add(petterNote);
		NoteList.add(yuviaNote);
		NoteList.add(tomNote);
	}

	public List<Note> getNoteList() {
		return NoteList;
	}

	public void setNoteList(List<Note> noteList) {
		NoteList = noteList;
	}
	
	public void deleteNoteList(Note note){
		this.NoteList.remove(matchElementFromData(note));
	}
	
	public Note matchElementFromData(Note note){
		for( Note noteFromdata : this.NoteList){
		   if( noteFromdata.getAuthor().equals(note.getAuthor()) 
				   && noteFromdata.getContent().equals(note.getContent()) 
				   && noteFromdata.getLabels().equals(note.getLabels()))
		   {  
			   
			   for(String label : noteFromdata.getLabels()){
				   if(!note.getLabels().contains(label)){
					   return null;
				   }
			   }
			   
			   return noteFromdata;
		   }
		}
		return null;
	}

	public void createNewNote(Note note){
		this.NoteList.add(note);
	}

}
