package com.music.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.music.app.pojo.Artist;
import com.music.app.pojo.Playlist;
import com.music.app.pojo.Song;

public class PlaylistDAO extends DAO {
	
	public List<Playlist> displayPlaylists(){
		try {
			begin();
			Query q = getSession().createQuery("from Playlist");
			List<Playlist> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get all playlists" +  e.getMessage());
			return null;
		}
	}
	
	public Playlist getPlaylistById(int id){
		try{
			begin();
			Query q = getSession().createQuery("from Playlist where playlistid = " + id);
			Playlist playlist = (Playlist) q.uniqueResult();
			commit();
			return playlist;
		}
		catch(HibernateException e){
			rollback();
			System.out.println("Could not get playlist by id: " + id + e.getMessage());
			return null;
		}
	}
	
	public void deletePlaylistById(int id){
		try {
			begin();
			Query q = getSession().createQuery("from Playlist where playlistid = " + id);
			Playlist playlist = (Playlist) q.uniqueResult();
			getSession().delete(playlist);
			commit();
		} 
		catch (HibernateException e) {
			rollback();
			System.out.println("Could not delete playlist: " + id +  e.getMessage());
		}		
	}
	
	public Playlist addPlaylist(Playlist playlist){
		try {
			begin();
			getSession().save(playlist);
			commit();
			return playlist;
		} 
		catch (HibernateException e) {
			rollback();
			System.out.println("Could not add playlist: " +  e.getMessage());
			return null;
		}
	}
	
	public Playlist updatePlaylist(Playlist playlist){
		try {
			begin();
			getSession().update(playlist);
			commit();
			return playlist;
		} 
		catch (HibernateException e) {
			rollback();
			System.out.println("Could not update playlist: " +  e.getMessage());
			return null;
		}
	}
	
	
	public List<Song> searchSongbyString(String s){
		try {
			begin();
			Criteria crit = getSession().createCriteria(Song.class);
			crit.add(Restrictions.like("songname", s, MatchMode.ANYWHERE));
			List<Song> list = crit.list();		
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not search song: " + s + " " +  e.getMessage());
			return null;
		}				
	}
	
	
	public void addSongToPlaylist(Playlist playlist, Song song){
		List<Song> list = playlist.getSonginlist();
		list.add(song);		
	}
	
	public void deleteSongFromPlaylist(Playlist playlist, Song song){
		List<Song> list = playlist.getSonginlist();
		list.remove(song);
	}
}