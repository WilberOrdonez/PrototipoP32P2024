/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Cliente;
import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author visitante
 */
public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT Pkid, nombre, idTipo, apellido, nit, telefonon, direccion, correo, estatus FROM Cliente";
    private static final String SQL_INSERT = "INSERT INTO Cliente(Pkid, nombre, idTipo, apellido, nit, telefonon, direccion, correo, estatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Cliente SET nombre=?, idTipo=?, apellido=?, nit=?, telefonon=?, direccion=?, correo=?, estatus=? WHERE Pkid = ?";
    private static final String SQL_DELETE = "DELETE FROM Cliente WHERE Pkid=?";
    private static final String SQL_QUERY = "SELECT Pkid, nombre, idTipo, apellido, nit, telefonon, direccion, correo, estatus FROM Cliente WHERE nombre = ?";

    public List<Cliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pkid = rs.getString("Pkid");
                String nombre = rs.getString("nombre");
                String idTipo = rs.getString("idTipo");
                String apellido = rs.getString("apellido");
                String nit = rs.getString("nit");
                String telefono = rs.getString("telefonon");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                String estatus = rs.getString("estatus");

                cliente = new Cliente(pkid, nombre, idTipo, apellido, nit, telefono, direccion, correo, estatus);

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public int insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getPkid());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getIdTipo());
            stmt.setString(4, cliente.getApellido());
            stmt.setString(5, cliente.getNit());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getDireccion());
            stmt.setString(8, cliente.getCorreo());
            stmt.setString(9, cliente.getEstatus());

            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getIdTipo());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getNit());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getDireccion());
            stmt.setString(7, cliente.getCorreo());
            stmt.setString(8, cliente.getEstatus());
            stmt.setString(9, cliente.getPkid());

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getPkid());
            System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Cliente query(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, cliente.getNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pkid = rs.getString("Pkid");
                String nombre = rs.getString("nombre");
                String idTipo = rs.getString("idTipo");
                String apellido = rs.getString("apellido");
                String nit = rs.getString("nit");
                String telefono = rs.getString("telefonon");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                String estatus = rs.getString("estatus");

                cliente = new Cliente(pkid, nombre, idTipo, apellido, nit, telefono, direccion, correo, estatus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }
}
