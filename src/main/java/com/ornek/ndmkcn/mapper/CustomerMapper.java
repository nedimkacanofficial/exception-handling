package com.ornek.ndmkcn.mapper;

import com.ornek.ndmkcn.dto.CustomerDTO;
import com.ornek.ndmkcn.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDTO toDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        return dto;
    }
    public static List<CustomerDTO> customerDTOList(List<Customer> entityList) {
        return entityList.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }
    public static Customer toEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public static List<Customer> toEntityList(List<CustomerDTO> dtoList) {
        return dtoList.stream()
                .map(CustomerMapper::toEntity)
                .collect(Collectors.toList());
    }
}
