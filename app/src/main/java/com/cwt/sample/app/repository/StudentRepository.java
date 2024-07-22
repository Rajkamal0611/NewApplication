package com.cwt.sample.app.repository;

import com.cwt.sample.app.entity.Customer;
import com.cwt.sample.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
