package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods siwm = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = siwm.getClass().getClassLoader();
        Class<?>[] interfaces = siwm.getClass().getInterfaces();
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(siwm);
        SomeInterfaceWithMethods proxy = (SomeInterfaceWithMethods) newProxyInstance(classLoader,interfaces,invocationHandler);
        return proxy;
    }
}