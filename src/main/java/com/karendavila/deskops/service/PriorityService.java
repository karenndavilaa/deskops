package com.karendavila.deskops.service;

import com.karendavila.deskops.model.*;

public class PriorityService {

    // Calculates a priority score from 0-100 based on ticket information
    public int calculatePriority(Ticket ticket) {

        // Prevents priority calculation without a valid ticket
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket is required.");
        }

        int score = 0;

        // Urgency contributes up to 40 points
        score += switch (ticket.getUrgency()) {
            case LOW -> 10;
            case MEDIUM -> 20;
            case HIGH -> 30;
            case CRITICAL -> 40;
        };

        // Number of affected users contributes up to 30 points
        int affectedUsers = ticket.getAffectedUsers();

        if (affectedUsers == 1) {
            score += 5;
        } else if (affectedUsers <= 10) {
            score += 10;
        } else if (affectedUsers <= 50) {
            score += 15;
        } else if (affectedUsers <= 200) {
            score += 20;
        } else if (affectedUsers <= 500) {
            score += 25;
        } else {
            score += 30;
        }

        // Critical systems contribute up to 20 points
        score += switch (ticket.getAffectedSystem()) {
            case SECURITY, MES, MCS -> 20;
            case SAP, NETWORK -> 15;
            case VPN -> 10;
            case PRINTING, HARDWARE, OTHER -> 5;
        };

        // Incidents receive more weight because an existing service is disrupted
        score += switch (ticket.getTicketType()) {
            case INCIDENT -> 10;
            case ACCESS_REQUEST, SERVICE_REQUEST -> 5;
        };

        return score;


    }

    // Converts the numeric score into a priority level
    public Priority determinePriority(Ticket ticket) {

        int score = calculatePriority(ticket);

        if (score >= 80) {
            return Priority.CRITICAL;
        } else if (score >= 60) {
            return Priority.HIGH;
        } else if (score >= 40) {
            return Priority.MEDIUM;
        } else {
            return Priority.LOW;
        }
    }

}