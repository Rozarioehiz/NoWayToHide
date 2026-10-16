package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketRepositoryImplTest {

    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();
    }

    @Test
    public void testThatICanSaveATicketAndItIsSavedAsCountOne() {
        assertEquals(0L, ticketRepository.count());
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoTicket_countIsTwo() {
        assertEquals(0L, ticketRepository.count());
        ticketRepository.save(new Ticket());
        ticketRepository.save(ticket);
        assertEquals(2L, ticketRepository.count());
    }

    @Test
    public void testThatWhenISaveTicket_idIsSet() {
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
    public void testThatWhenIFindByInvalidId_errorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findById(-1));
    }

    @Test
    public void testThatWhenIFindAll_allTicketsAreFound() {
        Ticket ticketTwo = new Ticket();
        Ticket ticketThree = new Ticket();
        Ticket[] allTickets = {ticket, ticketTwo, ticketThree};
        for (Ticket t : allTickets) {
            ticketRepository.save(t);
        }

        List<Ticket> foundTickets = ticketRepository.findAll();
        assertEquals(3, foundTickets.size());
        for (int i = 0; i < allTickets.length; i++) {
            assertEquals(allTickets[i], foundTickets.get(i));
        }
    }

    @Test
    public void testThatWhenIFindAllAndNoTicketIsSaved_errorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findAll());
    }

    @Test
    public void testThatWhenIDeleteTicket_ticketIsDeleted() {
        Ticket savedTicket = ticketRepository.save(ticket);
        int ticketId = savedTicket.getId();
        assertEquals(1L, ticketRepository.count());

        ticketRepository.delete(ticketId);

        assertEquals(0L, ticketRepository.count());
    }
}