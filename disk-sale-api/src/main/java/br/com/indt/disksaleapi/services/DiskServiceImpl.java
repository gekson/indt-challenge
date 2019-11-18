package br.com.indt.disksaleapi.services;

import br.com.indt.disksaleapi.exception.ResourceNotFoundException;
import br.com.indt.disksaleapi.model.Disk;
import br.com.indt.disksaleapi.repositories.DiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiskServiceImpl implements DiskService{

    private DiskRepository diskRepository;

    @Autowired
    public DiskServiceImpl(DiskRepository diskRepository) {
        this.diskRepository = diskRepository;
    }

    @Override
    public List<Disk> listAll() {
        return diskRepository.findAll();
    }

    @Override
    public Disk getById(String id) throws ResourceNotFoundException {
        return diskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disk not found for this id :: " + id));
    }

    @Override
    public Disk saveOrUpdate(Disk disk) {
        diskRepository.save(disk);
        return disk;
    }

    @Override
    public void delete(String id) {
        diskRepository.deleteById(id);
    }
}
