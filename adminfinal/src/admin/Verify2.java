package admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verify2
 */
public class Verify2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//out.println(request.getParameter("code"));
		String code = request.getParameter("code");
		String urlParameters = "code="
		                    + code
		                    + "&client_id=70134639814-31a4uk6n56edo0g234lbujrq1p1rrur7.apps.googleusercontent.com"
		                    + "&client_secret=B_u1NbY37Gx_04qvSWJkz-DR"
		                    + "&redirect_uri=http://localhost:8080/adminfinal/Verify2"
		                    + "&grant_type=authorization_code";
		URL url = new URL("https://accounts.google.com/o/oauth2/token");
		URLConnection urlConn = url.openConnection();
		urlConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(
		urlConn.getOutputStream());
		writer.write(urlParameters);
		writer.flush();
		
		String line, outputString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()));
        while ((line = reader.readLine()) != null) 
        {
            outputString += line;
        }
        
		String[] t2 = outputString.split(":");
		String t3 = t2[1].split(",")[0];
		String t4 = t3.substring(2,t3.length()-1);
 

        //get User Info 
        url = new URL(
                "https://www.googleapis.com/oauth2/v1/userinfo?access_token="
                        + t4);
        urlConn = url.openConnection();
        outputString = "";
        reader = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        
        String[] a2 = outputString.split(":");
		String a3 = a2[2].split(",")[0];
		String a4 = a3.substring(2,a3.length()-1);
		String getline="";
		
		
	      // Main	
		  response.setContentType("text/html");
	      request.getRequestDispatcher("/index.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
