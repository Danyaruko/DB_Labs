package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Manufacturer;
import ua.lviv.iot.repository.bus.ManufacturerRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class ManufacturerService extends AbstractService<Manufacturer, Integer> {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    protected JpaRepository<Manufacturer, Integer> getRepository() {
        return manufacturerRepository;
    }
}
