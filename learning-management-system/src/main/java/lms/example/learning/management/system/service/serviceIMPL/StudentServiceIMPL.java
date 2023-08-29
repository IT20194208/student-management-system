package lms.example.learning.management.system.service.serviceIMPL;

import lms.example.learning.management.system.dto.StudentDTO;
import lms.example.learning.management.system.entity.StudentEntity;
import lms.example.learning.management.system.repository.StudentRepo;
import lms.example.learning.management.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public String saveStudent(StudentDTO studentDTO) {
        StudentEntity student=new StudentEntity(

                studentDTO.getSid(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getTel(),
                studentDTO.getNic()

        );
        studentRepo.save(student);
        return "student save successfully";
    }

    @Override
    public List<StudentDTO> getAllstudents() {
        List<StudentEntity> getStudents=studentRepo.findAll();
        List<StudentDTO> studentDTOList=new ArrayList<>();
        for(StudentEntity student : getStudents){
            StudentDTO studentDTO=new StudentDTO(

                    student.getSid(),
                    student.getName(),
                    student.getAddress(),
                    student.getTel(),
                    student.getNic()

            );
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}
