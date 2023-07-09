package RESTfulService.temacurs21.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "geos")
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lat;
    private String lng;


}