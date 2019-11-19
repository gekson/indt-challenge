package br.com.indt.disksaleapi.services;

import br.com.indt.disksaleapi.model.Sale;
import br.com.indt.disksaleapi.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> listAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale saveOrUpdate(Sale sale) {
        saleRepository.save(sale);
        return sale;
    }
}
