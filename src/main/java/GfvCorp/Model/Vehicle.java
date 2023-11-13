package GfvCorp.Model;

import GfvCorp.Model.Operator.Brand;
import GfvCorp.Repository.Record.RresponseVehicle;
import GfvCorp.Repository.Record.RresquestVehicle;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/*[TBVEICULO]({@docRoot}/src/main/resources/db/migration/)*/
/**
 * {@summary Classe que representa a entity de <b>Ve\u00EDculo</b>.<br>}
 * <b>Tabela Oracle database referente</b>: <a href="{@docRoot}/src/main/resouces/db/migration/"><b>TBVEICULO</b></a> <br>
 * <b>Route referente</b>: {@link GfvCorp.Route.VehicleRoute} <br>
 * <b>Repository Interface referente</b>: {@link GfvCorp.Repository.Interface.Ivehicle} <br>
 * <b>Repository record request(salvar no banco) referente</b>: {@link GfvCorp.Repository.Record.RresquestVehicle} <br>
 * <b>Repository record response(atualizar no banco) referente</b>: {@link GfvCorp.Repository.Record.RresponseVehicle} <br> <br>
 *
 * <b>Body para Json em ferramentas de teste de API:</b>
 * <ul>
 *  <li>"plate":</li>
 *  <li>"size":</li>
 *  <li>"weight":</li>
 *  <li>"quantityAxes":</li>
 *  <li>"modification":</li>
 *  <li>"blindage":</li>
 *  <li>"model":</li>
 *  <li>"charge":</li>
 *  <li>"client":</li>
 * </ul>
 * <br>
 *
 * @see GfvCorp.Route.VehicleRoute
 * @see GfvCorp.Repository.Interface.Ivehicle
 * @see GfvCorp.Repository.Record.RresquestVehicle
 * @see GfvCorp.Repository.Record.RresponseVehicle
 */
@Entity
@Table(name = "TBVEICULO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "vehicles"})
public class Vehicle {
    /**
     * {@summary ID \u00FAnico para cada ve\u00EDculo (<b>campo obrigat\u00F3rio ao atualizar o cadastro<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Integer}(int)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_INT_ID</a>
     * <br>
     * O id \u00E9 gerado automaticamente.
     * <br>
     * Se um ve\u00EDculo for deletado, o mesmo ID <b>n\u00E3o ser\u00E1</b> usado para um novo ve\u00EDculo.
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VC_INT_ID")
    private int id;


    /**
     * {@summary Placa do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_STR_PLACA</a>
     * <br>
     * Valor \u00FAnico para cada ve\u00EDculo, se refere a placa do ve\u00EDculo.
     */
    @Column(name = "VC_STR_PLACA")
    private String plate;


    /**
     * {@summary tamanho do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Integer}(int)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_STR_PLACA</a>
     * <br>
     * Tamanho aproximado do ve\u00EDculo.
     */
    @Column(name = "VC_STR_TAMANHO")
    private int size;


    /**
     * {@summary Peso do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Float}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_INT_PESO</a>
     * <br>
     * Peso aproximado do ve\u00EDculo em KG.
     */
    @Column(name = "VC_INT_PESO")
    private Float weight;


    /**
     * {@summary Quantidade de eixos do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Integer}(int)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_INT_QTDEIX</a>
     * <br>
     * Número de eixos do ve\u00EDculo.
     */
    @Column(name = "VC_INT_QTDEIX")
    private int quantityAxes;


    /**
     * {@summary Indica se o ve\u00EDculo possui alguma modificação (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Boolean}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_BOOL_MOD</a>
     * <br>
     * Valor booleano indicando se o ve\u00EDculo sofreu alguma modificação.
     */
    @Column(name = "VC_BOOL_MOD")
    private boolean modification;


    /**
     * {@summary Indica se o ve\u00EDculo possui blindagem (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Boolean}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_BOOL_BLINDAGEM</a>
     * <br>
     * Valor booleano indicando se o ve\u00EDculo possui blindagem.
     */
    @Column(name = "VC_BOOL_BLINDAGEM")
    private boolean blindage;


    /**
     * {@summary Indica se o ve\u00EDculo tem carga (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Boolean}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_BOOL_CARGA</a>
     * <br>
     * Valor booleano indicando se o ve\u00EDculo tem carga.
     */
    @Column(name = "VC_BOOL_CARGA")
    private boolean charge;


    /**
     * {@summary Marca do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link GfvCorp.Model.Operator.Brand}
     * <br>
     * <b>Tipo de mapeamente:</b> Um para um(One to One - 1:1)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">MC_STR_MODELO</a>
     * <br>
     * Identificador de qual o modelo é o ve\u00EDculo, ao especificar, j\u00E1 puxa a marca automaticamente.
     */
    @OneToOne
    @JoinColumn(name = "MC_STR_MODELO", referencedColumnName = "MC_STR_MODELO")
    private Brand model;


    /**
     * {@summary Mapeamento para associar o cliente (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link GfvCorp.Model.Client}
     * <br>
     * <b>Tipo de mapeamente:</b> Muitos para um(Many to One - N:1)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_INT_ID</a>
     * <br>
     * Faz um mapeamento para relacionar o ve\u00EDculo ao cliente, um cliente pode ter v\u00E1rios ve\u00EDculo.
     */
    @ManyToOne
    @JoinColumn(name = "CT_INT_ID")
    @NotNull(message = "Cliente is obrigatório")
    private Client client;


    /**
     * {@summary Marca do ve\u00EDculo (<b>Campo obrigat\u00F3rio ao cadastrar ve\u00EDculo<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link GfvCorp.Model.Protocol}
     * <br>
     * <b>Tipo de mapeamente:</b> Um para muitos(OneToMany - 1:N)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">MC_STR_MODELO</a>
     * <br>
     * Faz um mapeamento para relacionar ve\u00EDculo aos protocolos, um ve\u00EDculo pode ter v\u00E1rios protocolos.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Protocol> protocols;


    /**
     * Construtor para mapear um objeto RresquestVehicle para um objeto Vehicle.
     *
     * @param rResquestVehicle Objeto RresquestVehicle
     * @param client Cliente associado ao veículo
     */
    public Vehicle (RresquestVehicle rResquestVehicle, Client client){
        this.plate = rResquestVehicle.plate();
        this.size = rResquestVehicle.size();
        this.weight = Float.valueOf(rResquestVehicle.weight());
        this.quantityAxes = rResquestVehicle.quantityAxes();
        this.modification = rResquestVehicle.modification();
        this.blindage = rResquestVehicle.blindage();
        this.charge = rResquestVehicle.charge();
        this.model = new Brand();
        this.client = client;
    }


    /**
     * Método para atualizar um veículo com base no objeto RresponseVehicle.
     *
     * @param rResponseVehicle Objeto RresponseVehicle
     * @return Objeto Vehicle atualizado
     */
    public Vehicle UpVehicle (RresponseVehicle rResponseVehicle){
        Vehicle vehicle = new Vehicle();
        if (rResponseVehicle.plate() != null) this.plate = rResponseVehicle.plate();
        if (rResponseVehicle.size() != 0) this.size = rResponseVehicle.size();
        if (rResponseVehicle.weight() != -1) this.weight = rResponseVehicle.weight();
        if (rResponseVehicle.quantityAxes() != -1) this.quantityAxes = rResponseVehicle.quantityAxes();
        this.modification = rResponseVehicle.modification();
        this.blindage = rResponseVehicle.blindage();
        this.charge = rResponseVehicle.charge();

        return vehicle;
    }
}
