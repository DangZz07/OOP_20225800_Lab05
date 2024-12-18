package hust.soict.vn.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	public String toString() {
		return String.format("DVD - [%s] - [%s] - [%s] - [%d]: [%.2f]$", getTitle(), getCategory(), director, length, getCost());
	}
	public int getLength() {
		return length;
	}
	
	public DigitalVideoDisc (String title){
		super(title);
    }
	
    public DigitalVideoDisc (String title, String category, float cost){
       	super(0, title,category,cost, category);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }
    
    public DigitalVideoDisc (String director, String category, String title, float cost){
        super(0, title,category,cost, title);
    	this.director = director;
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);

    }   

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(0, category,title,cost, director);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }
	public void play() {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
	}   

}
