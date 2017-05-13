package sessionFacadeBean;

import model.User;

public interface UserService extends BaseService<User> {
    User getByUsernameAndPassword(String paramString1, String paramString2);
}
