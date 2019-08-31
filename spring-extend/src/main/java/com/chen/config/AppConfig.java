package com.chen.config;

import com.chen.util.MyImportBeanDefinitionRegistrar;
import com.chen.util.MyImportSelector;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
@Configuration
//@MapperScan(basePackages = "com.chen.mapper")
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan(basePackages ="com.chen")
public class AppConfig {

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
}
