package entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ActiveUser {

    private static ActiveUser instance = new ActiveUser();
    private static Lock lock = new ReentrantLock();

    private String login;

    private ActiveUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static ActiveUser getInstance() {
        try {
            lock.lock();
            if (instance == null){
                instance = new ActiveUser();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public static void delActiveUser(){
        try {
            lock.lock();
            instance = null;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }


}
