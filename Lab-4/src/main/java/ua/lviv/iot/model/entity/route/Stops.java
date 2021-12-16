package ua.lviv.iot.model.entity.route;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "stops")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Stops {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "name", length = 45)
    @NotNull
    private String name;

    @Column(name = "price_EUR")
    @NotNull
    private Float priceEUR;

    @Column(name = "distance_km")
    @NotNull
    private Float distanceKm;

    @Column(name = "previous_stop_id")
    @NotNull
    private Integer previousStopId;

    @Column(name = "route_id")
    @NotNull
    private Integer routeId;
}
