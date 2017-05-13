package webBean;

import model.User;
import sessionFacadeBean.UserService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class LoginWebBean implements Serializable {
    @Inject
    private UserHolder userHolder;
    @EJB
    private UserService userService;
    private String username;
    private String password;

    public UserHolder getUserHolder() {
        return this.userHolder;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        User currentUser = this.userService.getByUsernameAndPassword(this.username, this.password);
        this.userHolder.setCurrentUser(currentUser);
        if (currentUser == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "�������������� �������� ������ �������� ������ ��������", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        return "index";
    }

    public String logout() {
        this.userHolder.setCurrentUser(null);
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "login";
    }
}
