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
    private String startDate;
    private String endDate;
    
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

    public Booking(Customer customer, Room room, String startDate, String endDate) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<ProvidedServices> getProvidedServices() {
        return providedServices;
    }

    public void setProvidedServices(List<ProvidedServices> providedServices) {
        this.providedServices = providedServices;
    }

    @Override
    public String toString() {
        return "Booking [startDate=" + startDate + ", endDate=" + endDate + ", customer=" + customer + ", room=" + room
                + ", providedServices=" + providedServices + "]";
    }
}