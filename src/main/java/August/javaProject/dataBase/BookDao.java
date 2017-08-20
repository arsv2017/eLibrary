package August.javaProject.dataBase;

import August.javaProject.domain.Book;

import java.util.List;
import java.util.Optional;


public interface BookDao{

 void save(Book book) throws DBException;

  List <Book> getBookByTitle(String title);
// List<Book> findBook (long id);


}
