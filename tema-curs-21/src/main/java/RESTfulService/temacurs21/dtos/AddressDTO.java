package RESTfulService.temacurs21.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    @NotNull(message = "Street cannot be null!")
    @NotBlank(message = "Street must have at least one character")
    private String street;
    private String suite;
    @NotNull(message = "City cannot be null!")
    @NotBlank(message = "City must have at least one character")
    private String city;
    @NotNull(message = "Zipcode cannot be null!")
    @NotBlank(message = "Zipcode must have at least one character")
    private String zipcode;
    private GeoDTO geo;

}
