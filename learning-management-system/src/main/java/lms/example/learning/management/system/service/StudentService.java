package lms.example.learning.management.system.service;

import lms.example.learning.management.system.dto.StudentDTO;

import java.util.List;

public interface StudentService{
    String saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllstudents();
}
