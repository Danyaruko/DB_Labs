package model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_point", length = 45, nullable = false)
    private String startPoint;

    @Column(name = "end_point", length = 45, nullable = false)
    private String endPoint;

    @Column(name = "route_price_EUR", nullable = false)
    private Integer routePriceEUR;

    @Column(name = "length_km", nullable = false)
    private Integer lengthKm;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private Collection<Bus> buses;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private Collection<Stops> stops;

    public Route(Integer id, String startPoint, String endPoint, Integer routePriceEUR, Integer lengthKm) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.routePriceEUR = routePriceEUR;
        this.lengthKm = lengthKm;
    }

    @Override
    public String toString() {
        return "Route {"
                + "id =" + id + ", "
                + "startPoint =" + startPoint + ", "
                + "endPoint = " + endPoint + ", "
                + "routePriceEUR = " + routePriceEUR + ", "
                + "lengthKm = " + lengthKm
                + "};" + "\n";
    }
}
