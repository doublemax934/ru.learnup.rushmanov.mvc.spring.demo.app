package ru.learnup.rushmanov.mvc.spring.demo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import ru.learnup.rushmanov.mvc.spring.demo.app.entity.TheatricalPerformance;
import ru.learnup.rushmanov.mvc.spring.demo.app.entity.Ticket;
import ru.learnup.rushmanov.mvc.spring.demo.app.dao.TheatricalPerformanceDAO;
import ru.learnup.rushmanov.mvc.spring.demo.app.dao.TicketDAO;

import javax.transaction.Transactional;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.util.List;

import static java.awt.GraphicsConfigTemplate.REQUIRED;

@Service
public class OnlineSalesRegisterServiceImpl implements OnlineSalesRegisterService {
    @Autowired
    private TheatricalPerformanceDAO theatricalPerformanceDAO;
    @Autowired
    private TicketDAO ticketDAO;

    @Override
    @Transactional
    public List<TheatricalPerformance> getAllPerformances() {
        return theatricalPerformanceDAO.getAllPerformances();
    }

    @Override
    @Transactional
    public void saveNewPerformance(TheatricalPerformance performance) {
        theatricalPerformanceDAO.saveNewPerformance(performance);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public TheatricalPerformance getPerformance(int id) {
        return theatricalPerformanceDAO.getPerfofmance(id);
    }

    @Override
    @Transactional
    public void deletePerformance(int id) {
        theatricalPerformanceDAO.deletePerformance(id);
    }

    @Override
    @Transactional
    public List<Ticket> getAllTickets(int id) {
        return ticketDAO.getAllTickets(id);
    }

    @Override
    @Transactional
    public void buyTicket(int id, int seatNumber) {
        ticketDAO.buyTicket(id, seatNumber);
    }

    @Override
    @Transactional
    public void refundTicket(int id, int seatNumber) {
        ticketDAO.refundTicket(id, seatNumber);
    }


}
