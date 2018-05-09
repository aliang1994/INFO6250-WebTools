package com.music.app.dao;



public class DAOFactory {
	public UserDAO createUserDAO(){
       	return new UserDAO();       
	}	
	
	public MusicDAO createMusicDAO(){
       	return new MusicDAO();       
	}	
	
	public PlaylistDAO createPlaylistDAO(){
		return new PlaylistDAO();
	}
}