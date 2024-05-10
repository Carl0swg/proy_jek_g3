/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.EventoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;
/**
 *
 * @author sortizu
 */
public class DetalleEventoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Evento eventoCargado = (Evento)new EventoDAO().list(Integer.parseInt(request.getParameter("id")));
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse = eventoCargado.toString();
        out.println(jsonFormattedResponse);
        out.flush();
    }


}
