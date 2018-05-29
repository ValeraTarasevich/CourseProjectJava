package dao;

import dao.impl.SqlManagerImpl;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SqlFactory {

    private static SqlFactory instance = new SqlFactory();
    private static Lock lock = new ReentrantLock();

    private final SqlManager sqlManager = new SqlManagerImpl();

    private SqlFactory() {}

    public SqlManager getSqlManager() {
        return sqlManager;
    }

    public static SqlFactory getInstance() {
        try {
            lock.lock();
            if (instance == null){
                instance = new SqlFactory();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
        return instance;
    }
}
