package fawrytask;
import java.util.* ;

public class BookStore {
    
    private Map <String , Book> Inventory  = new HashMap<> () ;
    
    
     public void addBook(Book book) {
        Inventory.put(book.getIsbn(), book);
    }

    public void removeOutdatedBooks(int currentYear, int maxYears) {
        Inventory.values().removeIf(book -> book.isOutdated(currentYear, maxYears));
    }

    public void buyBook(String isbn, int quantity, String email, String address) {
        Book book = Inventory.get(isbn);
        if (book == null || !book.isForSale()) {
            throw new IllegalArgumentException("Book not available for sale");
        }

        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            if (!pb.reduceStock(quantity)) {
                throw new IllegalArgumentException("Out of stock");
            }
        }

        System.out.println("Returning paid amount: $" + (book.Price * quantity));
        book.deliver(email, address, quantity);
    }

    public void printInventory() {
        for (Book book : Inventory.values()) {
            System.out.println(book.getIsbn() + " - " + book.Title);
        }
    }
}
