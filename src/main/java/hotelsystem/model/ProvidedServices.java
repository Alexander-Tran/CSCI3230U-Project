package hotelsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROVIDEDSERVICE")
public class ProvidedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Constructor
    public ProvidedServices() {}
    
    //Parameterized constructor
    public ProvidedServices(String name) {
    	this.name = name;
    }

    //Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//toString
	@Override
	public String toString() {
		return "ProvidedServices [id=" + id + ", name=" + name + "]";
	}
}