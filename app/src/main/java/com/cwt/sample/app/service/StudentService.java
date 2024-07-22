package com.cwt.sample.app.service;

import com.cwt.sample.app.entity.Student;
import com.cwt.sample.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentsById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student Student) {
        return studentRepository.save(Student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> saveStudents(List<Student> Students) {
        return studentRepository.saveAll(Students);
    }

    public List<Student> getAdults() {
        List<Student> students = studentRepository.findAll();
        return students.stream().filter(s -> s.getAge() > 18).collect(Collectors.toList());
    }

    public List<Student> getMinors() {
     List<Student> students = studentRepository.findAll();
     return students.stream().filter(s-> s.getAge() < 18).collect(Collectors.toList());


    }



}
