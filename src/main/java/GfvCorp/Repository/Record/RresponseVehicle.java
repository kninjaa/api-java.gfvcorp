package GfvCorp.Repository.Record;

import GfvCorp.Model.Vehicle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record RresponseVehicle(
        @NotNull int id,
        @NotNull int client,
        String plate,
        int size,
        Float weight,
        int quantityAxes,
        boolean modification,
        boolean blindage,
        boolean charge,
        String model
) {
    public RresponseVehicle(Vehicle vehicle){
        this(
            vehicle.getClient().getId(),
            vehicle.getId(),
            vehicle.getPlate(),
            vehicle.getSize(),
            vehicle.getWeight(),
            vehicle.getQuantityAxes(),
            vehicle.isModification(),
            vehicle.isBlindage(),
            vehicle.isCharge(),
            vehicle.getModel().getModel()
        );
    }
}