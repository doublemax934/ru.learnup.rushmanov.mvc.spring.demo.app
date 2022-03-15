package ru.learnup.rushmanov.mvc.spring.demo.app.dao;

import ru.learnup.rushmanov.mvc.spring.demo.app.entity.Ticket;

import java.util.List;

public interface TicketDAO {

    public List<Ticket> getAllTickets(String title);

    public void buyTicket(int id, int seatNumber);

    public void refundTicket(int id, int seatNumber);
}
