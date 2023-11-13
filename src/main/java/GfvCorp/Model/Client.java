package GfvCorp.Model;

import GfvCorp.Repository.Record.RrequestClient;
import GfvCorp.Repository.Record.RresponseClient;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * {@summary Classe que representa a entity de <b>Cliente</b>.<br>}
 * <b>Tabela Oracle database referente</b>: <a href="{@docRoot}/src/main/resouces/db/migration/"><b>TBCLIENTE</b></a> <br>
 * <b>Route referente</b>: {@link GfvCorp.Route.ClientRoute} <br>
 * <b>Repository interface referente</b>: {@link GfvCorp.Repository.Interface.Iclient} <br>
 * <b>Repository record request(salvar no banco) referente</b>: {@link GfvCorp.Repository.Record.RrequestClient} <br>
 * <b>Repository record response(atualizar no banco) referente</b>: {@link GfvCorp.Repository.Record.RresponseClient} <br> <br>
 * <b>Body para Json em ferramentas de teste de API:</b>
 * <ul>
 *  <li>"name":</li>
 *  <li>"cpf":</li>
 *  <li>"cnh":</li>
 *  <li>"email":</li>
 *  <li>"password":</li>
 * </ul>
 * <br>
 */
@Entity
@Table(name = "TBCLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "vehicles"})
public class Client {
    /**
     * {@summary ID \u00FAnico para cada cliente (<b>campo obrigat\u00F3rio ao atualizar o cadastro<span style="color: red">*</span></b>).} <br>
     * <b>Tipo do field:</b> {@link Integer}(int)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_INT_ID</a>
     * <br>
     * O id \u00E9 gerado automaticamente.
     * <br>
     * Se um cliente for deletado, o mesmo ID <b>n\u00E3o ser\u00E1</b> usado para um novo cliente.
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CT_INT_ID")
    private int id;

    /**
     * {@summary Indica a situacao do plano se esta ativo ou inativo (<b>Campo obrigat\u00F3rio ao deletar<span style="color: red">*</span></b>).}<br>
     * <b>Tipo do field:</b> {@link Boolean}<br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_BOOL_ATIVO</a><br>
     * De padr\u00E3o vem como <b>"true"</b>, mas da para alterar no verbo http Put <br>
     * Se o plano do cliente n\u00E3o estiver inativo por X dias, poder\u00E1 apagar os dados apenas <b>se n\u00E3o estiver ativo</b>.
     */
    @Column(name = "CT_BOOL_SITUACAO")
    private boolean situation;


    /**
     * {@summary Nome do cliente (<b>Campo obrigat\u00F3rio ao cadastrar o cliente<span style="color: red">*</span></b>)}
     * <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_STR_NAME</a>
     * <br>
     * Nome civil do cliente.
     */
    @Column(name = "CT_STR_NAME")
    private String name;


    /**
     * {@summary CPF do cliente (<b>Campo obrigat\u00F3rio ao cadastrar o cliente<span style="color: red">*</span></b>).}
     * <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_STR_CPF</a>
     * <br>
     * O campo s\u00F3 se torna obrigat\u00F3rio se o campo <b>CNH</b> n\u00E3o for preenchido.
     * <br>
     * Aceita com os caracteres especiais ou sem, mas antes de enviar ao banco, verifica se h\u00E1 algum caractere especial e limpa, deixando apenas os n\u00FAmeros.
     * <br>
     * Faz uma verica\u00E7\u00E3o no banco se existe um valor igual, <b>se existir</b> um valor igual impede de cadastrar o cliente. Essa valida\u00E7\u00E3o \u00E9 do <b>Post method</b>.
     */
    @Column(name = "CT_STR_CPF")
    private String cpf;


    /**
     * {@summary CNH do cliente (<b>Campo obrigat\u00F3rio ao cadastrar o cliente<span style="color: red">*</span></b>).}
     * <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_STR_CNH</a>
     * <br>
     * O campo s\u00F3 se torna obrigat\u00F3rio se o campo <b>CPF</b> n\u00E3o for preenchido.
     * <br>
     * Aceita com os caracteres especiais ou sem, mas antes de enviar ao banco, verifica se h\u00E1 algum caractere especial e limpa, deixando apenas os n\u00FAmeros e letras (se houver).
     * <br>
     * Faz uma verica\u00E7\u00E3o no banco se existe um valor igual, <b>se existir</b> um valor igual impede de cadastrar o cliente. Essa valida\u00E7\u00E3o \u00E9 do <b>Post method</b>.
     */
    @Column(name = "CT_STR_CNH")
    private String cnh;


    /**{@summary Endere\u00E7o de e-mail do cliente (<b>Campo obrigat\u00F3rio ao cadastrar o cliente<span style="color: red">*</span></b>).}
     * <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_STR_EMAIL</a>
     * <br>
     * Aceita com os caracteres especiais, s\u00F3 salva se tiver.
     * <br>
     * Faz uma verica\u00E7\u00E3o no banco se existe um valor igual, <b>se existir</b> um valor igual impede de cadastrar o cliente. Essa valida\u00E7\u00E3o \u00E9 do <b>Post method</b>.
     */
    @Column(name = "CT_STR_EMAIL")
    private String email;


    /**{@summary Senha do cliente (<b>Campo obrigat\u00F3rio ao cadastrar o cliente.<span style="color: red">*</span></b>).}
     * <br>
     * <b>Tipo do field:</b> {@link String}
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">CT_STR_PASS</a>
     * <br>
     * Segue a pol\u00EDtica de senha de oito caracteres, contendo n\u00FAmeros, letras e caracteres especiais. <br>
     * Passa por uma valida\u00E7\u00E3o se respeita a pol\u00EDtica e \u00E9 salva no banco criptografada, usando o framework
     * <a href="https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCrypt.html"> BCrypt</a>.
     */
    @Column(name = "CT_STR_PASS")
    private String password;


    /**{@summary Lista de ve\u00EDculos do cliente (<b>Campo preenchido ap\u00F3s de cadastrar um ve\u00EDculo</b>).}
     * <br>
     * <b>Tipo do field:</b> {@link List}
     * <br>
     * <b>Tipo de mapeamente:</b> Um para muitos(OneToMany - 1:N)
     * <br>
     * <b>Coluna referente:</b> <a href="{@docRoot}/src/main/resouces/db/migration/">VC_INT_ID</a>
     * <br>
     * Mapeamento para listar todos os ve\u00EDculos do cliente, o minimo \u00E9 1.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;


    /**{@summary Lista os protocolos do cliente (<b>Campo preenchido ap\u00F3s criar o protocolo</b>).}
     * <br>
     * <b>Tipo do field:</b> {@link List}
     * <br>
     * <b>Tipo de mapeamente:</b> Um para muitos(OneToMany - 1:N)
     * <br>
     * <b>Tipo de mapeamente:</b> Muitos para um(Many to One - N:1)
     * <br>
     * Mapeamento para listar todos os protocolos do cliente.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Protocol> protocols;

    /**
     * Construtor da classe Client que recebe um objeto {@link GfvCorp.Repository.Record.RrequestClient} para adicionar um novo cliente.
     *<br>
     * @param rResquestClient Objeto contendo todas as informa\u00E7\u00F5es do cliente.
     */
    public Client(RrequestClient rResquestClient){
        this.situation = true;
        this.name = rResquestClient.name();
        this.cpf = rResquestClient.cpf();
        this.cnh = rResquestClient.cnh();
        this.email = rResquestClient.email();
        this.password = rResquestClient.password();
    }


    /**
     * M\u00E9todo que atualiza os campos do cliente com base em um objeto {@link GfvCorp.Repository.Record.RresponseClient}.
     *
     * @param rResponseClient Objeto contendo informa\u00E7\u00F5es atualizadas do cliente.
     * @return Um novo objeto Client com o(s) campo(s) atualizado(s).
     */
    public Client UpClient (RresponseClient rResponseClient){
        Client clientUp = new Client();
        this.situation = rResponseClient.situation();
        if (rResponseClient.name() != null) this.name = rResponseClient.name();
        if (rResponseClient.cpf() != null) this.cpf = rResponseClient.cpf();
        if (rResponseClient.cnh() != null) this.cnh = rResponseClient.cnh();
        if (rResponseClient.email() != null) this.email = rResponseClient.email();
        if (rResponseClient.password() != null) this.password = rResponseClient.password();

        return clientUp;
    }
}