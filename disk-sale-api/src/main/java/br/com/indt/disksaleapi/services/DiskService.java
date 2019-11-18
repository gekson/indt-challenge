package br.com.indt.disksaleapi.services;

import br.com.indt.disksaleapi.exception.ResourceNotFoundException;
import br.com.indt.disksaleapi.model.Disk;

import java.util.List;

public interface DiskService {

    List<Disk> listAll();

    Disk getById(String id) throws ResourceNotFoundException;

    Disk saveOrUpdate(Disk disk);

    void delete(String id);
}
