package lms.example.learning.management.system.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class StudentDTO {

    private int sid;
    private String name;
    private String address;
    private String tel;
    private String nic;
}
