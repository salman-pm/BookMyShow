package dev.salman.BookMyShow.controller;

import dev.salman.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @GetMapping("/greet")
    public ResponseEntity greet(){
        String result = ticketService.greet();
        return ResponseEntity.ok(result);
    }
}
