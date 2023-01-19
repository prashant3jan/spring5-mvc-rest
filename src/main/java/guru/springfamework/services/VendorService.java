package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.domain.Vendor;

import java.util.List;

public interface VendorService {
    VendorDTO getVendorById(Long id);
    VendorListDTO getAllVendors();
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO saveAndReturnDTO(Vendor vendor);
    VendorDTO saveVendorById(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
