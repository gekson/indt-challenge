package br.com.indt.disksaleapi.services;

import br.com.indt.disksaleapi.model.Sale;

import java.util.List;

public interface SaleService {

    List<Sale> listAll();

    Sale saveOrUpdate(Sale sale);
}
