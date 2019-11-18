package br.com.indt.disksaleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document(collection = "roles")
public class Role {

    @Id
    private String id;
    private String role;
}
