package ua.lviv.iot.dto.driver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDto {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
}
