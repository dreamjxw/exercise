package proxy.impl;

import proxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author jiaxingwu
 * @Time 2018/12/14 9:26
 * @Description
 */
public class UserServiceJdkProxyImpl implements InvocationHandler {
    private UserService userService;

    public UserServiceJdkProxyImpl(UserService userService) {
        this.userService = userService;
    }

    public void proxySave() {
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(classLoader, interfaces, this);
        System.out.println("调用前...proxySave");
        proxyInstance.save();
        System.out.println("调用后...proxySave");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前...invoke");
        Object invoke = method.invoke(userService, args);
        System.out.println(invoke);
        System.out.println("调用后...invoke");
        return invoke;
    }
}
