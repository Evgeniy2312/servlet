package by.Matveev.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "telephones")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long number;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    private boolean isPrimary;

    public Telephone(long id, long number, User user, boolean isPrimary) {
        this.id = id;
        this.number = number;
        this.user = user;
        this.isPrimary = isPrimary;
    }

    public Telephone(boolean isPrimary, long number, User user) {
        this.isPrimary = isPrimary;
        this.number = number;
        this.user = user;
    }

    public Telephone(long id, long number, User user) {
        this.id = id;
        this.number = number;
        this.user = user;
    }

    public Telephone(long number, User user) {
        this.number = number;
        this.user = user;
    }

    public Telephone() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return id == telephone.id && Objects.equals(user, telephone.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
