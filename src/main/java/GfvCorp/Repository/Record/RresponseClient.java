package GfvCorp.Repository.Record;

import GfvCorp.Model.Client;
import jakarta.validation.constraints.NotNull;

public record RresponseClient(
        @NotNull int id,
        @NotNull boolean situation,
        String name,
        String cpf,
        String cnh,
        String email,
        String password
) {
    public RresponseClient(Client client){
        this(
            client.getId(),
            client.isSituation(),
            client.getName(),
            client.getCpf(),
            client.getCnh(),
            client.getEmail(),
            client.getPassword()
        );
    }
}
