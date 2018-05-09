package com.music.app.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playlisttable")
public class Playlist {
	//property mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLAYLISTID", unique = true, nullable = false)
	private int playlistid;
	
	@Column(name="PLAYLISTNAME")
	private String playlistname;

	
	//entity mapping
	@ManyToOne
	private User user;
	
	@OneToMany()
	@JoinColumn(name = "playlist_id")
	private List<Song> songinlist;
	

	
	public Playlist(){
		
	}



	public String getPlaylistname() {
		return playlistname;
	}



	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}



	public int getPlaylistid() {
		return playlistid;
	}



	public void setPlaylistid(int playlistid) {
		this.playlistid = playlistid;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Song> getSonginlist() {
		return songinlist;
	}



	public void setSonginlist(List<Song> songinlist) {
		this.songinlist = songinlist;
	}
	
}
