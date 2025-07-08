
package fawrytask;

public class FawryTask {

   
    public static void main(String[] args) {
        
        BookStore store = new BookStore();
        
        Book book = new PaperBook("3105" , "Flutter Basics",2017,970.50,50,true);
        Book e_book = new EBook("3106","Java Programming Language",2023,800,"",false);
        Book demo = new DemoBook("3200","C++ Deno Book",2025,0);
        store.addBook(book);
        store.addBook(e_book);
        store.addBook(demo);
        
        store.buyBook("3105", 1, "omaratallah077@gmail.com", "Cairo, Egypt");
        
        store.removeOutdatedBooks(2025, 5);

        store.printInventory();
    }
    
}

