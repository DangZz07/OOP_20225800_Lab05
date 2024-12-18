package hust.soict.vn.aims.Aims;

import java.util.Arrays;
import java.util.Scanner;

import hust.soict.vn.aims.cart.Cart.Cart;
import hust.soict.vn.aims.media.CompactDisc;
import hust.soict.vn.aims.media.DigitalVideoDisc;
import hust.soict.vn.aims.media.Book;
import hust.soict.vn.aims.media.Media;
import hust.soict.vn.aims.media.Playable;
import hust.soict.vn.aims.store.Store.Store;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f));
        store.addMedia(new Book(1, "Java Programming", 500.00f, Arrays.asList("Herbert Schildt")));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 14.99f));
        store.addMedia(new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 20.99f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f));
        store.addMedia(new CompactDisc("Greatest Hits"));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 14.99f));
        store.addMedia(new CompactDisc("Thriller"));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Adventure", "Christopher Nolan", 18.50f));
        store.addMedia(new CompactDisc("Back in Black"));
        store.addMedia(new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 20.99f));

        cart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f));
        cart.addMedia(new Book(1, "Java Programming", 500.00f, Arrays.asList("Herbert Schildt")));
        cart.addMedia(new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 20.99f));
        cart.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 19.99f));
        cart.addMedia(new Book(2, "Clean Code", 45.00f, Arrays.asList("Robert C. Martin")));
        cart.addMedia(new CompactDisc("Back in Black"));

        showMenu();
    }

    public static void showMenu() {
        char choice;
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        choice = sc.next().charAt(0);
        sc.nextLine();
        switch(choice){
            case '1': {store.listItem();storeMenu();break;}  
            case '2': {
                System.out.println("Which option you want to update (add or remove): ");
                String Option = sc.nextLine();
                switch(Option){
                    case "add": {
                        System.out.println("Which type of item you want to add (DVD/CD/Book): ");
                        String type = sc.nextLine();
                        if(type.equals("DVD") || type.equals("CD") || type.equals("Book")){
                            EnterItemInformation(type);
                        } else {
                            System.out.println("Invalid type of item");
                        }
                        break;
                    }
                    case "remove": {
                        System.out.println("Enter the title of the item you want to remove: ");
                        String title = sc.nextLine();
                        store.removeMedia(store.search(title));
                        break;    
                    }
                }
                showMenu(); 
                break;      
            }
            case '3': {cart.listItem();cartMenu();break;}
            case '0': return;
        }
        System.out.println("--------------------------------");
    }

    private static void EnterItemInformation(String type) {
    }

    public static void storeMenu() {
        char choice;
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        choice = sc.next().charAt(0);
        sc.nextLine(); 
        switch(choice){
            case '1': {
                System.out.println("Enter the title you want to search: ");
                String title = sc.nextLine();
                Media item = store.search(title);
                if(item != null){
                    mediaDetailsMenu(item);
                }
                break;
            }  
            case '2': {
                System.out.println("Enter the title of the item you want to add: ");
                String title = sc.nextLine();
                Media item = store.search(title);
                cart.addMedia(item);
                System.out.println("Item added to cart");
                System.out.println(cart.MAX_NUMBERS_ORDERED);
                storeMenu();
                break;}
            case '3': {
                System.out.println("Enter the DVD/CD you want to play: ");
                String title = sc.nextLine();
                Media item = store.search(title);
                if( item instanceof DigitalVideoDisc || item instanceof CompactDisc){
                    if (item instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) item).play();
                    } else if (item instanceof CompactDisc) {
                        ((CompactDisc) item).play();
                    }
                }
                else{
                    System.out.println("This item is not playable");
                }
                storeMenu();
                break;
            }
            case '4': {cart.listItem();storeMenu();break;}
            case '0': {showMenu(); break;}
        }
        System.out.println("--------------------------------");
    }

    public static void mediaDetailsMenu(Media item) {
        char choice;
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        choice = sc.next().charAt(0);
        sc.nextLine(); 
        switch(choice){
            case '1': {
                cart.addMedia(item);
                mediaDetailsMenu(item);
                break;
            }  
            case '2': {
                if (item instanceof DigitalVideoDisc) {
                    ((DigitalVideoDisc) item).play();
                } else if (item instanceof CompactDisc) {
                    ((CompactDisc) item).play();
                } else {
                    System.out.println("This item is not playable");
                }
                mediaDetailsMenu(item);
                break;
            }
            case '0': {storeMenu();break;}
        }
        System.out.println("--------------------------------");
    }

    public static void cartMenu() {
        char choice;
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        choice = sc.next().charAt(0);
        sc.nextLine(); 
        switch(choice){
            case '1': {
                System.out.println("Enter the filter Option (title/id): ");
                String filterOption = sc.nextLine();
                if(filterOption.equals("title")){
                    System.out.println("Enter the title you want to filter: ");
                    String title = sc.nextLine();
                    cart.search(title);
                } else if(filterOption.equals("id")){
                    System.out.println("Enter the id you want to filter: ");
                    int id = sc.nextInt();
                    cart.search(id);
                } else {
                    System.out.println("Invalid filter option.");
                }
                cartMenu();
                break;
            }
            case '2': {
                System.out.println("Sorting medias in cart...");
                cartMenu();
                break;
            }
            case '3': {
                System.out.println("Enter the title of the media you want to remove: ");
                String title = sc.nextLine();
                cart.removeMedia(title);
                cartMenu();
                break;
            }
            case '4': {
                System.out.println("Enter the media title you want to play: ");
                String title = sc.nextLine();
                Media media = cart.search(title);
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media is not playable.");
                }
                cartMenu();
                break;
            }
            case '5': {
                System.out.println("Placing order...");
                cartMenu();
                break;
            }
            case '0': {
                showMenu();
                break;
            }
        }
    }
}
