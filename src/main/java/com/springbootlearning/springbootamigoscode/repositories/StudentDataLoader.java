package com.springbootlearning.springbootamigoscode.repositories;

import com.springbootlearning.springbootamigoscode.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentDataLoader implements CommandLineRunner {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (studentRepository.count() == 0) {
            Student user1 = new Student("John Doe", "john.doe@test.com", LocalDate.of(1990, 9, 9));
            Student user2 = new Student("Parzival Last", "plast@test.com", LocalDate.of(1980, 8, 8));
            studentRepository.save(user1);
            studentRepository.save(user2);
        }
        System.out.println(studentRepository.count());
    }
}
