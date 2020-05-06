package com.portal.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Component//@Component is a class level annotation where 
@Configuration// allows us to use annotations for dependency injection 
@EnableTransactionManagement//for  transaction 
@ComponentScan(basePackages= {"com.portal"})//search stereo type annotation
public class DBConfig {

	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	@Bean(name="dataSource")//as @Bean is a method level annotation 
	public DataSource getDataSource()  //by default bean name will be same as method name
	//@Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
	//Spring Bean annotation is usually declared in Configuration classes methods.
	{
	
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		

		Properties p=new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");//Image result for dialect in hibernateesgyn.com
//		The dialect specifies the type of database used in hibernate so that hibernate generate appropriate type of SQL statements
		p.setProperty("hibernate.hbm2ddl.auto","update");
		p.setProperty("hibernate.show_sql", "true");
		
		
		LocalSessionFactoryBuilder sb=
				new LocalSessionFactoryBuilder(getDataSource());
		sb.addProperties(p);
		sb.scanPackages("com.portal.models");
		SessionFactory sf=sb.buildSessionFactory();
		
		return sf;
	}

	@Bean(name="HibernateTranscation")
	@Autowired
	public HibernateTransactionManager getHibernateTranscationManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager txManager=
				new HibernateTransactionManager(sessionFactory);
		return txManager;
	}	
	

}
