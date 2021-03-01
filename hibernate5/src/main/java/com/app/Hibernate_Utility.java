package com.app;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Hibernate_Utility {

	public static SessionFactory getSessionFactory() 
	{
		Properties pr = new Properties();
		pr.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		pr.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate5");
	    pr.setProperty("hibernate.connection.username", "root");
		pr.setProperty("hibernate.connection.password", "root");
		pr.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pr.put("hibernate.id.new_generator_mappings", "false");
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(pr).build();
		
		ServiceRegistry registry=builder.build();
		
		MetadataSources source=new MetadataSources(registry).addAnnotatedClass(Employee.class);
		Metadata data=source.getMetadataBuilder().build();
		SessionFactory sf=data.getSessionFactoryBuilder().build();
		return sf;
	}
}
