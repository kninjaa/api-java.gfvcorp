package GfvCorp.Model.Operator;

import GfvCorp.Model.Vehicle;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBMARCA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MC_INT_ID")
    private int id;

    @Column(name = "MC_INT_IDENTIFICADOR")
    private Integer identifier;

    @Column(name = "MC_STR_MARCA")
    private String brand;

    @Column(name = "MC_STR_MODELO")
    private String model;

    @OneToOne(mappedBy = "model", fetch = FetchType.EAGER)
    private Vehicle vehicle;
}
