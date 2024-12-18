package hust.soict.vn.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String artist) {
		this.tracks =  new ArrayList<>();
		this.artist = artist;
	}
	boolean isTrackexist (Track track) {
		return tracks.contains(track);
	}
	public void addTrack(Track track) {
		if(isTrackexist(track)){
			System.out.println("Track " + track.getTitle() + " is already in the CD.");
		}
		else {
			tracks.add(track);
			System.out.println("Track " + track.getTitle() + " has been added to the CD.");
		}
		
	}
	public void removeTrack(Track track) {
		if(isTrackexist(track)) {
			tracks.remove(track);
			System.out.println("Track " + track.getTitle() + " has been removed from the CD.");
		}
		else {
			System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
		}
	}
	public int getLength() {
		int sum = 0;
		for(Track index : tracks) {
			sum += index.getLength();
		}
		return sum;
	}

	public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
	public String toString() {
        String trackList = "";
        for (Track track : tracks) {
            trackList += track.getTitle() + ", ";
        }
        if (trackList.length() > 0) {
            trackList = trackList.substring(0, trackList.length() - 2);
        }
        return "CompactDisc [ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Director: " + getDirector() + ", Length: " + getLength() + ", Artist: " + artist + ", Tracks: " + trackList + "]";
    }

}
