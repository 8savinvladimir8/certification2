package ru.inno.certification2.controllers;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.inno.certification2.models.Address;
import ru.inno.certification2.repositories.AddressRepository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Controller
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

    @GetMapping("/jdbc/address/{id}")
    public Object getAddressByIdJdbc(@PathVariable("id") Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM address WHERE id=:id", paramMap);
        return result;
    }
}
