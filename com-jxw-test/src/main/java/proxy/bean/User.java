package proxy.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author jiaxingwu
 * @Time 2018/10/25 17:40
 * @Description
 */
@Data
@ToString
public class User extends CountryInfo implements Serializable {
    private String userId;
    private String userName;
    private String mobile;
    People<? extends User> wildchards;
    People<? super User> wildchard;

    public User(String userId, String userName, String mobile) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public People<? extends User> getWildchards() {
        return wildchards;
    }

    public void setWildchards(People<? extends User> wildchards) {
        this.wildchards = wildchards;
    }

    public People<? super User> getWildchard() {
        return wildchard;
    }

    public void setWildchard(People<? super User> wildchard) {
        this.wildchard = wildchard;
    }
}
