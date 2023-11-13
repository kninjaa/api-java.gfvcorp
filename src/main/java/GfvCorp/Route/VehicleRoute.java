package GfvCorp.Route;

import GfvCorp.Model.Client;
import GfvCorp.Model.Operator.Brand;
import GfvCorp.Model.Vehicle;
import GfvCorp.Repository.Interface.Iclient;
import GfvCorp.Repository.Interface.Ivehicle;
import GfvCorp.Repository.Interface.Operator.Ibrand;
import GfvCorp.Repository.Record.RresponseVehicle;
import GfvCorp.Repository.Record.RresquestVehicle;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleRoute {
    @Autowired
    private Ivehicle ivehicle;

    @Autowired
    private Iclient iclient;

    @Autowired
    private Ibrand ibrand;

    @GetMapping
    public ResponseEntity GetVehicle(@RequestParam(name = "client", required = false) Client client){
        if (client != null){
            List<Vehicle> vehicles = ivehicle.findByClient(client);
            return ResponseEntity.ok(vehicles);
        }else{
            var vehicle = ivehicle.findAll();
            return ResponseEntity.ok(vehicle);
        }
    }

    @PostMapping
    public ResponseEntity<?> RegisterVehicle(@RequestBody @Valid RresquestVehicle data){
        String plate = data.plate();
        List<Vehicle> existingPlacas = ivehicle.findByPlate(plate);
        if (!existingPlacas.isEmpty()){
            String errorMessage = "Já existe uma Placa registrada: ";
            if (existingPlacas.stream().anyMatch(client -> client.getPlate().equals(plate))) {
                errorMessage += existingPlacas +".";
            }
            errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Optional<Client> optionalClient = iclient.findById(String.valueOf(data.client()));
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            if (client.isSituation()){
                Brand model = ibrand.findByModel(data.model());
                if(model != null){
                    Vehicle newVehicle = new Vehicle(data, client);
                    newVehicle.setModification(data.modification());
                    newVehicle.setBlindage(data.blindage());
                    newVehicle.setCharge(data.charge());
                    newVehicle.setModel(model);
                    ivehicle.save(newVehicle);

                    return ResponseEntity.ok().build();
                }else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Marca ou modelo não encontrada.");
                }
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não esta com o plano ativo.");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado.");
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> UpdateVehicle(@RequestBody @Valid RresponseVehicle upData){
        Optional<Vehicle> optionalVehicle = ivehicle.findById(String.valueOf(upData.id()));

        if (optionalVehicle.isPresent()){
            Brand model = ibrand.findByModel(upData.model());

            if (model == null) {
                Vehicle upVehicle = optionalVehicle.get();
                String client = String.valueOf(upVehicle.getClient().getId());

                if (upVehicle.getClient().getId() == upData.client()){
                    if (upData.weight() > 0 && upData.quantityAxes() > -1) {
                        upVehicle.setModification(upData.modification());
                        upVehicle.setBlindage(upData.blindage());
                        upVehicle.setCharge(upData.charge());
                        upVehicle.UpVehicle(upData);

                        return ResponseEntity.ok("Atualizado!");
                    }else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alteração invalida!");
                    }
                }else {
                    throw new EntityNotFoundException("Id do cliente não coencide");
                }
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Para alterar o modelo do veiculo, precisa criar um novo veiculo");
            }
        }else {
            throw new EntityNotFoundException("Id não selecionado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DelVehicle(@PathVariable int id){
        ivehicle.deleteById(String.valueOf(id));

        return ResponseEntity.noContent().build();
    }
}