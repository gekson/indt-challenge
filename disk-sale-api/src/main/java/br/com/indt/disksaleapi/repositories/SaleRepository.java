package br.com.indt.disksaleapi.repositories;

import br.com.indt.disksaleapi.model.Disk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends MongoRepository<Disk, String> {
}
