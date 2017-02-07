package com.noteapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noteapp.model.Note;
import com.noteapp.model.User;
import com.noteapp.service.*;
import com.noteapp.serviceImpl.*;

@Controller
public class HomeController {
	
	private LoginService loginService = new LoginServiceImpl();
	private DownloadNoteService downlodNoteService = new DownloadNoteServiceImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		System.out.println("home");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String, List<Note>> login(@RequestBody User user){
		System.out.println(loginService.getUserData().get(1).getUserName());
		System.out.println(user.getPassword());
		
		Map<String, List<Note>> map = new HashMap<String, List<Note>>();
		
		for(User userFromData : loginService.getUserData()){
			if(user.getUserName().equalsIgnoreCase(userFromData.getUserName()) && 
					user.getPassword().equals(userFromData.getPassword())){
				
				map.put(user.getUserName(), downlodNoteService.getNoteList());
				
				return map;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody 
	public void deleteNote(@RequestBody Note note){
		downlodNoteService.deleteNoteList(note);
	}

	@RequestMapping(value = "/createNote", method = RequestMethod.POST)
	@ResponseBody 
	public void createNote(@RequestBody Note note){
		downlodNoteService.createNewNote(note);
	}
	
	@RequestMapping(value = "/editNote", method = RequestMethod.POST)
	@ResponseBody 
	public void editNote(@RequestBody List<Note> noteList){
		downlodNoteService.setNoteList(noteList);
	}
}
