package guru.springframework.controllers.v1;

import guru.springframework.model.CustomerDTO;
import guru.springframework.model.CustomerListDTO;
import guru.springframework.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(description="This is my Customer Controller")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/shop/v1/customers";
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomers(){
        CustomerListDTO customerListDTO = new CustomerListDTO();
        customerListDTO.getCustomers().addAll(customerService.getAllCustomers());
        return customerListDTO;
    }
    @ApiOperation(value="This will get a list of customers.", notes="These are some notes about the API")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1 = customerService.createNewCustomer(customerDTO);
        return customerDTO1;
    }
    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(id, customerDTO);
    }
    @PatchMapping("/{id}")
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}