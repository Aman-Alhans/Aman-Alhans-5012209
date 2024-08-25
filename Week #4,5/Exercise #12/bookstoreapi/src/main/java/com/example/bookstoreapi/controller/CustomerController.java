package com.example.bookstoreapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bookstoreapi.entity.Customer;
import com.example.bookstoreapi.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Customer>> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            EntityModel<Customer> resource = EntityModel.of(customer.get());
            WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(id));
            resource.add(selfLink.withSelfRel());
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Page<EntityModel<Customer>>> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerService.getAllCustomers(pageable);
        Page<EntityModel<Customer>> customerResources = customers.map(customer -> {
            EntityModel<Customer> resource = EntityModel.of(customer);
            WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(customer.getId()));
            resource.add(selfLink.withSelfRel());
            return resource;
        });
        return ResponseEntity.ok(customerResources);
    }


	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EntityModel<Customer>> createCustomer(@RequestBody Customer customer) {
	   Customer createdCustomer = customerService.saveCustomer(customer);
	   EntityModel<Customer> resource = EntityModel.of(createdCustomer);
	   WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(createdCustomer.getId()));
	   resource.add(selfLink.withSelfRel());
	   return ResponseEntity.status(HttpStatus.CREATED).body(resource);
	}

	@PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EntityModel<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
	    if (!customerService.getCustomerById(id).isPresent()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    customer.setId(id);
	    Customer updatedCustomer = customerService.saveCustomer(customer);
	    EntityModel<Customer> resource = EntityModel.of(updatedCustomer);
	    WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(updatedCustomer.getId()));
	    resource.add(selfLink.withSelfRel());
	    return ResponseEntity.ok(resource);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (!customerService.getCustomerById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
