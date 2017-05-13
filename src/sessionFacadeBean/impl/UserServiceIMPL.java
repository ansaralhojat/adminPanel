package sessionFacadeBean.impl;

import model.User;
import sessionFacadeBean.UserService;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class UserServiceIMPL extends BaseServiceIMPL<User> implements UserService {
    public User getByUsernameAndPassword(String username, String password) {
        try {
            String queryString = "select u from User u where u.username = :username and u.password = :password";
            Query query = this.entityManager.createQuery(queryString);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }
}
