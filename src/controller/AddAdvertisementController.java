package controller;

import Service.AdvertisementService;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddAdvertisementController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("inputTitle");
        String description = request.getParameter("inputDescription");
        int price = Integer.parseInt(request.getParameter("inputPrice"));
        String carProducent = request.getParameter("inputCarProducent");
        String carModel = request.getParameter("inputCarModel");
        String fuelType = request.getParameter("inputFuelType");
        int engineCapacity = Integer.parseInt(request.getParameter("inputCapacity"));
        int yearOfProduction = Integer.parseInt(request.getParameter("inputYear"));
        String carType = request.getParameter("inputCarType");
        User authenticatedUser = (User)request.getSession().getAttribute("user");
        if (request.getUserPrincipal()!=null)
        {
            AdvertisementService advertisementService = new AdvertisementService();
            advertisementService.addAdvertisement(title, authenticatedUser, description, price, carProducent, carModel, fuelType, engineCapacity, yearOfProduction, carType);
            response.sendRedirect(request.getContextPath()+"/");
        }
        else {
            response.sendError(403);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal()!=null)
        {
            request.getRequestDispatcher("WEB-INF/new.jsp").forward(request, response);

        }else {
            response.sendError(403);
        }
    }
}
