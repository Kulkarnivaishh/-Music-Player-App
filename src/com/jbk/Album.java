package com.jbk;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private  String name;
	private String artist;
	private ArrayList<Song> songs;
	
	
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
		public Album() {
			
		}
		
		
		public Song findSong(String title) {
			
			for(Song  checkedsong : songs) {
				if(checkedsong.getTitle().equals(title)) ;
				return checkedsong;
			}
				return null;
				

		}
	public 	boolean  addSong (String title ,double duration) {
			if(findSong(title) == null) {
				songs.add(new Song (title,duration));
//			System.out.println(title+"Successfully added to the List");
			return true;
			
		
		}else {
//			System.out.println("Song with name "+title+ " already exist in the list");
			return false;
		}
	}
	public 	boolean  addToPlayList (int tracknumber ,LinkedList<Song> playList) {
		int index=tracknumber-1;
		if(index > 0 && index <= this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
//	System.out.println("this album does not have song with tracknumber "+tracknumber);		
return false;
	}
	
	
	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		for(Song checkedsong:this.songs) {
			if(checkedsong.getTitle().equals(title))  {
			playList.add(checkedsong);
			return true;
		}
		}
	
	
//	System.out.println(title+"there is no such song in album");		
return false;
		
	}
//	public void add(Album album) {
//		
//	}
}


