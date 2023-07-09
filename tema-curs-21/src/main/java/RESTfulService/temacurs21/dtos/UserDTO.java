package RESTfulService.temacurs21.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name must have at least one character")
    private String name;
    @NotNull(message = "User name cannot be null")
    @NotBlank(message = "User name must have at least one character")
    private String username;
    @Email(message = "Email wrong format")
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
}

