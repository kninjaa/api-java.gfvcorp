package GfvCorp.Repository.Interface;

import GfvCorp.Model.Client;
import GfvCorp.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Ivehicle extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByClient(Client client);
    List<Vehicle> findByPlate(String plate);
}