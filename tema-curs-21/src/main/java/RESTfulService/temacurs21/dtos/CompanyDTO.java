package RESTfulService.temacurs21.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CompanyDTO {
    private Long id;
    @NotNull(message = "Company name cannot be null!")
    @NotBlank(message = "Company name must have at least one character!")
    private String name;
    private String catchPhrase;
    private String bs;
}
