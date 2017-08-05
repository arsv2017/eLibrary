package August.javaProject.domain;

/**
 * Created by SynMobUsr on 7/24/2017.
 */
public class Book {


    private String title;
    private String author;
    private int pubYear;
    private long id;


    public Book(String title, String author, int pubYear) {

        this.title = title;
        this.author = author;
        this.pubYear = pubYear;

        id = title.hashCode();
        id = 31 * id + author.hashCode();
        id = 31 * id + pubYear;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pubYear != book.pubYear) return false;
        if (id != book.id) return false;
        if (!title.equals(book.title)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + pubYear;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubYear=" + pubYear +
                ", id=" + id +
                '}';
    }
}
