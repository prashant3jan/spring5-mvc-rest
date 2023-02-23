package guru.springframework.api.v1.mapper;

import guru.springframework.domain.Customer;
import guru.springframework.model.CustomerDTO;
import org.junit.Test;
import static org.junit.Assert.*;
public class CustomerMapperTest {
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Joe");
        customer.setLastname("Newman");

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(1), customerDTO.getId());
        assertEquals("Joe", customerDTO.getFirstname());
        assertEquals("Newman", customerDTO.getLastname());

    }
}