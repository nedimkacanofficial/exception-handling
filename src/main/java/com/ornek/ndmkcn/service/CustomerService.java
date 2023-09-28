package com.ornek.ndmkcn.service;

import com.ornek.ndmkcn.dto.CustomerDTO;
import com.ornek.ndmkcn.entity.Customer;
import com.ornek.ndmkcn.exception.CustomerNotFoundException;
import com.ornek.ndmkcn.mapper.CustomerMapper;
import com.ornek.ndmkcn.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ornek.ndmkcn.mapper.CustomerMapper.customerDTOList;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomer() {
        logger.debug("Request to get all Customer");
        List<Customer> customerList= this.customerRepository.findAll();
        return CustomerMapper.customerDTOList(customerList);
    }
    @Transactional(readOnly = true)
    public CustomerDTO getCustomer(Long id) {
        logger.debug("Request to get one Customer customerId: {}",id);
        Customer customer= this.customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id.toString()));
        return CustomerMapper.toDTO(customer);
    }
    public CustomerDTO insertCustomer(CustomerDTO newCustomerDTO) {
        Customer customer=CustomerMapper.toEntity(newCustomerDTO);
        Customer newCustomer=this.customerRepository.save(customer);
        return CustomerMapper.toDTO(newCustomer);
    }
    public CustomerDTO updateCustomer(Long id,CustomerDTO newCustomerDTO) {
        Customer customer=this.customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id.toString()));
        customer.setFirstName(newCustomerDTO.getFirstName());
        customer.setLastName(newCustomerDTO.getLastName());
        customer.setEmail(newCustomerDTO.getEmail());
        Customer newCustomer=this.customerRepository.save(customer);
        return CustomerMapper.toDTO(newCustomer);
    }
    public void deleteCustomer(Long id) {
        Customer customer=this.customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException(id.toString()));
        this.customerRepository.findById(customer.getId());
    }
}
