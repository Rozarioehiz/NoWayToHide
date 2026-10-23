package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;

import java.util.List;

public interface TicketRepository {

     Ticket save (Ticket ticket);

     long count();

     Ticket findById(int id);


    List<Ticket> findAll();

     void delete(int ticketId);

    void deleteAll();

    boolean exitById(int ticketId);

    boolean existById(int id);



}
