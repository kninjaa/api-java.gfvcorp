package GfvCorp.Route;

import GfvCorp.Model.Operator.Brand;
import GfvCorp.Repository.Interface.Operator.Ibrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brand")
public class BrandRoute {
    @Autowired
    private Ibrand ibrand;

    @GetMapping
    public ResponseEntity getAllBrands() {
        var brands = ibrand.findAll();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{brand}")
    public ResponseEntity getModelsByBrand(@PathVariable String brand) {
        List<Brand> brands = ibrand.findByBrand(brand);

        if (!brands.isEmpty()) {
            List<String> models = brands.stream().map(Brand::getModel).collect(Collectors.toList());
            return ResponseEntity.ok(models);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/brands")
    public ResponseEntity getAllBrandNames() {
        var brands = ibrand.findAll();
        List<String> brandNames = brands.stream().map(Brand::getBrand)
                .distinct().collect(Collectors.toList());
        return ResponseEntity.ok(brandNames);
    }
}