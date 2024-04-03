package hotelsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProvidedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ProvidedServices() {}

    public ProvidedServices() {
        //TODO
    }

    //Getters and setters
    //TODO
}