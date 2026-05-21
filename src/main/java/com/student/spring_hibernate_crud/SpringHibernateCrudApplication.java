package com.student.spring_hibernate_crud;

import com.student.spring_hibernate_crud.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateCrudApplication.class, args);
		HibernateUtil.getSessionFactory();
    }

}
