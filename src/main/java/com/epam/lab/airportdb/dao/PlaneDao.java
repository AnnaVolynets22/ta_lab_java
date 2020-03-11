package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Plane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class PlaneDao implements Dao<Plane> {

    @Override
    public Optional<Plane> get(String id) throws SQLException {
        Plane plane = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_PLANE_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    plane = new Plane(rs.getInt("id"), rs.getString("planeNumber"), rs.getInt("Capacity"));
                }
            }
        }
        return Optional.of(plane);
    }

    @Override
    public List<Plane> getAll() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_PLANES)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    planes.add(new Plane(rs.getInt("id"), rs.getString("planeNumber"), rs.getInt("Capacity")));
                }
            }
        }
        return planes;
    }

    @Override
    public int create(Plane plane) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(CREATE_PLANE)) {
            ps.setString(1, plane.getPlaneNumber());
            ps.setInt(2, plane.getCapacity());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Plane plane) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(UPDATE_PLANE)) {
            ps.setString(1, plane.getPlaneNumber());
            ps.setInt(2, plane.getCapacity());
            ps.setInt(3, plane.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_PLANE)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }
}
