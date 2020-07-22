package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }
    public boolean newSong(String songName, double songDuration){
        return  this.songs.add(new Song(songName, songDuration));
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist (String title, LinkedList<Song> playlist){
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String songName) {
            for (int i = 0; i < this.songs.size(); i++) {
                Song checkedSong = this.songs.get(i);
                if (checkedSong.getTitle().equals(songName)) {
                    return checkedSong;
                }
            }
            return null;
        }
        private Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if((index >=0) && (index<songs.size())){
                return songs.get(index);
            }
            return null;
        }
    }



}
