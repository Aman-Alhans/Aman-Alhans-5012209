package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.entity.Customer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-24T16:51:01+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Eclipse Adoptium)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setName( customer.getName() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setPhoneNumber( customer.getPhoneNumber() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setName( customerDTO.getName() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setPhoneNumber( customerDTO.getPhoneNumber() );

        return customer;
    }
}
