package com.coderman;

import com.coderman.dao.DAO;
import com.coderman.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JdbcExampleApplication {

    private static DAO<Course> dao;

    public JdbcExampleApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcExampleApplication.class, args);

        System.out.println("\n Create Course ----------------------\n");
        Course springVue = new Course("SpringBoot + Vue", "New Course","www.asdf.com");
        dao.create(springVue);

        System.out.println("\n One Course ----------------------\n");
        Optional<Course> firstCourse = dao.get(1);
        System.out.println(firstCourse.get());

        springVue.setDescription("Learn to build Vue apps that talk to Spring boot");
        dao.update(springVue,6);

        dao.delete(4);

        System.out.println("\n ALl Courses ----------------------\n");
        List<Course> courseList =dao.list();
        courseList.forEach(System.out::println);


    }

}
