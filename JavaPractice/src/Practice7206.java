import java.util.HashSet;
import java.util.Set;

class Book {

    private int isbn;
    private String title;

    Book(int isbn, String title) {
        this.isbn = isbn;
        setTitle(title);
    }

    void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return isbn == ((Book) obj).isbn;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + "(ISBN: " + isbn + ")";
    }
}

public class Practice7206 {
    public static void main(String[] args) {

        Set<Book> set = new HashSet<Book>();
    
        Book book = new Book(1, "C++");
    
        set.add(book);
    
        set.add(new Book(2, "Haskell"));
        set.add(new Book(1, "Java"));
        book.setTitle("New C++ book");
    
        for (Book b : set) {
          System.out.println(b);
        }
    
      }
}