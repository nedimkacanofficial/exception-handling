package com.ornek.ndmkcn.controller;

import com.ornek.ndmkcn.dto.CustomerDTO;
import com.ornek.ndmkcn.entity.Customer;
import com.ornek.ndmkcn.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class CustomerController {
    private final Logger logger= LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        logger.debug("REST request to get all Customers");
        List<CustomerDTO> customerDTOList=this.customerService.getAllCustomer();
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        logger.debug("REST request to get one Customer customerId: {}",id);
        CustomerDTO customerDTO=this.customerService.getCustomer(id);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> insertCustomer(@Valid @RequestBody CustomerDTO newCustomerDTO) {
        logger.debug("REST request to insert Customer: {}",newCustomerDTO);
        CustomerDTO customerDTO=this.customerService.insertCustomer(newCustomerDTO);
        return new ResponseEntity<>(customerDTO,HttpStatus.CREATED);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDTO newCustomerDTO) {
        logger.debug("REST request to update Customer: {} where customerId: {}",newCustomerDTO,id);
        CustomerDTO customerDTO = this.customerService.updateCustomer(id,newCustomerDTO);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        logger.debug("REST request to delete Customer customerId: {}",id);
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
