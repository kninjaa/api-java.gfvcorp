package GfvCorp.Model.Operator.Error;

// region Import's
import jakarta.persistence.*;
import lombok.*;
import java.sql.*;
// endregion

@Entity
@Table(name = "TBERRLOGWEB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ErrLogWeb {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ERRW_INT_ID")
    private int id;

    @Column(name = "ERRW_DAT_DATAHORA")
    private Timestamp data;

    @Column(name = "ERRW_STR_MSG")
    private String msgErr;

    @Lob
    @Column(name = "ERRW_CLOB_STACKTRACE")
    private Clob stackTrace;
}
