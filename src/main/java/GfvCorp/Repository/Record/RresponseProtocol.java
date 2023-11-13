package GfvCorp.Repository.Record;

import GfvCorp.Model.Protocol;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RresponseProtocol(
        @NotNull int id,
        Date dateTriggered,
        @NotNull int vehicle,
        @NotNull int client
        ) {
    public RresponseProtocol(Protocol protocol){
        this(
            protocol.getId(),
            protocol.getDateTriggered(),
            protocol.getVehicle().getId(),
            protocol.getClient().getId()
        );
    }
}
