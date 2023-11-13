package GfvCorp.Model.Operator;

import GfvCorp.Model.Modal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBTIPOMODALGUINCHO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TypeTow {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MG_INT_ID")
    private int id;

    @Column(name = "MG_STR_TIPO")
    private String typeTow;

    @OneToOne(mappedBy = "typeTow", fetch = FetchType.EAGER)
    private Modal modal;
}
