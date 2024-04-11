package hotelsystem.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Each booking has a customer and a room (?)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer; 

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @OneToMany(mappedBy = "booking")
    private List<ProvidedServices> providedServices;

    //Constructor
    public Booking() {
    	this.providedServices = new ArrayList<ProvidedServices>();
    }
    
    //Parameterized constructor
    public Booking(Customer customer, Date date, Room room) {
        this.customer = customer;
        this.date = date;
        this.room = room;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getDate() {
    	return date;
    }
    
    public void setDate(Date date) {
    	this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //toString
	@Override
	public String toString() {
		return "Booking [id=" + id + ", customer=" + customer + ", room=" + room + "]";
	}
}