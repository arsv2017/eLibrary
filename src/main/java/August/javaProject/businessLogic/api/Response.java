package August.javaProject.businessLogic.api;

import java.util.List;

/**
 * Created by SynMobUsr on 8/5/2017.
 */
public class Response {

    boolean success;
    List<Error> errorList;


    public Response(boolean success, List<Error> errorList) {
        this.success = success;
        this.errorList = errorList;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }
}
