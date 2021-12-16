package ua.lviv.iot.model.entity.route;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Route {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "start_point", length = 45)
    @NotNull
    private String startPoint;

    @Column(name = "end_point", length = 45)
    @NotNull
    private String endPoint;

    @Column(name = "route_price_EUR")
    @NotNull
    private Float routePriceEUR;

    @Column(name = "length_km")
    @NotNull
    private Float lengthKm;
}
