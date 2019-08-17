package fake.spring.dao;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class ChenDaoImpl implements ChenDao {

    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
