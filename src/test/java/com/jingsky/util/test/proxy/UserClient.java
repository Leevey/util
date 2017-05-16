package com.jingsky.util.test.proxy;

/**
 * Created by jing on 5/16/17.
 */
public class UserClient {

    public static void main(String[] args){
        UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
        System.out.println(userManager.getAge());
    }
}
