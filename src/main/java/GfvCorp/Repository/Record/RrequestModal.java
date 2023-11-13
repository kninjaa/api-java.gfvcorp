package GfvCorp.Repository.Record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RrequestModal(
        @NotBlank String modal,
        @NotBlank String location,
        @NotBlank String typeTow,
        @NotNull int protocol,
        @NotNull int client,
        @NotNull int vehicle
) { }