package application1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class Motor {
    @Getter
    @Setter
    private int putere;
    @Getter
    @Setter
    private String nume;
    @Getter
    @Setter
    private int numarCilindri;

}
