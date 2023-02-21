package guru.springframework.services;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.domain.Vendor;

public interface VendorService {
    VendorDTO getVendorById(Long id);
    VendorListDTO getAllVendors();
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO saveAndReturnDTO(Vendor vendor);
    VendorDTO saveVendorById(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
