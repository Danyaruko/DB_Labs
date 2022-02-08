package ua.lviv.iot.dto.bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteDto {
    private Integer id;
    private String startPoint;
    private String endPoint;
    private Integer routePriceEUR;
    private Integer lengthKm;
}
