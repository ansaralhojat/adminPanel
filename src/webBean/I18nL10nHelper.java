package webBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class I18nL10nHelper implements Serializable {
    private Locale locale = null;

    public Locale getLocale() {
        if (this.locale == null) {
            this.locale = new Locale("fa");
        }
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
