package hotelsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROVIDEDSERVICE")
public class ProvidedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "PROVIDEDSERVICE_ID")
    private Booking booking;

    //Constructor
    public ProvidedServices() {}
    
    //Parameterized constructor
    public ProvidedServices(String name, String description, Double price) {
    	this.name = name;
    	this.description = description;
    	this.price = price;
    }

    // Setters, getters, and tostring
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "ProvidedServices [name=" + name + ", description=" + description + ", price=" + price + ", booking="
				+ booking + "]";
	}
}