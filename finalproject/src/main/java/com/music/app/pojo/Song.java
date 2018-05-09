package com.music.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="songtable")
public class Song {
	//property mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="SONGID", unique = true, nullable = false)
	private int songid;
	
	@Column (name="SONGNAME")
	private String songname;

	
	@Column (name="URL")
	private String url;
	

	
	//entity mapping
	@ManyToOne
	private Artist artist;   // owning side
	

	
	public Song(){
		
	}
	


	public Artist getArtist() {
		return artist;
	}



	public void setArtist(Artist artist) {
		this.artist = artist;
	}



	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
