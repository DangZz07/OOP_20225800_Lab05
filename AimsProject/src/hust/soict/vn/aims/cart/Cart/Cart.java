package hust.soict.vn.aims.cart.Cart;

import hust.soict.vn.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public Cart() {
        this.itemsOrdered = new ArrayList<>();
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.printf("%d. %s\n", i + 1, media.toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more.");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        }
    }

    public void addMedia(Media media1, Media media2) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more. ");
        } else {
            addMedia(media1);
            System.out.println(media1.getTitle() + " has been added to the cart.");
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            	System.out.println("The cart is full. Cannot add more.");
            } else {
            	addMedia(media2);
            }
        }
    }

    public void removeMedia(String title) {
        if (itemsOrdered.contains(title)) {
            itemsOrdered.remove(title);
            System.out.println("the disc has been removed from the cart.");
        } else {
            System.out.println(" the disc does not exist in the cart.");
        }
    }

    public void search(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public Media search(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
		return null;
    }
    public void listItem() {
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
    }
}
