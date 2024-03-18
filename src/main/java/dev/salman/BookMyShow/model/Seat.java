package dev.salman.BookMyShow.model;

import dev.salman.BookMyShow.model.constant.SeatStatus;
import dev.salman.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "BMS_SEAT")
public class Seat extends BaseModel{
    private int seatRowNumber;
    private int seatColNumber;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    public Seat(){

    }

    public Seat(int seatRowNumber, int seatColNUmber, String seatNUmber, SeatType seatType, SeatStatus seatStatus) {
        this.seatRowNumber = seatRowNumber;
        this.seatColNumber = seatColNUmber;
        this.seatNumber = seatNUmber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
