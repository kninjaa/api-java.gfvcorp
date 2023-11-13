package GfvCorp.Model.Operator.Error;

// region Import's
import jakarta.persistence.*;
import lombok.*;
import java.sql.*;
// endregion

@Entity
@Table(name = "TBERRLOGAPI")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ErrLogApi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ERRA_INT_ID")
    private int id;

    @Column(name = "ERRA_DAT_DATAHORA")
    private Timestamp data;

    @Column(name = "ERRA_STR_MSG")
    private String msgErr;

    @Lob
    @Column(name = "ERRA_CLOB_STACKTRACE")
    private Clob stackTrace;
}
