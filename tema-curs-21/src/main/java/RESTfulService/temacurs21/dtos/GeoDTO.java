package RESTfulService.temacurs21.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoDTO {
    private Long id;
    private String lat;
    private String lng;
}

