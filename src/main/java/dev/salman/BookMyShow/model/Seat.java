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
    private int seatColNUmber;
    private String seatNUmber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
