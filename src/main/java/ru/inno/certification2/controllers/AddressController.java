package ru.inno.certification2.controllers;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.certification2.models.Address;
import ru.inno.certification2.repositories.AddressRepository;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    private final DataSource dataSource;

    public AddressController(AddressRepository addressRepository, DataSource dataSource) {
        this.addressRepository = addressRepository;
        this.dataSource = dataSource;
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable("id") Long id) {
        Address address = addressRepository.getOne(id);
        Address result = new Address();
        result.setId(address.getId());
        result.setCity(address.getCity());
        result.setStreet(address.getStreet());
        result.setHomeNumber(address.getHomeNumber());
        return result;
    }

    @GetMapping("/jdbc/address")
    public Object getAddressByIdJdbc() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        List<Address> result = jdbcTemplate.query("SELECT * FROM address", (resultSet, i) -> {
            Address result1 = new Address();
            result1.setId(resultSet.getLong(1));
            result1.setCity(resultSet.getString(2));
            result1.setStreet(resultSet.getString(3));
            result1.setHomeNumber(resultSet.getString(4));
            return result1;
        });
        return result;
    }
}
