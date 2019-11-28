package controller;

import Service.AdvertisementService;
import model.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveAdvertisementsInRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

    }

    private void saveAdvertisementsInRequest(HttpServletRequest request) {
        AdvertisementService advertisementService = new AdvertisementService();
        List <Advertisement> allAdvertisements = advertisementService.getAllAdvertisements((d1, d2) -> d2.getTimestamp().compareTo(d1.getTimestamp()));

        request.setAttribute("advertisements", allAdvertisements);

    }

}


