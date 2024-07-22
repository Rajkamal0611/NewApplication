package com.cwt.sample.app.controller;

import com.cwt.sample.app.entity.Student;
import com.cwt.sample.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private List<Student> students;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentsById(id);
    }

    @PostMapping("/save")
    public Student createCustomer(@RequestBody Student Student) {
        return studentService.saveStudent(Student);
    }

//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        student.SetId(id);
//        return studentService.saveStudent(student);
//    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/saveStudents")
    public List<Student> createStudents(@RequestBody List<Student> students) {
        this.students = students;
        return studentService.saveStudents(students);
    }

    @GetMapping("/getAdults")
    public List<Student> getAdults() {
        return studentService.getAdults();
    }
    @GetMapping("/getMinors")
        public List<Student> getMinors() {
            return studentService.getMinors();
    }

}