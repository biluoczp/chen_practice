package fake.spring.service;

import fake.spring.dao.ChenDao;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class ChenServiceImpl implements ChenService {


    public ChenServiceImpl(ChenDao dao) {
        this.dao = dao;

    }

    public void setDao(ChenDao dao) {
        this.dao = dao;
    }

    private ChenDao dao;


    @Override
    public void hello() {
        dao.hello();
    }
}
