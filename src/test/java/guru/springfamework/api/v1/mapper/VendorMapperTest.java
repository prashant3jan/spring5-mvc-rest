package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorMapperTest {
    VendorMapper vendorMapper = VendorMapper.INSTANCE;
    public static final String NAME = "SomeName";

    @Test
    public void vendorToVendorDTO() {
        //given
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setName(NAME);
        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
        //then
        assertEquals(vendor.getName(), vendorDTO.getName());
    }

    @Test
    public void vendorDTOToVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();

        //when
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        //then
        assertEquals(vendorDTO.getName(),vendor.getName());

    }
}