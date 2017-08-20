package August.javaProject.dataBase.jdbc;


import August.javaProject.dataBase.BookDao;
import August.javaProject.dataBase.DBException;
import August.javaProject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDAOImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static RowMapper<Book> rowMapper() {
        return (rs, rowNum) -> {
            Book book = new Book(null, null, 0);

            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPubYear(rs.getInt("id"));

            return book;
        };
    }


    @Override
    public void save(Book book) throws DBException {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("books")
                .usingColumns("title", "author", "pubYear")
                .usingGeneratedKeyColumns("id");

        Map parameters = new HashMap();
        parameters.put("title", book.getTitle());
        parameters.put("author", book.getAuthor());
        parameters.put("pubYear", book.getPubYear());


        Long id = insert.executeAndReturnKey(parameters).longValue();
        book.setId(id);

        return;
    }


    /*   @Override
       public Optional<Product> getById(Long id) throws DBException {
           List<Product> products = this.jdbcTemplate.query(
                   "select * from PRODUCTS where id = ?",
                   new Object[]{id},
                   rowMapper());
           if (products.isEmpty()) {
               return Optional.empty();
           } else {
               if (products.size() == 1) {
                   return Optional.ofNullable(products.get(0));
               } else {
                   throw new IllegalStateException("More then one row returned!");
               }
           }
       }
*/
    @Override
    public List<Book> getBookByTitle(String title) throws DBException {
        List<Book> bookList = this.jdbcTemplate.query(
                "select * from PRODUCTS where title = ?",
                new Object[]{title},
                rowMapper());
        return bookList;
    }






/*

        @Override
        public List<Product> getAll() throws DBException {
            List<Product> products = this.jdbcTemplate.query(
                    "select * from PRODUCTS",
                    rowMapper());
            return products;
        }

        @Override
        public void delete(Product product) throws DBException {
            this.jdbcTemplate.update(
                    "delete from products where id = ?",
                    product.getId());
        }

    }
*/


}
