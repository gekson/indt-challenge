package br.com.indt.disksaleapi.controllers;

import br.com.indt.disksaleapi.model.Sale;
import br.com.indt.disksaleapi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SaleController {

    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sales")
    public List<Sale> getAllDisks() {
        return saleService.listAll();
    }

    @PostMapping("/sales")
    public Sale createSale(@Valid @RequestBody Sale sale) {
        return saleService.saveOrUpdate(sale);
    }
}
