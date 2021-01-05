package proxy.bean;

/**
 * @Author jiaxingwu
 * @Time 2018/12/26 15:23
 * @Description
 */
public class People<T> {
    public T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
