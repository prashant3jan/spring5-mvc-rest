package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    private Long id;
    @ApiModelProperty(value="name of the vendor", required = true)
    private String name;

    @JsonProperty("vendor_url")
    @ApiModelProperty(value = "url", required = true)
    private String vendorUrl;
}
