package lms.example.learning.management.system.repository;

import lms.example.learning.management.system.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
