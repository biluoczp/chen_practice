package fake.spring;

import fake.spring.service.ChenServiceImpl;
import fake.spring.util.BeanUtil;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class Test {
    public static void main(String[] args) throws Exception {
        BeanUtil beanUtil = new BeanUtil();
        beanUtil.parse("spring.xml");
        ChenServiceImpl chenService = (ChenServiceImpl) beanUtil.get("service");
        chenService.hello();

    }
}
