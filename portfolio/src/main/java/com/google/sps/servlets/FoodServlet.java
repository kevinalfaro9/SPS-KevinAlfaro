package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/foods")
public class FoodServletls extends HttpServlet {

    private String[] arr = {"Tacos", "Korean BBQ", "Burritos!"};
    String json = convertToJsonUsingGson(arr);


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  private String convertToJsonUsingGson(String[] arr) {
    Gson gson = new Gson();
    String json = gson.toJson(arr);
    return json;
  }
}
