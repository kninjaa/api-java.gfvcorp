package GfvCorp.Repository.Record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RrequestProtocol(
        @NotBlank String protocol,
        @NotBlank Date dateTriggered,
        @NotNull int vehicle,
        @NotNull int client
) { }