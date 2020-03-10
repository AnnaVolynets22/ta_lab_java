package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.PlaneDao;
import com.epam.lab.airportdb.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlaneService implements Service<Plane>{
    private static final Logger log = LogManager.getLogger(PlaneService.class);

    PlaneDao planeDao = new PlaneDao();

    @Override
    public Optional<Plane> find(String id) throws SQLException {
        return planeDao.get(id);
    }

    @Override
    public List<Plane> findAll() throws SQLException {
        return planeDao.getAll();
    }

    @Override
    public int create(Plane plane) throws SQLException {
        return planeDao.create(plane);
    }

    @Override
    public int update(Plane plane) throws SQLException {
        return planeDao.update(plane);
    }

    @Override
    public int delete(Plane plane) throws SQLException {
        return planeDao.delete(plane);
    }

    public void printPlane(String id) throws SQLException {
        Optional<Plane> plane =planeDao.get(id);
        if (plane != null) {
            log.info(plane.get().toString());
        } else {
            log.info("Plane with  " + id + " not found");
        }

    }

    public void printAllPlanes() throws SQLException {
        List<Plane> planes = planeDao.getAll();
        planes.forEach(log::info);
    }

}
