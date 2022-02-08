package ua.lviv.iot.domain.bus;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bus")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "bus_number", length = 12, nullable = false)
    private String busNumber;


    @Column(name = "mileage_km", nullable = false)
    private Double mileageKm;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "id_route", referencedColumnName = "id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "owner_company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Bus {"
                + "id =" + id + ","
                + "busNumber =" + busNumber + ", "
                + "mileageKm =" + mileageKm + ", "
                + "age =" + age + ", "
                + "seats =" + seats + ", "
                + "idRoute =" + route.getId() + ", "
                + "companyId =" + company.getId() + ", "
                + "manufacturerId =" + manufacturer.getId()
                + "};" + "\n";
    }
}