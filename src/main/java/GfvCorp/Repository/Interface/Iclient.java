package GfvCorp.Repository.Interface;

import GfvCorp.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Iclient extends JpaRepository<Client, String> {
    List<Client> findByCpf(String cpf);
    List<Client> findByCpfOrCnhOrEmail(String cpf, String cnh, String email);
}