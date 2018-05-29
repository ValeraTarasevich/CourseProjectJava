package entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ErrorMsg {

    private static ErrorMsg instance = new ErrorMsg();
    private static Lock lock = new ReentrantLock();

    private String errorMsg;

    private ErrorMsg() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static ErrorMsg getInstance() {
        try {
            lock.lock();
            if (instance == null){
                instance = new ErrorMsg();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
        return instance;
    }

}
