package GfvCorp.Repository.Interface.Operator;

import GfvCorp.Model.Operator.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Ibrand extends JpaRepository<Brand, String> {
    List<Brand> findByBrand(String brand);
    Brand findByModel(String model);
}
