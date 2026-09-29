package com.karendavila.deskops.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void validTicketStartsAsNew() {

        // Creates a valid ticket for testing
        Ticket ticket = new Ticket(
                "VPN Connection Failure",
                "VPN disconnects immediately after authentication.",
                15,
                Urgency.HIGH,
                TicketType.INCIDENT,
                AffectedSystem.VPN,
                Department.FINANCE
        );

        // Verifies that every new ticket starts with NEW status
        assertEquals(TicketStatus.NEW, ticket.getTicketStatus());
    }

    @Test
    void titleCannotBeBlank() {

        assertThrows(IllegalArgumentException.class, () ->
                new Ticket(
                        "",
                        "VPN disconnects after authentication.",
                        15,
                        Urgency.HIGH,
                        TicketType.INCIDENT,
                        AffectedSystem.VPN,
                        Department.FINANCE
                )
        );
    }

    @Test
    void descriptionCannotBeBlank() {

        assertThrows(IllegalArgumentException.class, () ->
                new Ticket(
                        "VPN Connection Failure",
                        "",
                        15,
                        Urgency.HIGH,
                        TicketType.INCIDENT,
                        AffectedSystem.VPN,
                        Department.FINANCE
                )
        );
    }

    @Test
    void requiredFieldsCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () ->
                new Ticket(
                        "VPN Connection Failure",
                        "VPN disconnects after authentication.",
                        15,
                        null,
                        TicketType.INCIDENT,
                        AffectedSystem.VPN,
                        Department.FINANCE
                )
        );
    }

    @Test
    void validTicketRecordsCreationTime() {

        Ticket ticket = new Ticket(
                "VPN Connection Failure",
                "VPN disconnects after authentication.",
                15,
                Urgency.HIGH,
                TicketType.INCIDENT,
                AffectedSystem.VPN,
                Department.FINANCE
        );

        assertNotNull(ticket.getCreatedAt());
    }
}