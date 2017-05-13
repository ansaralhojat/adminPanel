package listener;

import webBean.UserHolder;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ForceLoginPhaseListener implements PhaseListener {
    public void afterPhase(PhaseEvent phaseEvent) {
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        UserHolder userHolder = (UserHolder) application.evaluateExpressionGet(context, "#{userHolder}", UserHolder.class);
        if (userHolder.getCurrentUser() == null) {
            ViewHandler viewHandler = application.getViewHandler();
            UIViewRoot viewRoot = viewHandler.createView(context, "/login.xhtml");
            context.setViewRoot(viewRoot);
        }
    }

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
