package controller;

import Service.AdvertisementService;
import model.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car")
public class CarController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveAdvertisement(request);
        request.getRequestDispatcher("WEB-INF/car.jsp").forward(request, response);
    }
        private void saveAdvertisement (HttpServletRequest request)
        {
            Long id = Long.parseLong(request.getParameter("advertisementId"));
            AdvertisementService advertisementService = new AdvertisementService();
            Advertisement advertisement = advertisementService.getAdvertisementById(id);
            request.setAttribute("advertisement", advertisement);
        }

}
