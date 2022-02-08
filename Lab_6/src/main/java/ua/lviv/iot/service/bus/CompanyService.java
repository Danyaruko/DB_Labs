package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Company;
import ua.lviv.iot.repository.bus.CompanyRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class CompanyService extends AbstractService<Company, Integer> {
    private final CompanyRepository companyRepository;

    @Override
    protected JpaRepository<Company, Integer> getRepository() {
        return companyRepository;
    }
}
