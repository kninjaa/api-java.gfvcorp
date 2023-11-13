package GfvCorp.Model;

import GfvCorp.Repository.Record.RrequestProtocol;
import GfvCorp.Repository.Record.RresponseProtocol;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbPROTOCOLO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Protocol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROT_INT_ID")
    private int id;

    @Column(name = "PROT_STR_PROTOCOLO")
    private String protocol;

    @Column(name = "PROT_DAT_DATACIONADA")
    private Date dateTriggered;

    @ManyToOne
    @JoinColumn(name = "CT_INT_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "VC_INT_ID")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "protocol", fetch = FetchType.EAGER)
    private List<Modal> modals;

    public Protocol (RrequestProtocol rRequestProtocol, Vehicle vehicle){
        this.protocol = rRequestProtocol.protocol();
        this.dateTriggered = rRequestProtocol.dateTriggered();
        this.vehicle = vehicle;
    }

    public Protocol upProtocol (RresponseProtocol rResponseProtocol, Protocol protocol){
        if (rResponseProtocol.dateTriggered() != null) this.dateTriggered = rResponseProtocol.dateTriggered();
        return protocol;
    }
}