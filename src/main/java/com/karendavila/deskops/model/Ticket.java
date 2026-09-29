package com.karendavila.deskops.model;
import java.time.LocalDateTime;

public class Ticket {
    //stores main info about ticket
    private Long id;
    private String title;
    private String description;
    private int affectedUsers;
    private Urgency urgency;
    private TicketType ticketType;
    private AffectedSystem affectedSystem;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;
    private Department department;

    //creates a new ticket using the information submitted by user
    public Ticket(
            String title,
            String description,
            int affectedUsers,
            Urgency urgency,
            TicketType ticketType,
            AffectedSystem affectedSystem,
            Department department) {

                                    /* VALIDATION */

        // a ticket must affect at least one user
        if (affectedUsers < 1) {
            throw new IllegalArgumentException("Affected users must be at least 1.");
        }

        //prevent tickets from being created without a usable title
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be blank.");
        }

        //prevent title from being longer than 150
        if (title.length() > 150) {
            throw new IllegalArgumentException("Title cannot exceed 150 characters.");
        }

        //prevent tickets from being created without a usable description
        if (description == null || description.isBlank()){
            throw new IllegalArgumentException("Description cannot be blank.");
        }

        // prevent description from being longer than 1500
        if (description.length() > 1500) {
            throw new IllegalArgumentException("Description cannot exceed 1500 characters.");
        }

        //prevents urgency from being null
        if (urgency == null){
            throw new IllegalArgumentException("Urgency is required.");
        }

        //prevents ticketType from being null
        if (ticketType == null){
            throw new IllegalArgumentException("Ticket Type is required.");
        }

        //prevents affectedSystem from being null
        if (affectedSystem == null){
            throw new IllegalArgumentException("Affected System is required.");
        }

        //prevents department from being null
        if (department == null){
            throw new IllegalArgumentException("Department is required.");
        }

        // stores info
        this.title = title;
        this.description = description;
        this.affectedUsers = affectedUsers;
        this.urgency = urgency;
        this.ticketType = ticketType;
        this.affectedSystem = affectedSystem;
        this.department = department;
        this.ticketStatus = TicketStatus.NEW; // new tickets always start with a NEW status
        this.createdAt = LocalDateTime.now(); // records the date and time when the ticket is created
    }


                            /* GETTERS */

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getAffectedUsers(){
        return affectedUsers;
    }

    public Urgency getUrgency(){
        return urgency;
    }

    public TicketType getTicketType(){
        return ticketType;
    }

    public Long getId(){
        return id;
    }

    public AffectedSystem getAffectedSystem(){
        return affectedSystem;
    }

    public TicketStatus getTicketStatus(){
        return ticketStatus;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public Department getDepartment(){
        return department;
    }


}
