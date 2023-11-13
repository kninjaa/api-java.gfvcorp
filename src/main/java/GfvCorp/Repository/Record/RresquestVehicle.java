package GfvCorp.Repository.Record;

import jakarta.validation.constraints.*;

public record RresquestVehicle(
        @NotBlank String plate,
        @NotBlank int size,
        @NotNull float weight,
        @NotNull int quantityAxes,
        @NotNull int client,
        @NotNull boolean modification,
        @NotNull boolean blindage,
        @NotNull boolean charge,
        @NotNull String model
){}