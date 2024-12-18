package hust.soict.vn.aims.media;

public class Disc extends Media {
	private String director;
	private int length;

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id,title,category,cost); 
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, int length, String director) {
        super(id,title, null, 0);
        this.length = length;
        this.director = director;
    }
	public Disc(String title) {
        super(); 
        setTitle(title);
    }
	public Disc(int id, String title, String category, float cost,String director) {
        super(); 
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.director = director;
    }
	public String toString() {
        return "Disc [ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Director: " + director + ", Length: " + length + "]";
    }
	

}
