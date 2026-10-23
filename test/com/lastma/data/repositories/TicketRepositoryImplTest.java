package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class TicketRepositoryImplTest {


    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();

    }

    @Test
    public void testThatWhenISaveOneTicketItIsSavedAsCountOne() {
        assertEquals(0L, ticketRepository.count());
        Ticket ticket = new Ticket();
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }


    @Test
    public void testThatWhenISaveTicket_IdIsSet() {
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(1, savedTicket.getId());

    }

    @Test
    public void testThatWhenIFindById_TicketIsFound() {
        Ticket savedTicket = ticketRepository.save(ticket);
        int ticketId = savedTicket.getId();
        assertEquals(savedTicket, ticketRepository.findById(ticketId));
    }

    @Test
    public void testThatWhenIFindByInvalidId_ErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findById(-1));
    }


    @Test
    public void testThatWhenIFindAll_AllTicketAreFound() {
        Ticket ticketTwo = new Ticket();
       Ticket ticketThree = new Ticket();
       Ticket[] allTickets= {ticket, ticketTwo, ticketThree};
        for (Ticket t : allTickets) {
            ticketRepository.save(t);
        }

        List<Ticket> foundTickets = ticketRepository.findAll();
        assertEquals(3, foundTickets.size());
        for (int count = 0; count < allTickets.length; count++) {
            assertEquals(allTickets
                    [count], foundTickets.get(count));
        }
    }

    @Test
    public void testThatWhenIFindAllAndNoOfficerIsSaved_ErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findAll());
    }


    @Test
    public void testThatWhenIDeleteOfficer_officerIsDeleted() {
        Ticket savedTicket = ticketRepository.save(ticket);
        int ticketId = savedTicket.getId();
        assertEquals(1L, ticketRepository.count());

        ticketRepository.delete(ticketId);

        assertEquals(0L, ticketRepository.count());
    }
}












