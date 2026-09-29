package org.example;
import com.karendavila.deskops.model.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Creates a test ticket to verify that the Ticket class works correctly
        Ticket ticket = new Ticket(
                "VPN Connection Failure",
                "VPN disconnects immediately after authentication.",
                15,
                Urgency.HIGH,
                TicketType.INCIDENT,
                AffectedSystem.VPN,
                Department.FINANCE
        );

        // Prints ticket information using getters
        System.out.println("Title: " + ticket.getTitle());
        System.out.println("Description: " + ticket.getDescription());
        System.out.println("Affected Users: " + ticket.getAffectedUsers());
        System.out.println("Urgency: " + ticket.getUrgency());
        System.out.println("Ticket Type: " + ticket.getTicketType());
        System.out.println("Affected System: " + ticket.getAffectedSystem());
        System.out.println("Department: " + ticket.getDepartment());
        System.out.println("Status: " + ticket.getTicketStatus());
        System.out.println("Created At: " + ticket.getCreatedAt());

    }
}