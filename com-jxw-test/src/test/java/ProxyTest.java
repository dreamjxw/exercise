import org.junit.Test;
import proxy.impl.UserServiceAimsImpl;
//import proxy.impl.UserServiceCglibProxyImpl;
import proxy.impl.UserServiceJdkProxyImpl;
import proxy.impl.UserServiceStaticProxyImpl;

/**
 * @Author jiaxingwu
 * @Time 2018/12/14 9:14
 * @Description
 */
public class ProxyTest {
    @Test
    public void staticProxyTest() {
        UserServiceAimsImpl userServiceAims = new UserServiceAimsImpl();
        UserServiceStaticProxyImpl userServiceProxy = new UserServiceStaticProxyImpl(userServiceAims);
        userServiceProxy.save();
    }

    @Test
    public void jdkProxyTest() {
        UserServiceAimsImpl userServiceAims = new UserServiceAimsImpl();
        UserServiceJdkProxyImpl userServiceJdkProxy = new UserServiceJdkProxyImpl(userServiceAims);
        userServiceJdkProxy.proxySave();
    }
//    @Test
//    public void cglibProxyTest() {
//        UserServiceAimsImpl userServiceAims = new UserServiceAimsImpl();
//        UserServiceCglibProxyImpl userServiceCglibProxy = new UserServiceCglibProxyImpl(userServiceAims);
//        userServiceCglibProxy.cglibProxySave();
//    }

}
