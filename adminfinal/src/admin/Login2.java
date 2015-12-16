/*
 * author : Deepak Thukral, Darvesh Punia
 * Roll no: 2014036
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login2
 */

public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	//	out.write(
		//		"<a href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/adminfinal/Verify2&response_type=code&client_id=70134639814-31a4uk6n56edo0g234lbujrq1p1rrur7.apps.googleusercontent.com&approval_prompt=force'>Login</a>");
		out.write(
				"<a style='border-radius:7px;padding:10px;color:white;background-color:tomato;font-size:2em;text-decoration:none;margin:40px'"
				+ " href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/adminfinal/Verify2&response_type=code&client_id=70134639814-31a4uk6n56edo0g234lbujrq1p1rrur7.apps.googleusercontent.com&approval_prompt=force'>g | <span style='font-family:sans-serif'>Sign In With Google</span></a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
