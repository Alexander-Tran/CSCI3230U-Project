package hotelsystem.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private double price;
    
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    //Constructor
    public Room() {
    	this.bookings = new ArrayList<Booking>();
    } 

    //Parameterized constructor
    public Room(int number, double price) { 
        this.number = number;
        this.price = price;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString
	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", price=" + price + "]";
	}
}