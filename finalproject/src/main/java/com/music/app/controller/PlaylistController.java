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
import com.music.app.dao.PlaylistDAO;
import com.music.app.pojo.Artist;
import com.music.app.pojo.Playlist;
import com.music.app.pojo.Song;
import com.music.app.pojo.User;

@Controller
public class PlaylistController {
	
	@Autowired
	private DAOFactory factory;	
	
	public PlaylistController(){
		
	}
		
	@RequestMapping(value = "/user/playlist.htm", method = RequestMethod.GET)
	public String showAllPlaylist(HttpServletRequest request) {	
		HttpSession session = request.getSession(false); 	
		User u = (User) session.getAttribute("currentuser");
		List<Playlist> list = u.getPlaylistAdded(); 
		session.setAttribute("currentlist", list);
		return "user-playlist";
	}
	
	@RequestMapping(value = "/user/playlist/add.htm", method = RequestMethod.GET)
	public String addPlaylistForm(HttpServletRequest request) {		
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		HttpSession session = request.getSession(false); 		
		User u = factory.createUserDAO().getUserById(userid);
		session.setAttribute("currentuser", u);
		return "user-addplaylist";
	}
	
	@RequestMapping(value = "/user/playlist/add.htm", method = RequestMethod.POST)
	public String handlePlaylistForm(HttpServletRequest request) {
		PlaylistDAO pdao = factory.createPlaylistDAO();
		HttpSession session = request.getSession(false); 
		
		String name = request.getParameter("playlistname");
		User u = (User)session.getAttribute("currentuser");
		
		Playlist playlist = new Playlist();
		playlist.setPlaylistname(name);
		playlist.setSonginlist(new ArrayList<Song>());
		playlist.setUser(u);
		
		pdao.addPlaylist(playlist);
		//u.getPlaylistAdded().add(playlist);
		
		
		return "user-addplaylist";
	}
	
	@RequestMapping(value = "/user/playlist/view.htm", method = RequestMethod.GET)
	public String viewPlaylist(HttpServletRequest request) {		
		
		int playlistid = Integer.parseInt(request.getParameter("playlistid"));
		Playlist playlist = factory.createPlaylistDAO().getPlaylistById(playlistid);		
		List<Song> songlist = playlist.getSonginlist();
		
		HttpSession session = request.getSession(false); 		
		session.setAttribute("playlist", playlist);		
		session.setAttribute("songlist",songlist);
		
		return "user-viewplaylist";
	}	

	@RequestMapping(value = "/user/playlist/delete.htm", method = RequestMethod.GET)
	public String deletePlaylist(HttpServletRequest request) {		
		PlaylistDAO pdao = factory.createPlaylistDAO();
		int playlistid = Integer.parseInt(request.getParameter("playlistiddelete"));
		
		pdao.deletePlaylistById(playlistid);
				
		HttpSession session = request.getSession(false); 	
		
		User u = (User) session.getAttribute("currentuser");
		session.removeAttribute("currentlist");
		session.setAttribute("currentlist", u.getPlaylistAdded());		
		
		return "user-playlist";
	}
	
	@RequestMapping(value = "/user/search.htm", method = RequestMethod.POST)
	public String searchDatabase(HttpServletRequest request) {	
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession(false);		
		PlaylistDAO pdao = factory.createPlaylistDAO();
		
		List<Song> list = pdao.searchSongbyString(keyword);
		session.setAttribute("result",list);
		return "user-searchresult";	
	}
	
	
	@RequestMapping(value = "/user/playlist/addsong.htm", method = RequestMethod.GET)
	public String addSongToPlaylistForm(HttpServletRequest request) {	
		int songid = Integer.parseInt(request.getParameter("songid"));	
		
		HttpSession session = request.getSession(false);
		session.setAttribute("addnewsongid", songid);
		
		List<Playlist> currplaylists = factory.createPlaylistDAO().displayPlaylists();
		session.setAttribute("currplaylists", currplaylists);
		
		return "user-addsongtoplaylist";
	}	
	
	@RequestMapping(value = "/user/playlist/addsong.htm", method = RequestMethod.POST)
	public String handleAddSongToPlaylist(HttpServletRequest request) {	
		HttpSession session = request.getSession(false);
		int addsongid = (Integer)session.getAttribute("addnewsongid");
		System.out.println("song id: " + addsongid);		
		Song song = factory.createMusicDAO().getSongById(addsongid);		
		int playlistid = Integer.parseInt(request.getParameter("hiddenid"));
		System.out.println("pl id: " + playlistid);
		
		PlaylistDAO pdao = factory.createPlaylistDAO();		
		Playlist playlist = pdao.getPlaylistById(playlistid);		
		playlist.getSonginlist().add(song);
		pdao.updatePlaylist(playlist);		
		return "user-addsongsuccessful";
	}
	
	
	@RequestMapping(value = "/user/playlist/deletesong.htm", method = RequestMethod.GET)
	public String deleteSongFromPlaylist(HttpServletRequest request) {	
		int playlistid = Integer.parseInt(request.getParameter("playlistdelete"));
		int songid = Integer.parseInt(request.getParameter("songiddelete"));
		
		PlaylistDAO pdao = factory.createPlaylistDAO();
		Playlist playlist = pdao.getPlaylistById(playlistid);
		
		MusicDAO mdao = factory.createMusicDAO();
		Song song = mdao.getSongById(songid);
		
		pdao.deleteSongFromPlaylist(playlist, song);		
		return "user-viewplaylist";
	}
	
	@RequestMapping(value = "/user/back.htm")
	public String goBack(HttpServletRequest request){
		return "user-dashboard";
	}
}