package ru.learnup.rushmanov.mvc.spring.demo.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.learnup.rushmanov.mvc.spring.demo.app.entity.Ticket;

import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ticket> getAllTickets(String title) {
        Session session = sessionFactory.getCurrentSession();
        List<Ticket> allTickets = session.createQuery("from Ticket " +
                        "where ticketTitle =:title")
                .setParameter("title", title)
                .getResultList();

        return allTickets;
    }

    @Override
    public void buyTicket(int id, int seatNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Ticket set status = 'sold'" +
                "where id =:ID AND seatNumber=:seatNumber")
                .setParameter("ID", id)
                .setParameter("seatNumber", seatNumber)
                .executeUpdate();
    }

    @Override
    public void refundTicket(int id, int seatNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Ticket set status = 'on sale'" +
                        "where id =:ID AND seatNumber=:seatNumber")
                .setParameter("ID", id)
                .setParameter("seatNumber", seatNumber)
                .executeUpdate();
    }
}
