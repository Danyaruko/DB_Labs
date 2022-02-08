package ua.lviv.iot.repository.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.bus.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
