package August.javaProject.businessLogic;

import August.javaProject.businessLogic.api.Response;
import August.javaProject.domain.Book;

import java.util.Optional;

/**
 * Created by SynMobUsr on 7/24/2017.
 */
public interface BusinessLogic {


 Response donateBook(String title, String author, int pubYear);


}
