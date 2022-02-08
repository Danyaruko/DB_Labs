package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Company;
import ua.lviv.iot.dto.bus.CompanyDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class CompanyMapper extends AbstractMapper<Company, CompanyDto> {

    @Override
    public CompanyDto mapEntityToDto(Company company) {
        if (company == null)
            return null;

        CompanyDto.CompanyDtoBuilder companyDtoBuilder = CompanyDto.builder();
        companyDtoBuilder.id(company.getId());
        companyDtoBuilder.name(company.getName());
        companyDtoBuilder.locationId(company.getLocation().getId());

        return companyDtoBuilder.build();
    }
}
