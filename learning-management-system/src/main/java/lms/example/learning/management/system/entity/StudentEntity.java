package lms.example.learning.management.system.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid",length = 10)
    private int sid;

    @Column(name="name",length = 60)
    private String name;

    @Column(name="address",length = 200)
    private String address;

    @Column(name="tel",length =12)
    private String tel;

    @Column(name="nic",length = 15)
    private String nic;
}
