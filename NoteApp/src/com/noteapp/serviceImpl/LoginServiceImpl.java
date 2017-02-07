package com.noteapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.noteapp.service.LoginService;
import com.noteapp.model.User;

public class LoginServiceImpl implements LoginService{
	
	private List<User> userData = new ArrayList<User>();
	
	public LoginServiceImpl(){
		User william = new User();
		william.setId(1);
		william.setPassword("william");
		william.setUserName("william");
		
		User petter = new User();
		petter.setId(2);
		petter.setPassword("petter");
		petter.setUserName("petter");
		
		User yuvia = new User();
		yuvia.setId(3);
		yuvia.setPassword("yuvia");
		yuvia.setUserName("yuvia");
		
		User tom = new User();
		tom.setId(4);
		tom.setPassword("tom");
		tom.setUserName("tom");
		
		userData.add(william);
		userData.add(petter);
		userData.add(yuvia);
		userData.add(tom);
	}

	public List<User> getUserData() {
		return userData;
	}

	public void setUserData(List<User> userData) {
		this.userData = userData;
	}
}
