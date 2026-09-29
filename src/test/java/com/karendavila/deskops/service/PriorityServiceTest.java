package com.karendavila.deskops.service;

import com.karendavila.deskops.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityServiceTest {

    @Test
    void calculatesPriorityCorrectly() {

        // Creates a ticket with a known expected priority score
        Ticket ticket = new Ticket(
                "VPN Connection Failure",
                "VPN disconnects immediately after authentication.",
                15,
                Urgency.HIGH,
                TicketType.INCIDENT,
                AffectedSystem.VPN,
                Department.FINANCE
        );

        PriorityService priorityService = new PriorityService();

        int score = priorityService.calculatePriority(ticket);

        // HIGH(30) + 15 users(15) + VPN(10) + INCIDENT(10) = 65
        assertEquals(65, score);
    }
}