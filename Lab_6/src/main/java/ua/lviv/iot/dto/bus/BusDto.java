package ua.lviv.iot.dto.bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private Integer id;
    private String busNumber;
    private Double mileageKm;
    private Integer age;
    private Integer seats;
    private Integer idRoute;
    private Integer ownerCompanyId;
    private Integer manufacturerId;
}
