package August.javaProject.dataBase;

import August.javaProject.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SynMobUsr on 7/25/2017.
 */
public class DataBaseImpl implements DataBase {

    List<Book> bookList = new ArrayList<Book>();




    public void saveNewBookInLibrary(Book book) {

        bookList.add(book);
    }







/*   @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> searchResults = new ArrayList<Book>();


        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : bookList) {

            if (book.getAuthor().equals(author)) {
                searchResults.add(book);

            }
        }
        return searchResults;
    }


    @Override
    public List<Book> getBookByTitleAndAuthor(String title, String author) {

        List<Book> searchResults = new ArrayList<>();

        for (Book book : bookList) {

            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                searchResults.add(book);

            }
        }
        return searchResults;
    }
*/
}

