package com.music.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.music.app.dao.DAOFactory;
import com.music.app.dao.MusicDAO;
import com.music.app.pojo.Artist;
import com.music.app.pojo.Song;

@Controller
public class MusicController {

	@Autowired
	private DAOFactory factory;
	
	public MusicController(){
		
	}
	
	@RequestMapping(value="/admin/music.htm", method = RequestMethod.GET)
	public String displayArtists(HttpServletRequest request){
		MusicDAO mdao = factory.createMusicDAO();
		List<Artist> artistlist = mdao.displayArtists();
		HttpSession session = request.getSession();
		session.setAttribute("artistlist", artistlist);
		return "admin-music-managemusic";
	}
	
	@RequestMapping(value="/admin/music/view.htm", method = RequestMethod.GET)
	public String viewArtist(HttpServletRequest request){
		
		int artistid = Integer.parseInt(request.getParameter("artistid"));
		
		MusicDAO mdao = factory.createMusicDAO();
		Artist artist = mdao.getArtistById(artistid);
		
		HttpSession session = request.getSession();
		session.setAttribute("artistid", artistid);
		session.setAttribute("artist", artist);
		
		return "admin-music-showartist";
	}
	
	@RequestMapping(value="/admin/music/add.htm", method = RequestMethod.GET)
	public String addArtistForm(HttpServletRequest request){			
		return "admin-music-addartist";
	}
	
	@RequestMapping(value="/admin/music/add.htm", method = RequestMethod.POST)
	public String handleArtistForm(HttpServletRequest request){		

		MusicDAO mdao = factory.createMusicDAO();
		String artistname = request.getParameter("artistname");
		
		Artist artist = new Artist();
		artist.setArtistname(artistname);
		artist.setSonglist(new ArrayList<Song>());
		mdao.addArtist(artist);	
		
		return "admin-music-addartist";
	}
	
	@RequestMapping(value="/admin/music/delete.htm", method = RequestMethod.GET)
	public String deleteArtist(HttpServletRequest request){		
		int artistid = Integer.parseInt(request.getParameter("artistid"));
		MusicDAO mdao = factory.createMusicDAO();
		mdao.deleteArtistById(artistid);		
		return "admin-music-deleteartist";
	}
	
	@RequestMapping(value="/admin/music/song/add.htm", method = RequestMethod.GET)
	public String addSongForm(HttpServletRequest request){		
		int artistid = Integer.parseInt(request.getParameter("artistid"));
		HttpSession session = request.getSession();
		session.setAttribute("artistid", artistid);
		
		return "admin-music-addsong";
	}
	
	@RequestMapping(value="/admin/music/song/add.htm", method = RequestMethod.POST)
	public String handleSongForm(HttpServletRequest request){
		HttpSession session = request.getSession();
		int artistid = (Integer)session.getAttribute("artistid");
		
		String songname = request.getParameter("songname");
		String url = request.getParameter("url");
		
		MusicDAO mdao = factory.createMusicDAO();
		Artist artist = mdao.getArtistById(artistid);		
		
		Song song = new Song();
		song.setArtist(artist);
		song.setSongname(songname);
		song.setUrl(url);
		
		mdao.addSong(song);
		return "admin-music-addsong";
	}	
	
	@RequestMapping(value="/admin/music/song/delete.htm", method = RequestMethod.GET)
	public String deleteSong(HttpServletRequest request){		
		int songid = Integer.parseInt(request.getParameter("songid"));
		int artistid = Integer.parseInt(request.getParameter("artistiddelete"));
		 
		HttpSession session = request.getSession();
		session.setAttribute("artistiddelete", artistid);
		
		MusicDAO mdao = factory.createMusicDAO();
		mdao.deleteSongById(songid);		
		return "admin-music-deletesong";
	}
}