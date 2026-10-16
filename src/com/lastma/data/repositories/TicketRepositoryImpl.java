package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public Ticket save(Ticket ticket) {
        ticket.setId(++idCounter);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public long count() {
        return tickets.size();
    }

    @Override
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        throw new IllegalArgumentException("Ticket with id " + id + " not found");
    }

    @Override
    public List<Ticket> findAll() {
        if (tickets.isEmpty()) throw new IllegalArgumentException("No ticket found");
        return tickets;
    }

    @Override
    public void delete(int id) {
        Ticket foundTicket = findById(id);
        tickets.remove(foundTicket);
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    @Override
    public boolean existById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return true;
            }
        }
        return false;
    }
}