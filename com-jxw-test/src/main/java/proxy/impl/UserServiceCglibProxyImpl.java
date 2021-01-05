package proxy.impl;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import proxy.UserService;

import java.lang.reflect.Method;

/**
 * @Author jiaxingwu
 * @Time 2018/12/14 9:26
 * @Description
 */
public class UserServiceCglibProxyImpl implements MethodInterceptor {
    private UserService userService;

    public UserServiceCglibProxyImpl(UserService userService) {
        this.userService = userService;
    }

    public void cglibProxySave() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceAimsImpl.class);
        enhancer.setCallback(this);
        UserService userService = (UserService) enhancer.create();
        userService.save();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行代码前...");
        Object invoke;
        invoke = methodProxy.invokeSuper(o, objects);
        System.out.println(invoke);
        System.out.println("执行代码后...");
        return invoke;
    }
}
