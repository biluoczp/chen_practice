package fake.spring.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class BeanUtil {

    private Map<String, Object> beanMap = new HashMap<>();

    public void parse(String path) throws Exception {

        // 1.通过reader对象的read（）方法加载books.xml文件，获取document对象
        Document document = getDoc(path);

        Element root = document.getRootElement();
        List<Element> beans = root.elements();


        for (Element ele : beans) {
            String id = ele.attributeValue("id");
            String name = ele.attributeValue("class");
            Class clazz = Class.forName(name);

            Object obj = null;
            List<Element> childs = ele.elements();

            for (Element child : childs) {
                //参数注入
                String i = child.attributeValue("id");
                String ref = child.attributeValue("ref");
                Object r = beanMap.get(ref);

//                //1.属性注入
                //obj = clazz.newInstance();
////                Field field = clazz.getDeclaredField(i);
////                field.setAccessible(true);
////                field.set(obj, r);
//                //2.set方法
//
//                Method method = clazz.getDeclaredMethod("setDao", r.getClass().getInterfaces()[0]);
//                method.invoke(obj, r);


                //3.构造函数
                Constructor con = clazz.getDeclaredConstructor(r.getClass().getInterfaces()[0]);
                obj = con.newInstance(r);


            }
            if (obj == null) {
                obj = clazz.newInstance();
            }

            beanMap.put(id, obj);
        }

        System.out.println(beanMap);
    }

    public Object get(String id) {
        return beanMap.get(id);

    }

    private Document getDoc(String path) throws DocumentException {
        URL url = this.getClass().getClassLoader().getResource(path);
        SAXReader reader = new SAXReader();
        return reader.read(url);
    }


}
