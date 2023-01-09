package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setFirstname("Joe");
        customer.setLastname("Newman");
        customer.setCustomerUrl("/shop/v1/customers/1");

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(1), customerDTO.getId());
        assertEquals("Joe", customerDTO.getFirstname());
        assertEquals("Newman", customerDTO.getLastname());
        assertEquals("/shop/v1/customers/1", customerDTO.getCustomerUrl());
    }
}