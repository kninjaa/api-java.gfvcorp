package GfvCorp.Repository.Interface.Operator;

import GfvCorp.Model.Operator.TypeTow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItypeTow extends JpaRepository<TypeTow, String> {
    TypeTow findByTypeTow(String typeTow);
}
