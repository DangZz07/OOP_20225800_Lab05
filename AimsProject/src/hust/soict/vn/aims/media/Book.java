package hust.soict.vn.aims.media;
import java.util.List;
import java.util.ArrayList;
public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, float cost, List<String> authors) {
    	super(id, title, null, cost);
        this.authors = authors;
    }

	public Book() {
		
	}
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	private boolean AuthorExist(String author) {
		return authors.contains(author);
	}
	public void addAuthor(String authorName) {
		if(AuthorExist(authorName)) {
			System.out.println("Author " + authorName + " is already in the list.");
		}
		else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " has been added to the list.");
		}
	}
	public void removeAuthor(String authorName) {
		if(AuthorExist(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName + " has been removed to the list.");
		}
		else {
			System.out.println("Author " + authorName + " does not ex in the list.");
		}
	}
    public String toString() {
        StringBuilder authorList = new StringBuilder();
        for (String author : authors) {
            authorList.append(author).append(", ");
        }
        if (authorList.length() > 0) {
            authorList.setLength(authorList.length() - 2);
        }
        
        return String.format("Book - [%s] - [%s] - [%s] - [%.2f]$", getTitle(), getCategory(), authorList.toString(), getCost());
    }
	

}
