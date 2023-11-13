package GfvCorp.Model.Operator.Error;

// region Import's
import jakarta.persistence.*;
import lombok.*;
import java.sql.*;
// endregion

@Entity
@Table(name = "TBERRLOGPY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ErrLogPy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ERRP_INT_ID")
    private int id;

    @Column(name = "ERRP_DAT_DATAHORA")
    private Timestamp data;

    @Column(name = "ERRP_STR_MSG")
    private String msgErr;

    @Lob
    @Column(name = "ERRP_CLOB_STACKTRACE")
    private Clob stackTrace;
}
