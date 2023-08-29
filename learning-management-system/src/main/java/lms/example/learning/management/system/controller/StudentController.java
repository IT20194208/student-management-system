package lms.example.learning.management.system.controller;

import lms.example.learning.management.system.dto.StudentDTO;
import lms.example.learning.management.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService stuService;
    /*
    we need request body to convert json to java or request body can map it json to java
    after send response that contain inside the restcontroller or if we use @controller that
    not store @response body but rest controller have everything
     */

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentDTO studentDTO){

        String message=stuService.saveStudent(studentDTO);
        return message;

    }
    @GetMapping("/get-All-student")
    public List<StudentDTO> getAllStudent(){
        List<StudentDTO> studentList=stuService.getAllstudents();
        return studentList;
    }


}
