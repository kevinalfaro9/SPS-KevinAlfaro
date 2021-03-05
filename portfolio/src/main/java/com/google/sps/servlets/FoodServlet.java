package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/foods")
public class FoodServlet extends HttpServlet {
    // Initiliaze our String array since I want to display my favorite foods.
    private String[] arr = {"Tacos", "Korean BBQ", "Burritos!"};
    // our json variable will be the array we created above formatted in GSON which formats it for us to display.
    String json = convertToJsonUsingGson(arr);


    // the doGet runs when we send a request to the "/foods" URL - AKA when we inject it onto our HTML
    // and the user clicks the href link, that is the request. Once link is clicked on the HTML page
    // this method runs in the background and sends prints out our json variable that we converted to GSON
    // at the very top.
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  // This is simply the GSON library being used to format a String array
  // into GSON format because it is formatting java objects as strings.
  private String convertToJsonUsingGson(String[] arr) {
    Gson gson = new Gson();
    String json = gson.toJson(arr);
    return json;
  }
}
