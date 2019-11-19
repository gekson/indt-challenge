package br.com.indt.disksaleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sales")
public class Sale {

    @Id
    private String id;
    private Disk disk;
    private int quantity;
}
