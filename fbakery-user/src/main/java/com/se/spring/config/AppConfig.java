package com.se.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.se.spring")
@PropertySource({ "classpath:persistence-mssql.properties" })
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(10240000);
		return resolver;
	}

	// define bean for RestTemplate ... this is used to make client REST calls
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// add resource handler for loading css, images, etc
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// init
	private int getIntProperty(String name) {
		String prop = env.getProperty(name);
		int initProp = Integer.parseInt(prop);

		return initProp;
	}

	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// set database
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return dataSource;
	}

	// init
	private Properties getHibernateProperties() {
		Properties pros = new Properties();

		pros.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		pros.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

		return pros;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();

		session.setDataSource(myDataSource());
		session.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		session.setHibernateProperties(getHibernateProperties());

		return session;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transManager(SessionFactory sessionFac) {
		HibernateTransactionManager trans = new HibernateTransactionManager();
		trans.setSessionFactory(sessionFac);

		return trans;
	}

}
