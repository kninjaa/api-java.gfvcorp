package GfvCorp.Model;

import GfvCorp.Model.Operator.TypeTow;
import GfvCorp.Repository.Record.RrequestModal;
import GfvCorp.Service.Controller.ViaCEP;
import GfvCorp.Service.Domain.Local;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbMODAL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Modal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MD_INT_ID")
    private int id;

    @Column(name = "MD_STR_MODAL")
    private String Modal;

    @Column(name = "MD_STR_LOC")
    private String location;

    @OneToOne
    @JoinColumn(name = "MG_STR_TIPO", referencedColumnName = "MG_STR_TIPO")
    private TypeTow typeTow;

    @ManyToOne
    @JoinColumn(name = "PROT_INT_ID")
    private Protocol protocol;

    @ManyToOne
    @JoinColumn(name = "VC_INT_ID")
    private Vehicle vehicle;

    public Modal (RrequestModal rRequestModal, Protocol protocol, Client client, Vehicle vehicle, Local local){
        this.Modal = rRequestModal.modal();
        //this.location = rRequestModal.location();
        this.typeTow = new TypeTow();
        this.protocol = protocol;
        this.vehicle = vehicle;

        ViaCEP viaCep = local.getAddress(rRequestModal.location());
        this.location = viaCep != null ?
                String.format("%s, %s, %s, %s", viaCep.getCep(), viaCep.getLogradouro(), viaCep.getBairro(),
                        viaCep.getLocalidade(), viaCep.getUf()) : rRequestModal.location();
    }
}
