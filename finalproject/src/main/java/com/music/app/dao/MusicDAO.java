package com.music.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.music.app.pojo.Artist;
import com.music.app.pojo.Song;


public class MusicDAO extends DAO{
	public List<Artist> displayArtists(){
		try {
			begin();
			Query q = getSession().createQuery("from Artist");
			List<Artist> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get all artists" +  e.getMessage());
			return null;
		}
	}
	
	public Artist getArtistById(int id){
		try{
			begin();
			Query q = getSession().createQuery("from Artist where artistid = " + id);
			Artist artist = (Artist) q.uniqueResult();
			commit();
			return artist;
		}
		catch(HibernateException e){
			rollback();
			System.out.println("Could not get artist by id: " + id + e.getMessage());
			return null;
		}
	}
	
	public void deleteArtistById(int id){
		try {
			begin();
			Query q = getSession().createQuery("from Artist where artistid = " + id);
			Artist artist = (Artist) q.uniqueResult();
			getSession().delete(artist);
			commit();
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not delete artist: " + id +  e.getMessage());
		}		
	}
	
	public Artist addArtist(Artist artist){
		try {
			begin();
			getSession().save(artist);
			commit();
			return artist;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not add artist: " +  e.getMessage());
			return null;
		}
	}
	
	public Song addSong(Song song){
		try {
			begin();
			getSession().save(song);
			commit();
			return song;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not add song: " +  e.getMessage());
			return null;
		}
	}
	
	public Song getSongById(int id){
		try{
			begin();
			Query q = getSession().createQuery("from Song where songid = " + id);
			Song song = (Song) q.uniqueResult();
			commit();
			return song;
		}
		catch(HibernateException e){
			rollback();
			System.out.println("Could not get song by id: " + id + e.getMessage());
			return null;
		}
	}
	
	public void deleteSongById(int id){
		try {
			begin();
			Query q = getSession().createQuery("from Song where songid = " + id);
			Song song = (Song) q.uniqueResult();
			getSession().delete(song);
			commit();
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not delete song: " + id +  e.getMessage());
		}		
	}
}