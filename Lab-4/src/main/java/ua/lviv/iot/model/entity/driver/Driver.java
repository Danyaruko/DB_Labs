package ua.lviv.iot.model.entity.driver;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Driver {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "full_name", length = 45)
    @NotNull
    private String full_name;

    @Column(name = "phone_number", length = 20)
    @NotNull
    private String phone_number;

    @Column(name = "email", length = 45)
    @NotNull
    private String email;

    @Column(name = "age")
    @NotNull
    private Integer age;
}
