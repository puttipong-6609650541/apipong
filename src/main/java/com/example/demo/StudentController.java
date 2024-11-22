package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students/add")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository StudentRepository;

    @GetMapping
    public List<Student> getAllStudent() {
        return StudentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            StudentRepository.save(student);
            return ResponseEntity.ok("บันทึกข้อมูลนักศึกษาสำเร็จ");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ไม่สามารถบันทึกข้อมูลนักศึกษาได้");
        }
    }


}