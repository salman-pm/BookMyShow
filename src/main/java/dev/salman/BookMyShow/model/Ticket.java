package dev.salman.BookMyShow.model;

import dev.salman.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    private double totalAmount;
    private LocalDateTime bookingTime;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
