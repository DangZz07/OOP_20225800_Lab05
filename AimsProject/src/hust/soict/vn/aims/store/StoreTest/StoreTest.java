package hust.soict.vn.aims.store.StoreTest;
import hust.soict.vn.aims.media.DigitalVideoDisc;
import hust.soict.vn.aims.store.Store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store StoreTest = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        StoreTest.addMedia(dvd1);
        StoreTest.addMedia(dvd2);
        StoreTest.addMedia(dvd3);
        StoreTest.removeMedia(dvd3);
        

	}

}
