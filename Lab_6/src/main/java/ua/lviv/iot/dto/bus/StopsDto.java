package ua.lviv.iot.dto.bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopsDto {
    private Integer id;
    private String name;
    private Double priceEUR;
    private Double distanceKm;
    private Integer previousStopId;
    private Integer routeId;
}
