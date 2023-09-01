package com.jbk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums=new ArrayList<>();
	public static void main(String[] args) {

	Album album=new Album("Album1","AC/DC");
	
	album.addSong("TNT", 4.5);
	album.addSong("Highway to hell", 3.5);
	album.addSong("ThundersStruck", 5.0);
    albums.add(album);
    
	
	 album=new Album("Album2"," Eminem");
	 
	album.addSong("Rap god", 4.5);
	album.addSong("Not Affraid ", 3.5);
	album.addSong("Lose Youeself", 4.5);
	albums.add(album);


	
	LinkedList <Song>  PlayList_1 = new LinkedList<>();
	
	albums.get(0).addToPlayList("TNT", PlayList_1);
	albums.get(0).addToPlayList("Highway to hell", PlayList_1);
	albums.get(1).addToPlayList("Rap God", PlayList_1);
	albums.get(1).addToPlayList("Lose Youeself", PlayList_1);

	play(PlayList_1);
	
	
	}

	


private static void play(LinkedList<Song> playList) {
	Scanner sc=new Scanner(System.in);
	boolean quit=false;
	boolean forward=true;
	ListIterator<Song> ListIterator=playList.listIterator();

	if(playList.size()==0) {
		System.out.println("this playList have no song");
	}else {
System.out.println(" Now Playing" + ListIterator.next().toString());
printMenu();

	}
	while(!quit) {
		int action=sc.nextInt();
		sc.nextLine();
		
		switch(action) {
		case 0:
			System.out.println("PlayList Complete");
			quit=true;
			break;
			
			
		case 1:
	if(!forward) {
	if(ListIterator.hasNext()){
	ListIterator.next();
	}
	forward=true;
	}
	if(ListIterator.hasNext()){
	System.out.println(" Now Playing" + ListIterator.next().toString());

	}else {
	System.out.println(" no songs available, reached to the end of the List");
	forward=false;
	}
	

			break;
			
			
		case 2:
			if(forward) {
				if(ListIterator.hasPrevious()){
					ListIterator.previous();
				}
				forward=false;
					}
				if(ListIterator.hasPrevious()){
					System.out.println(" Now Playing" + ListIterator.previous().toString());

				}else {
					System.out.println("  we are the first song ");
					forward=false;
				}

							break;

			
		case 3:
			if(forward) {
				if(ListIterator.hasPrevious()){
					System.out.println(" Now Playing" + ListIterator.previous().toString());
				forward=false;
				}else {
					System.out.println(" we are at the start of the List");
				}
		
				}else {
					if(ListIterator.hasNext()){
						System.out.println(" Now Playing" + ListIterator.next().toString());
	                    forward=true;
				}else {
					System.out.println(" We have reached to the end of the List");
				}
				}
							break;


			
			
		case 4:
			printList(playList);
			break;

			
			
		case 5:
			printMenu();
			break;

			
			
		case 6 :
			 if(playList.size()> 0) {
				 ListIterator.remove();
				 if(ListIterator.hasNext()) {
						System.out.println(" Now Playing" + ListIterator.next().toString());
				
				 } else {
						if(ListIterator.hasPrevious()){
							System.out.println(" Now Playing" + ListIterator.previous().toString());

					 
				 }
			 }

			 }
		}
	}
	
	
}



private static void printMenu() {
	  System.out.println("Available option\n press");
	  System.out.println(" 0 - to quit\n"+
			  "1 - to play next song\n"+ 
			  "2 - to play previous song\n" +
			  "3 - to replay the current  song\n"+
			  "4 - list of all songs\n"+
			  "5 - print all available options \n"+
			  "6 - delete current songs\n");
}

private static void printList (LinkedList<Song>playList){
	Iterator<Song>iterator= playList.iterator();
	System.out.println("======================");
	
	
	
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	
	System.out.println("====================");


	 
}
}
