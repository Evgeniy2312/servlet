package by.Matveev.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private String street;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    private boolean isPrimary;

    public Address(long id, int number, String street, User user, boolean isPrimary) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.user = user;
        this.isPrimary = isPrimary;
    }

    public Address(boolean isPrimary, int number, String street, User user) {
        this.isPrimary = isPrimary;
        this.number = number;
        this.street = street;
        this.user = user;
    }

    public Address(long id, int number, String street, User user) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.user = user;
    }

    public Address(int number, String street, User user) {
        this.number = number;
        this.street = street;
        this.user = user;
    }

    public Address(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Address() {
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(user, address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
