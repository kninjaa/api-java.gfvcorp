package GfvCorp.Model.Operator.Error;

// region Import's
import jakarta.persistence.*;
import lombok.*;
import java.sql.*;
// endregion

@Entity
@Table(name = "TBERRLOG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ErrLogJava {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ERR_INT_ID")
    private int id;

    @Column(name = "ERR_DAT_DATAHORA")
    private Timestamp data;

    @Column(name = "ERR_STR_MSG")
    private String msgErr;

    @Lob
    @Column(name = "ERR_CLOB_STACKTRACE")
    private Clob stackTrace;
}
