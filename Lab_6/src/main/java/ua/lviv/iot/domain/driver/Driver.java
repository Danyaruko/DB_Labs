package ua.lviv.iot.domain.driver;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "driver")
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

    @Column(name = "full_name", length = 45, nullable = false)
    private String fullName;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Override
    public String toString() {
        return "Driver {"
                + "id =" + id + ", "
                + "fullName =" + fullName + ", "
                + "phoneNumber = " + phoneNumber + ", "
                + "email = " + email + ", "
                + "age = " + age
                + "};" + "\n";
    }
}
