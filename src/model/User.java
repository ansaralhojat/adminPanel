package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_")
public class User extends BaseModel {
    private String username;
    private String password;
    private String name;
    private String family;
    private String MobilePhone;
    private String pictureAddress;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMobilePhone() {
        return this.MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.MobilePhone = mobilePhone;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}
