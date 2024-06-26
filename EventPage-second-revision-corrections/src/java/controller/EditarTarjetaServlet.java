/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.TarjetaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import model.Tarjeta;

/**
 *
 * @author sortizu
 */
public class EditarTarjetaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        Tarjeta nuevaTarjeta = new Tarjeta();
        nuevaTarjeta.setIdTarjeta(Integer.parseInt(request.getParameter("creditCardId")));
        nuevaTarjeta.setNombrePropietario(request.getParameter("card-owner"));
        nuevaTarjeta.setNumeroTarjeta(request.getParameter("card-number"));
        
        String fecha = request.getParameter("expiration-date")+"-01";
        LocalDate fechaVencimiento = LocalDate.parse(fecha);
        nuevaTarjeta.setFechaDeVencimiento(fechaVencimiento);
        nuevaTarjeta.setIdUsuario((Integer)request.getSession().getAttribute("id_user"));

        tarjetaDAO.edit(nuevaTarjeta);
        response.sendRedirect("index.jsp");
    }

}
