package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
    public static final String BASE_URL="/shop/v1/vendors";
    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id){
        return new ResponseEntity<VendorDTO>(vendorService.getVendorById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<VendorListDTO> getAllVendors(){
        return new ResponseEntity<VendorListDTO>(vendorService.getAllVendors(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendorDTO> createNewVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.createNewVendor(vendorDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.saveVendorById(id, vendorDTO),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VendorDTO> patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.patchVendor(id, vendorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteVendor(@PathVariable Long id){
        vendorService.deleteVendorById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
