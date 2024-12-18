package hust.soict.vn.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	

	public String getTitle() {
		return title;
	}


	public int getLength() {
		return length;
	}


	public Track() {
		// TODO Auto-generated constructor stub
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
		
	}
	public Track(String title) {
		this.title = title;
	}


	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		
	}
	public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Track track = (Track) obj;
        return length == track.length && title != null && title.equals(track.title); 
    }

}
