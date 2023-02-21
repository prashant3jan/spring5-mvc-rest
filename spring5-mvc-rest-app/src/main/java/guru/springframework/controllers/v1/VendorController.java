package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api("This is my Vendor Controller")
@Controller
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
    public static final String BASE_URL="/shop/v1/vendors";
    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This will get Vendor corresponding to the given id", notes="This will get a single vendor")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id){
        return new ResponseEntity<VendorDTO>(vendorService.getVendorById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "This will get the Vendors in the db", notes="The output will be a list")
    public ResponseEntity<VendorListDTO> getAllVendors(){
        return new ResponseEntity<VendorListDTO>(vendorService.getAllVendors(),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "This will create a new vendor picking up details from the json body", notes="The id will be auto incremented")
    public ResponseEntity<VendorDTO> createNewVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.createNewVendor(vendorDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This will update Vendor details based on given id", notes="The details will be picked up from the VendorDTO provided in the input body")
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.saveVendorById(id, vendorDTO),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "This will update a property", notes="The details will be picked up from the VendorDTO provided in the input body")
    public ResponseEntity<VendorDTO> patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.patchVendor(id, vendorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "This will delete the vendor corresponding to the given id", notes="You will just get OK as output")
    public  ResponseEntity<Void> deleteVendor(@PathVariable Long id){
        vendorService.deleteVendorById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
