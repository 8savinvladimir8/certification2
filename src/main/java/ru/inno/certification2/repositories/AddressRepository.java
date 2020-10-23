package ru.inno.certification2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.certification2.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
