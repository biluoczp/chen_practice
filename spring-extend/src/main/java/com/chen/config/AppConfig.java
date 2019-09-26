package com.chen.config;

import com.chen.extend.MyImportBeanDefinitionRegistrar;
import com.chen.extend.MyImportSelector;
import com.chen.service.TestService;
import com.chen.service.TestService2;
import com.chen.service.TestService3;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
@Configuration
//@MapperScan(basePackages = "com.chen.mapper")
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan(basePackages ="com.chen")
//    @Import(TestService2.class)
//@EnableAspectJAutoProxy
//@Component
public class AppConfig {

//    @Bean
//    public TestService testService(){
//        return new TestService();
//    }
//
//    @Bean
//    public TestService3 testService3(){
//        testService();
//        return new TestService3();
//    }

}


//    @Bean
//    public DataSource druidDataSource() {
//       return new UnpooledDataSource("com.mysql.jdbc.Driver",
//                "jdbc:mysql://127.0.0.1:3306/test"
//                , "root", "root");
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    public DataSourceTransactionManager createTransactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
