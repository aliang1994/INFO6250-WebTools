package com.music.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artisttable")
public class Artist {
	//property mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ARTISTID", unique=true, nullable=false)
	private int artistid;
	
	@Column(name="ARTISTNAME")
	private String artistname;
	
	//entity mapping: non-owning side
	@OneToMany(mappedBy="artist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Song> songlist;     
	
	

	public Artist(){
		
	}

	public int getArtistid() {
		return artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}	

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public List<Song> getSonglist() {
		return songlist;
	}

	public void setSonglist(List<Song> songlist) {
		this.songlist = songlist;
	}
}