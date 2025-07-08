package fawrytask;




public abstract class Book {

    protected String ISBN ;
    protected String Title ;
    protected int Year ;
    protected double Price ;
    
    Book(String isbn , String title , int year , double price ){
    
        this.ISBN = isbn ;
        this.Price = price ;
        this.Title=title ;
        this.Year = year ;
        
    }
    
        public String getIsbn() {
        return ISBN;
    }

    public int getYear() {
        return Year;
    }

    public abstract void deliver(String email, String address, int quantity);

    public abstract boolean isForSale();

    public abstract boolean isOutdated(int currentYear, int maxYears);
}


class PaperBook extends Book {

    int Stock ;
    boolean IsShipped ;
    
    PaperBook(String isbn , String title , int  year , double price , int stock,boolean isshipped)
    {
    super(isbn ,title,year,price);
    this.Stock = stock ;
    }

    @Override
    public void deliver(String email, String address, int quantity) {
          System.out.println("Sending paper book to: " + address);
    }

    @Override
    public boolean isForSale() {
        return true ;
       }

    @Override
    public boolean isOutdated(int currentYear, int maxYears) {
        return currentYear - Year > maxYears ;
     }
      public boolean reduceStock(int quantity) {
        if (Stock >= quantity) {
            Stock -= quantity;
            return true;
        }
        return false;
    }

    public int getStock() {
        return Stock;
    }
}
class EBook extends Book{
    
String FileType ;
boolean IsSentEmail ;

EBook(String isbn , String title , int year , double price , String filetype,boolean issentEamil)
    {
    super(isbn ,title,year,price);
    this.FileType = filetype ;
    this.IsSentEmail = issentEamil ;
    }

    @Override
    public void deliver(String email, String address, int quantity) {
        System.out.println("Sending ebook to: " + email);
    }

    @Override
    public boolean isForSale() {
        return true ;
    }

    @Override
    public boolean isOutdated(int currentYear, int maxYears) {
        return currentYear - Year > maxYears ;
     }
}
class DemoBook extends Book{
   

    DemoBook(String isbn , String title , int year , double price )
    {
    super(isbn ,title,year,price);
    
    }

    @Override
    public void deliver(String email, String address, int quantity) {
         System.out.println("Showcase books are not deliverable.");
     }

    @Override
    public boolean isForSale() {
        return false ;
    }

    @Override
    public boolean isOutdated(int currentYear, int maxYears) {
        return false ;
     }
}