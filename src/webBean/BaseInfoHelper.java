package webBean;

import baseInfo.Decorum;
import baseInfo.Lecturer;
import baseInfo.Roze;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
@ApplicationScoped
public class BaseInfoHelper {
    public SelectItem[] getDecorumSelectItemValues() {
        return Decorum.getSelectItemValues();
    }

    public SelectItem[] getLecturerSelectItemValues() {
        return Lecturer.getSelectItemValues();
    }

    public SelectItem[] getRozeSelectItemValues() {
        return Roze.getSelectItemValues();
    }
}
