package GfvCorp.Route;

import GfvCorp.Model.Client;
import GfvCorp.Repository.Interface.Iclient;
import GfvCorp.Repository.Record.RrequestClient;
import GfvCorp.Repository.Record.RresponseClient;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientRoute {
    @Autowired
    private Iclient iclient;

    @GetMapping
    public ResponseEntity GetClient(@RequestParam(name = "cpf", required = false) String cpf) {
        if (cpf != null) {
            List<Client> client = iclient.findByCpf(cpf);
            return ResponseEntity.ok(client);
        } else {
            List<Client> allClients = iclient.findAll();
            return ResponseEntity.ok(allClients);
        }
    }

    @PostMapping
    public ResponseEntity RegisterClient(@RequestBody @Valid RrequestClient data) {
        String cpf = data.cpf();
        String cnh = data.cnh();
        String email = data.email();

        List<Client> existingClients = iclient.findByCpfOrCnhOrEmail(cpf, cnh, email);
        if (!existingClients.isEmpty()) {
            String errorMessage = "Já existe um cliente registrado com os seguintes campos duplicados: ";
            if (existingClients.stream().anyMatch(client -> client.getCpf().equals(cpf))) {
                errorMessage += "CPF, ";
            }
            if (existingClients.stream().anyMatch(client -> client.getCnh().equals(cnh))) {
                errorMessage += "CNH, ";
            }
            if (existingClients.stream().anyMatch(client -> client.getEmail().equals(email))) {
                errorMessage += "EMAIL, ";
            }
            errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        Client newClient = new Client(data);
        iclient.save(newClient);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    @Transactional
    public ResponseEntity UpdateClient(@RequestBody @Valid RresponseClient upData){
        Optional<Client> OptionalClient = iclient.findById(String.valueOf(upData.id()));
        if (OptionalClient.isPresent()) {
            Client UpClient = OptionalClient.get();
            if (UpClient.isSituation()){
                UpClient.UpClient(upData);

                return ResponseEntity.ok(UpClient);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente inativo.");
            }
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DelClient(@PathVariable int id){
        iclient.deleteById(String.valueOf(id));

        return ResponseEntity.noContent().build();
    }
}