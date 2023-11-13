package GfvCorp.Repository.Record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RrequestClient(
        @NotBlank String name,
        String cpf,
        String cnh,
        @NotBlank String email,
        @NotBlank String password
) { }