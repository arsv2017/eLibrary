package August.javaProject.businessLogic;

import August.javaProject.businessLogic.api.Response;

/**
 * Created by SynMobUsr on 8/21/2017.
 */
public interface FindBookByTitleService {

    Response findBookByTitle(String title);
}
