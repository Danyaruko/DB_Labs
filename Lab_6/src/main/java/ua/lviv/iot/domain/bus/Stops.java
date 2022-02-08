package ua.lviv.iot.domain.bus;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stops")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Stops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "price_EUR", nullable = false)
    private Double priceEUR;

    @Column(name = "distance_km", nullable = false)
    private Double distanceKm;

    @Column(name = "previous_stop_id")
    private Integer previousStopId;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
    private Route route;

    @Override
    public String toString() {
        return "Stops {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "priceEUR =" + priceEUR + ", "
                + "distanceKm =" + distanceKm + ", "
                + "previousStopId =" + previousStopId + ", "
                + "routeId =" + route.getId()
                + "};" + "\n";
    }
}