package hust.soict.vn.aims.store.Store;

import hust.soict.vn.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS) {
            itemsInStore.add(media);
            System.out.println("Added " + media.getTitle() + " to the store.");
        } else {
            System.out.println("The store is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed " + media.getTitle() + " from the store.");
        } else {
            System.out.println("Media does not exist in the store.");
        }
    }

    public void listItem() {
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
    }
    public Media search(String title){
        
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                System.out.println(item.toString());
                return item;
            }
        }
        System.out.println("The item is not in the store");
        return null;

}
}
