package com.summon23.fluxcassandra;

import com.summon23.fluxcassandra.entity.Student;
import com.summon23.fluxcassandra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>(
                "Year of birth cannot be in the future",
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudentById(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/all")
    public Flux<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/filter/age/{age}")
    public Flux<Student> getStudentByAge(@PathVariable int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }
}
