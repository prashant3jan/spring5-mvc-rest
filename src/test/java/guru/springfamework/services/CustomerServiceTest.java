package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    private static final Long ID=1l;
    private static final String FIRSTNAME = "Joe";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Joe");
        customer1.setLastname("Newman");
        customer1.setCustomerUrl("/shop/v1/customers/1");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Michael");
        customer2.setLastname("Lachappele");
        customer2.setCustomerUrl("/shop/v1/customers/2");

        Customer customer3 = new Customer();
        customer3.setId(7L);
        customer3.setFirstname("David");
        customer3.setLastname("Winter");
        customer3.setCustomerUrl("/shop/v1/customers/7");

        List<Customer> customers = Arrays.asList(customer1, customer2, customer3);

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerById() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Joe");
        customer1.setLastname("Newman");


        when(customerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1l);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
    }
}