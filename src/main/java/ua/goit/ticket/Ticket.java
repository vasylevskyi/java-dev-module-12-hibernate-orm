package ua.goit.ticket;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private java.time.ZonedDateTime createdAt;

    @Column
    private long clientId;

    @Column
    private String fromPlanetId;

    @Column
    private String toPlanetId;
}