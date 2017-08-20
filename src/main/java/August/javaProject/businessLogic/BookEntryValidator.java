package August.javaProject.businessLogic;

import August.javaProject.businessLogic.api.Error;

import java.util.List;

/**
 * Created by SynMobUsr on 8/9/2017.
 */
public interface BookEntryValidator {


    List<Error> validate (String title, String author, int pubYear);
}
