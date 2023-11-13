package GfvCorp.Route;

import GfvCorp.Model.Client;
import GfvCorp.Model.Protocol;
import GfvCorp.Model.Vehicle;
import GfvCorp.Repository.Interface.Iclient;
import GfvCorp.Repository.Interface.Imodal;
import GfvCorp.Repository.Interface.Iprotocol;
import GfvCorp.Repository.Interface.Ivehicle;
import GfvCorp.Repository.Record.RrequestProtocol;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/protocol")
public class ProtocolRoute {
    @Autowired
    private Iprotocol iprotocol;

    @Autowired
    private Ivehicle ivehicle;

    @Autowired
    private Imodal imodal;

    @Autowired
    private Iclient iclient;

    @GetMapping
    public ResponseEntity GetProtocol(){
        var protocol = iprotocol.findAll();
        return ResponseEntity.ok(protocol);
    }

    @PostMapping
    public ResponseEntity RegisterProtocol(@RequestBody @Valid RrequestProtocol data){
        Optional<Vehicle> optionalVehicle = ivehicle.findById(String.valueOf(data.vehicle()));
        Optional<Client> optionalClient = iclient.findById(String.valueOf(data.client()));
        if (optionalVehicle.isPresent() && optionalClient.isPresent()){
            Client upClient = optionalClient.get();
            if (upClient.isSituation()){
                Vehicle vehicle = optionalVehicle.get();
                Protocol newProtocol = new Protocol(data, vehicle);
                newProtocol.setClient(upClient);
                iprotocol.save(newProtocol);

                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente com plano inativo");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veiculo não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DelProtocol(@PathVariable int id){
        Optional<Client> OptionalClient = iclient.findById(String.valueOf(id));
        if (OptionalClient.isPresent()) {
            Client DelClientProt = OptionalClient.get();
            if (DelClientProt.isSituation()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Para exclusão de protocolos, o plano do cliente precisa esta inativo.");
            }else{
                iprotocol.deleteById(String.valueOf(id));
                return ResponseEntity.noContent().build();
            }
        }else {
            throw new EntityNotFoundException("Id não selecionado");
        }
    }
}