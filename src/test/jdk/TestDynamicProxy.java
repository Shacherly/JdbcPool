package test.jdk;

import com.duing.dao.ProxyInterface;
import com.duing.dao.ProxyInterfaceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {
        ProxyInterface proxyInterface = new ProxyInterfaceImpl();

        /*
         * 第一种代理实现方法
         */
        // 首先都是让代理类持有真是对象
        DynamicProxy<ProxyInterface> proxy = new DynamicProxy<>(proxyInterface);
        // 再通过Proxy.newProxyInstance获取代理对象，两种方法都行
        ProxyInterface proxyInstance1 = proxy.getProxyInstance(ProxyInterface.class);
        // 使用代理对象执行方法。
        proxyInstance1.doSmothing("hate You");

        /*
         * 第二种代理实现方法
         */
        Dynamic<ProxyInterface> handler = new Dynamic<>(proxyInterface);
        ProxyInterface proxyInstance2 = (ProxyInterface) Proxy.newProxyInstance(
                // proxyInterface.getClass().getClassLoader(),
                handler.getClass().getClassLoader(),
                proxyInterface.getClass().getInterfaces(),
                handler
        );
        proxyInstance2.doSmothing("hate You");
    }
}

@SuppressWarnings("unchecked")
class DynamicProxy<T> {

    private T proxyObject;

    public DynamicProxy(T proxyObject) {
        this.proxyObject = proxyObject;
    }

    public T getProxyInstance(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                // proxyObject.getClass().getClassLoader(),
                clazz.getClassLoader(),
                new Class[]{clazz},
                (proxy, method, args) -> method.invoke(proxyObject, args)
        );
    }
}

class Dynamic<T> implements InvocationHandler {

    private T proxyObject;

    public Dynamic(T proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxyObject, args);
    }
}
