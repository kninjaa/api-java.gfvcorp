package GfvCorp.Route;

import GfvCorp.Model.Client;
import GfvCorp.Model.Modal;
import GfvCorp.Model.Operator.TypeTow;
import GfvCorp.Model.Protocol;
import GfvCorp.Model.Vehicle;
import GfvCorp.Repository.Interface.Iclient;
import GfvCorp.Repository.Interface.Imodal;
import GfvCorp.Repository.Interface.Iprotocol;
import GfvCorp.Repository.Interface.Ivehicle;
import GfvCorp.Repository.Interface.Operator.ItypeTow;
import GfvCorp.Repository.Record.RrequestModal;
import GfvCorp.Service.Controller.ViaCEP;
import GfvCorp.Service.Domain.Local;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/modal")
public class ModalRoute {
    @Autowired
    private Imodal imodal;

    @Autowired
    private Iprotocol iprotocol;

    @Autowired
    private Ivehicle ivehicle;

    @Autowired
    private Iclient iclient;

    @Autowired
    private ItypeTow itypeTow;

    @Autowired
    private Local local;

    @GetMapping
    public ResponseEntity GetModal(){
        var modal = imodal.findAll();
        return ResponseEntity.ok(modal);
    }

    @GetMapping("/{id}")
    public ResponseEntity GetModalId(@PathVariable int id){
        Optional<Modal> optionalModal = imodal.findById(String.valueOf(id));
        if (optionalModal.isPresent()){
            return ResponseEntity.ok(optionalModal);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Protocolo não encontrado.");
        }
    }

    @GetMapping("/{protocol}")
    public ResponseEntity GetModalByProtocolId(@PathVariable int protocol) {
        Optional<Protocol> optionalProtocol = iprotocol.findById(String.valueOf(protocol));
        if (optionalProtocol.isPresent()){
            return ResponseEntity.ok(optionalProtocol);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Protocolo não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity RegisterModal(@RequestBody @Valid RrequestModal data){
        Optional<Protocol> optionalProtocol = iprotocol.findById(String.valueOf(data.protocol()));
        Optional<Client> optionalClient = iclient.findById(String.valueOf(data.client()));
        Optional<Vehicle> optionalVehicle = ivehicle.findById(String.valueOf(data.vehicle()));

        if (optionalProtocol.isPresent() && optionalClient.isPresent() && optionalVehicle.isPresent()) {
            Client client = optionalClient.get();
            if (client.isSituation()){
                TypeTow typeTow = itypeTow.findByTypeTow(data.typeTow());
                if(typeTow != null){
                    Protocol protocol = optionalProtocol.get();
                    Vehicle vehicle = optionalVehicle.get();
                    Modal newModal = new Modal(data, protocol, client, vehicle, local);
                    newModal.setTypeTow(typeTow);
                    imodal.save(newModal);
                }else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Precisa especificar o tipo do modal.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não esta ativo.");
            }

            return ResponseEntity.ok().build();
        } else {
            String errorMessage = "Algo não foi encontrado: ";
            if (!optionalProtocol.isPresent()) errorMessage += "Protocolo ";
            if (!optionalVehicle.isPresent()) errorMessage += "Veículo ";
            if (!optionalClient.isPresent()) errorMessage += "Cliente ";

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.trim());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DelModal (@PathVariable int id){
        imodal.deleteById(String.valueOf(id));
        //criar validaçao para que delete so em um caso especifico
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }
}
