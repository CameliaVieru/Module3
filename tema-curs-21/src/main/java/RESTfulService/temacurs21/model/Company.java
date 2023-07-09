package RESTfulService.temacurs21.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;
}
