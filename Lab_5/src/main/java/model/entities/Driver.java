package model.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "driver")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "full_name", length = 45, nullable = false)
    private String fullName;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Override
    public String toString() {
        return "Driver {"
                + "id =" + id + ", "
                + "age =" + age + ", "
                + "fullName =" + fullName + ", "
                + "phoneNumber = " + phoneNumber + ", "
                + "email = " + email
                + "};" + "\n";
    }
}
