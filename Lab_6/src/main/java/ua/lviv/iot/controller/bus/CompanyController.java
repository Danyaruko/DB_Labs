package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Company;
import ua.lviv.iot.dto.bus.CompanyDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.CompanyMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.CompanyService;

@RequestMapping(value = "/companies")
@RestController
@AllArgsConstructor
public class CompanyController extends AbstractController<Company, CompanyDto, Integer> {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Override
    protected AbstractService<Company, Integer> getService() {
        return companyService;
    }

    @Override
    protected AbstractMapper<Company, CompanyDto> getMapper() {
        return companyMapper;
    }
}
