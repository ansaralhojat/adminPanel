package webBean;

import model.Address;
import sessionFacadeBean.BaseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class AddressWebBean implements Serializable {
    @EJB
    private BaseService<Address> addressService;

    private String timeInfo;
    private String addressInfo;
    private Boolean family;
    private Boolean parking;
    private Address address;

    @PostConstruct
    public void init() {
        address = addressService.findAllOrderById(Address.class, true).get(0);
        timeInfo = address.getTimeInfo();
        addressInfo = address.getAddressInfo();
        family = address.isParking();
        parking = address.isParking();
    }

    public void save() {
        address.setTimeInfo(timeInfo);
        address.setAddressInfo(addressInfo);
        address.setAddressInfo(addressInfo);
        address.setFamily(family);
        address.setParking(parking);
        addressService.merge(address);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "با موفقیت ذخیره شد", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(String timeInfo) {
        this.timeInfo = timeInfo;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public Boolean getFamily() {
        return family;
    }

    public void setFamily(Boolean family) {
        this.family = family;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
