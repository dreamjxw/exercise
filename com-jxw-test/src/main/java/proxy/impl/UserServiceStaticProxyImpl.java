package proxy.impl;

import proxy.UserService;

/**
 * @Author jiaxingwu
 * @Time 2018/12/12 15:27
 * @Description
 */
public class UserServiceStaticProxyImpl implements UserService {
    private UserService userService;

    public UserServiceStaticProxyImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUserPin(String a) {
        return null;
    }

    @Override
    public String save() {
        System.out.println("执行前...");
        System.out.println(userService.save());
        System.out.println("执行后...");
        return userService.save();
    }
}
