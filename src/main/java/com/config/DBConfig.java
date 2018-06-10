package com.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据库配置
 * 使用Hibernate结合jpa，使用Hibernate的sessionFactory
 *  using Hibernate as JPA implementation and MySQL as database.
 */

@Configuration
@EnableTransactionManagement
public class DBConfig {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driverClassName}")
    String classname;


    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(classname);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * spring-boot 1.4 使用此种方式
     * @param dataSource
     * @return
     */
    @Bean
    @Primary
    public LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.models");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.naming.implicit-strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");        //隐式命名策略，使用此属性当我们使用的表或列没有明确指定一个使用的名称 。
        properties.put("hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");     //物理命名策略，用于转换“逻辑名称”(隐式或显式)的表或列成一个物理名称。
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }

}
