package ua.lviv.iot.model.entity.bus;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Location {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "country", length = 45)
    @NotNull
    private String country;

    @Column(name = "city", length = 45)
    @NotNull
    private String city;

    @Column(name = "street", length = 45)
    @NotNull
    private String street;
}

