package com.chen.extend;

import com.chen.mapper.ChenDaoImpl;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class ProxyUtil {

    private static final String LINE = "\n";
    private static final String TAB = "\t";

    /**
     * 获取代理对象
     * 1.构建.java文件
     * 2.通过.java文件生成.class文件
     * 3.通过反射生成java对象
     */
    public static Object getProxy(Object obj) {
        Class target = obj.getClass();

        Class parent = target.getInterfaces()[0];

        //顶层定义（包定义+引用）
        String top = "package com.chen.util;" + LINE
                + "import " + parent.getPackage() + ";" + LINE;


        //类定义
        String classDefine = "public class Proxy implements " + parent.getSimpleName() + "{" + LINE;
        //属性和构造方法
        String property = TAB + "private " + target.getSimpleName() + " target;" + LINE;

        String construct = TAB + "public Proxy(" + target.getSimpleName() + " target) {" + LINE
                + TAB + TAB + "this.target = target;" + LINE + TAB + "}";

        //继承的方法
        Method[] methods = parent.getMethods();
        String methodInfo = LINE + TAB + "";
        for (Method method : methods) {


            Class[] params = method.getParameterTypes();
            String p = "";
            String args = "";
            int i = 0;
            for (Class param : params) {
                p += param.getSimpleName() + " arg" + i + ",";
                args = " arg" + i + ",";
                i++;
            }
            p = p.substring(0, p.indexOf(",") + 1);
            args = args.substring(0, args.indexOf(",") + 1);

            methodInfo += "public " + method.getReturnType().getSimpleName() + " " + method.getName() + " (" + p + ")" +
                    "{" + LINE + TAB + TAB;
            String temp = "target." + method.getName() + "(" + args + ");" + LINE + TAB + "}";
            if (Void.class.equals(method.getReturnType())) {
                methodInfo += temp;
            } else {
                methodInfo += "return " + temp;
            }

        }


        String all = top + classDefine + property + construct + methodInfo + LINE + "}";
        System.out.println(all);


        File file =new File("/Users/chenzepeng/Desktop/spring");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(all);
            fw.flush();
            fw.close();


            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");

            Constructor constructor = clazz.getConstructor(target);

          Object  proxy = constructor.newInstance(target);
            //clazz.newInstance();
            //Class.forName()
            return proxy;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getProxy(new ChenDaoImpl());
    }

}
