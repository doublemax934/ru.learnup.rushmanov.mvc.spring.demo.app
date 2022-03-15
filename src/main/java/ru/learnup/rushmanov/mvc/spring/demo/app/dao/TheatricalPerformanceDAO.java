package ru.learnup.rushmanov.mvc.spring.demo.app.dao;

import ru.learnup.rushmanov.mvc.spring.demo.app.entity.TheatricalPerformance;

import java.util.List;

public interface TheatricalPerformanceDAO {

    public List<TheatricalPerformance> getAllPerformances();

    public void saveNewPerformance(TheatricalPerformance performance);

    public TheatricalPerformance getPerfofmance(int id);

    public void deletePerformance(int id);

}
