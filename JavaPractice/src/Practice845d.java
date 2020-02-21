import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Book {

    private String isbn;
    private String title = "";
    private int pages = 0;

    public Book(String isbn, String title, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return title + ", ISBN: " + isbn + ", pages: " + pages;
    }
}

class Dictionary extends Book {

    private String sourceLanguage;
    private String targetLanguage;
    private int numDefinitions;

    public Dictionary(String isbn, String title, int pages, String sourceLanguage, String targetLanguage,
            int numDefinitions) {
        super(isbn, title, pages);
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.numDefinitions = numDefinitions;
    }

    @Override
    public String toString() {
        return super.toString() + "Dictionary [numDefinitions=" + numDefinitions + ", sourceLanguage=" + sourceLanguage
                + ", targetLanguage=" + targetLanguage + "]";
    }
}

class Bookshelf {
    List<Book> booklist;

    public Bookshelf() {
        this.booklist = new LinkedList<>();
	}

    public Bookshelf(List<Book> booklist) {
        this.booklist = booklist;
    }

    // Returns the number of books on the bookshelf
    public int size() {
        return booklist.size();
    }

    // Adds a book on the left side of the shelf.
    // Shifts all other books one position to the right
    public void addBookOnLeftSide(Book b) {
        booklist.add(0, b);
    }

    // Adds a book on the right side of the shelf.
    public void addBookOnRightSide(Book b) {
        booklist.add(b);
    }

    // Adds book in position i counting from the left, starting
    // from zero, and shifts all other books one position to the right.
    // Hence addBook(0, b) is equivalent to addBookOnLeftSide(b), and
    // addBook(size(), b) is equivalent to addBookOnRightSide(b)
    public void addBook(int i, Book b) {
        booklist.add(i, b);
    }

    // Removes book from position i, shifting all books with position
    // greater than i to the left
    public Book remove(int i) {
        return booklist.remove(i);
    }

    // Prints all details of books from left to right
    public void printLeftToRight() {
        for (Book book : booklist) {
            System.out.println(book);
        }
    }

    // Prints all details of books from right to left
    public void printRightToLeft() {
        Iterator<Book> it = ((LinkedList<Book>) booklist).descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

public class Practice845d {
    public static void main(String[] args) {
        Book book1 = new Book("12093811", "Book1", 243);
        Book book2 = new Book("12093811", "Book2", 243);
        Book book3 = new Book("12093811", "Book3", 243);
        Book book4 = new Book("12093811", "Book4", 243);
        Dictionary dic1 = new Dictionary("12312312", "Dictionary1", 1000, "Spanish", "Mandarin", 666);
        Dictionary dic2 = new Dictionary("12312312", "Dictionary2", 1000, "Spanish", "Mandarin", 666);
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBookOnLeftSide(book1);
        bookshelf.addBookOnLeftSide(book2);
        bookshelf.addBookOnLeftSide(book3);
        bookshelf.addBookOnLeftSide(book4);
        bookshelf.addBookOnLeftSide(dic1);
        bookshelf.addBookOnLeftSide(dic2);
        bookshelf.printRightToLeft();
    }
}