import java.util.ArrayList;
import java.util.List;

enum Genre {
    ROCK, POP, JAZZ
}

class Artist {
    String name;
    List<Record> catalogue;
    Genre mainGenre;

    public Artist(String name, Genre mainGenre) {
        this.name = name;
        this.mainGenre = mainGenre;
        this.catalogue = new ArrayList<>();
    }

    // Add a record of the given name to the artist's catalogue
    // Use the artist's main genre as the record's genre
    public void addRecord(String name) {
        catalogue.add(new Record(name, mainGenre));
    }

    // Add a record of the given name and genre to the artist's
    // catalogue
    public void addRecord(String name, Genre genre) {
        catalogue.add(new Record(name, genre));
    }

    // Display the artist's catalogue
    public void showCatalogue() {
        for (Record record : catalogue) {
            System.out.println(record);
        }
    }

    // Display the subset of artist's catalogue that falls into
    // the given genre
    public void showGenre(Genre genre) {
        for (Record record : catalogue) {
            if (record.genre == genre) {
                System.out.println(record);
            }
        }
    }
}

class Record {
    String title;
    Genre genre;

    public Record(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public String toString() {
        return "name: " + this.title + ", genre: " + this.genre;
    }
}

public class Practicebec2 {
    public static void main(String[] args) {
        Artist artist = new Artist("Justin", Genre.POP);
        artist.addRecord("Fuzzy", Genre.POP);
        artist.addRecord("Good time", Genre.JAZZ);
        artist.addRecord("Bad Apple", Genre.POP);
        artist.showCatalogue();
    }
}