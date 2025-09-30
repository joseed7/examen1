package com.agenda.repository;

import com.agenda.model.Contacto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoRepository {

    public void insertar(Contacto contacto) {
        String sql = "INSERT INTO Contacto (nombre, telefono, email, direccion) VALUES (?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getTelefono());
            ps.setString(3, contacto.getEmail());
            ps.setString(4, contacto.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contacto> listar() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM Contacto";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contacto c = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion")
                );
                contactos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }
}
