package hust.soict.vn.aims.cart.CartTest;
import hust.soict.vn.aims.cart.Cart.Cart;
import hust.soict.vn.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1); 


        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);
        
        cart.printCart();
        cart.search(1);
        cart.search(5);
        cart.search("Dangdz");
        cart.search("Aladdin");

	}

}