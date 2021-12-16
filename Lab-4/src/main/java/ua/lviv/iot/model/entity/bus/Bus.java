package ua.lviv.iot.model.entity.bus;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "bus")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "bus_number")
@ToString
public class Bus {
    @Id
    @Column(name = "bus_number", length = 12)
    @NotNull
    private String busNumber;

    @Column(name = "mileage_km")
    @NotNull
    private Integer mileageKm;

    @Column(name = "age")
    @NotNull
    private Integer age;

    @Column(name = "id_route")
    @NotNull
    private Integer idRoute;

    @Column(name = "owner_company_id")
    @NotNull
    private Integer ownerCompanyId;

    @Column(name = "manufacturer_id")
    @NotNull
    private Integer manufacturerId;

}
