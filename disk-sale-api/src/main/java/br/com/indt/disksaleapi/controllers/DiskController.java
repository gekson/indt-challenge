package br.com.indt.disksaleapi.controllers;

import br.com.indt.disksaleapi.exception.ResourceNotFoundException;
import br.com.indt.disksaleapi.model.Disk;
import br.com.indt.disksaleapi.services.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class DiskController {

    private DiskService diskService;

    @Autowired
    public DiskController(DiskService diskService) {
        this.diskService = diskService;
    }

    @GetMapping("/disks")
    public List<Disk> getAllDisks() {
        return diskService.listAll();
    }

    @GetMapping("/disks/{id}")
    public ResponseEntity<Disk> getDiskById(@PathVariable(value = "id") String diskId)
            throws ResourceNotFoundException {
        Disk disk = diskService.getById(diskId);
        return ResponseEntity.ok().body(disk);
    }

    @PostMapping("/disks")
    public Disk createDisk(@Valid @RequestBody Disk disk) {
        return diskService.saveOrUpdate(disk);
    }

    @PutMapping("/disks/{id}")
    public ResponseEntity<Disk> updateDisk(@PathVariable(value = "id") String diskId,
                                                   @Valid @RequestBody Disk diskDetails) throws ResourceNotFoundException {
        Disk disk = diskService.getById(diskId);

        disk.setName(diskDetails.getName());
        disk.setPrice(diskDetails.getPrice());

        final Disk updatedDisk = diskService.saveOrUpdate(disk);
        return ResponseEntity.ok(updatedDisk);
    }

    @DeleteMapping("/disks/{id}")
    public Map<String, Boolean> deleteDisk(@PathVariable(value = "id") String diskId)
            throws ResourceNotFoundException {
        Disk disk = diskService.getById(diskId);

        diskService.delete(disk.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
