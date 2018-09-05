package com.niit.cofig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OderDetail;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
     @Bean(name="dataSource")
     public DataSource getH2DataSource()
     {
    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	 dataSource.setDriverClassName("org.h2.Driver");
    	 dataSource.setUrl("jdbc:h2:tcp://localhost/~/MyBazar");
    	 dataSource.setUsername("sa");
    	 dataSource.setPassword("");
    	 
    	 System.out.println("data source object created");
    	 return dataSource;
     }

@Bean(name ="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties properties = new Properties();
	properties.put("hibernate.hbm2ddl.auto", "update");
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    LocalSessionFactoryBuilder sessionFactoryBuilder= new LocalSessionFactoryBuilder(getH2DataSource());
      sessionFactoryBuilder.addProperties(properties);
      
      sessionFactoryBuilder.addAnnotatedClass(Category.class);
      sessionFactoryBuilder.addAnnotatedClass(Product.class);
      sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
      sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
      sessionFactoryBuilder.addAnnotatedClass(CartItem.class);
      sessionFactoryBuilder.addAnnotatedClass(OderDetail.class);
      SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
      System.out.println("sessionfactory object created");
      return sessionFactory;
}
        @Bean
        public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory) {
        	System.out.println("hibernate transaction object created");
            return new HibernateTransactionManager(sessionFactory);

		}
} 
       