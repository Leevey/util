package com.jingsky.util.test.proxy;

/**
 * Created by jing on 5/16/17.
 */
public class UserManagerImplProxy implements UserManager {
    private UserManager userManager;
    public UserManagerImplProxy(UserManager userManager){
        this.userManager=userManager;
    }
    public int getAge() {
        return userManager.getAge();
    }
}
