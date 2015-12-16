import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Verify() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//out.println(request.getParameter("code"));
		String code = request.getParameter("code");
		String urlParameters = "code="
		                    + code
		                    + "&client_id=70134639814-31a4uk6n56edo0g234lbujrq1p1rrur7.apps.googleusercontent.com"
		                    + "&client_secret=B_u1NbY37Gx_04qvSWJkz-DR"
		                    + "&redirect_uri=http://localhost:8080/GLogin/Verify"
		                    + "&grant_type=authorization_code";
		URL url = new URL("https://accounts.google.com/o/oauth2/token");
		URLConnection urlConn = url.openConnection();
		urlConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(
		urlConn.getOutputStream());
		writer.write(urlParameters);
		writer.flush();
		
		String line, outputString = "";
		ArrayList<String> filldata = new ArrayList<String>();
		ArrayList<String> before = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()));
        while ((line = reader.readLine()) != null) {
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
		String get="", roll="", n="";
		int l=999;

		try
		{
			BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/User/Desktop/deepakthukra/adminfinal/src/input.txt"));
			while ((get = br2.readLine()) != null) 
			{
				String[] d = get.split("#");
				roll = d[2];
				l = Integer.parseInt(roll.substring(3));

			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		n = "PHD"+(l+1);
		
		int found_email=0, i=0;
		String rollfound="";
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/User/Desktop/deepakthukra/adminfinal/src/input.txt"));
			while ((getline = br.readLine()) != null) {
				String[] d = getline.split("#");
				if(d[0].equals(a4)){
					rollfound=d[2];
					found_email = 1;
				}
			}
			if(found_email==1){
				BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/User/Desktop/deepakthukra/adminfinal/WebContent/Data/"+rollfound+".txt"));
				while ((getline = br2.readLine()) != null) {
					String[] d = getline.split(":");					
					if(d.length==1){
						filldata.add("");
						before.add("");
					}else{
						filldata.add(d[1]);
						before.add(d[0]);
					}
				}
				request.getRequestDispatcher("/content1.html").include (request,response);
				out.println("<li>Email<input type='text' name='email' value='"+a4+"' class='common' style=\"margin-left:66px;\" disabled></li>");
				out.println("<li>Name<input type='text' name='name' value='"+filldata.get(1)+"' class='common' style=\"margin-left:66px;\" disabled></li>");
				out.println("<li>Enrollment No<input type='text' name='enroll_no' value='"+filldata.get(2)+"' class='common' style=\"margin-left:8px;\" disabled></li>");
				out.println("<li>Area of Correspondence<input type='text' value='"+filldata.get(3)+"' name='aoc' class='common' style=\"margin-left:-66px;\"></li>");
				out.println("<li>Mobile<input type='number' name='mobile' value='"+filldata.get(4)+"' class='common' placeholder='Enter Name' style=\"margin-left:60px;\"></li>");	
				out.println("<li>PhD Stream*");
				if(filldata.get(5).equals("Computer Science")){
					out.println("<input type='radio' name='phd_p' class='common' value='Computer Science' style=\"margin-left:-120px;\" checked>Computer Science<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Electronics and Communication' style=\"margin-left:-20px;\">Electronics and Communication<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Computational Biology' style=\"margin-left:-20px;\">Computational Biology</li>");
				}else if(filldata.get(5).equals("Electronics and Communication")){
					out.println("<input type='radio' name='phd_p' class='common' value='Computer Science' style=\"margin-left:-120px;\" >Computer Science<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Electronics and Communication' style=\"margin-left:-20px;\" checked>Electronics and Communication<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Computational Biology' style=\"margin-left:-20px;\">Computational Biology</li>");
				}else if(filldata.get(5).equals("Computational Biology")){
					out.println("<input type='radio' name='phd_p' class='common' value='Computer Science' style=\"margin-left:-120px;\" >Computer Science<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Electronics and Communication' style=\"margin-left:-10px;\">Electronics and Communication<br>");
					out.println("<input type='radio' name='phd_p' class='common' value='Computational Biology' style=\"margin-left:-10px;\" checked>Computational Biology</li>");
				}
				out.println("<li>PhD Preference 1*<input type='text' value='"+filldata.get(6)+"' class='common' style=\"margin-left:-36px;\"></li>");
				out.println("<li>PhD Preference 2*<input type='text' value='"+filldata.get(7)+"' class='common' style=\"margin-left:-36px;\"></li>");
				out.println("<li>PhD Preference 3*<input type='text' value='"+filldata.get(8)+"' class='common' style=\"margin-left:-36px;\"></li>");
				out.println("<li>Gender");
				if(filldata.get(9).equals("Male")){
					out.println("<input type='radio' name='gender' class='common' value='Male' style=\"margin-left:-70px;\" checked>Male<br>");
					out.println("<input type='radio' name='gender' class='common' value='Female' style=\"margin-left:-10px;\">Female</li>");
				}else{
					out.println("<input type='radio' name='gender' class='common' value='Male' style=\"margin-left:-70px;\" >Male<br>");
					out.println("<input type='radio' name='gender' class='common' value='Female' style=\"margin-left:-10px;\" checked>Female</li>");					
				}
				out.println("<li>Category*");
				if(filldata.get(10).equals("General")){
					out.println("<input type='radio' name='cat' class='common' value='Male' style=\"margin-left:-70px;\" checked>General<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">SC<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">ST<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">OBC</li>");
				}else if(filldata.get(10).equals("SC")){
					out.println("<input type='radio' name='cat' class='common' value='Male' style=\"margin-left:-70px;\" >General<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\" checked>SC<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">ST<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">OBC</li>");
				}else if(filldata.get(10).equals("ST")){
					out.println("<input type='radio' name='cat' class='common' value='Male' style=\"margin-left:-70px;\" >General<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">SC<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\" checked>ST<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">OBC</li>");
				}else if(filldata.get(10).equals("OBC")){
					out.println("<input type='radio' name='cat' class='common' value='Male' style=\"margin-left:-70px;\" checked>General<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">SC<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\">ST<br>");
					out.println("<input type='radio' name='cat' class='common' value='Female' style=\"margin-left:-10px;\" checked>OBC</li>");
				}
				out.println("<li>Physically Disabled*");
				if(filldata.get(11).equals("Yes")){
					out.println("<input type='radio' name='phy_d' class='common' value='Male' style=\"margin-left:-155px;\" checked>Yes<br>");
					out.println("<input type='radio' name='phy_d' class='common' value='Female' style=\"margin-left:-10px;\">No</li>");
				}else{
					out.println("<input type='radio' name='phy_d' class='common' value='Male' style=\"margin-left:-155px;\" >Yes<br>");
					out.println("<input type='radio' name='phy_d' class='common' value='Female' style=\"margin-left:-10px;\" checked>No</li>");					
				}
				out.println("<li>Children/War Widows*");
				if(filldata.get(12).equals("Yes")){
					out.println("<input type='radio' name='war' class='common' value='Male' style=\"margin-left:-175px;\" checked>Yes<br>");
					out.println("<input type='radio' name='war' class='common' value='Female' style=\"margin-left:-10px;\">No</li>");
				}else{
					out.println("<input type='radio' name='war' class='common' value='Male' style=\"margin-left:-175px;\" >Yes<br>");
					out.println("<input type='radio' name='war' class='common' value='Female' style=\"margin-left:-10px;\" checked>No</li>");					
				}
				out.println("<li>Father's Name<input type='text' value='"+filldata.get(13)+"' name='aoc' class='common' style=\"margin-left:0px;\"></li>");
				out.println("<li>Nationality<input type='text' value='"+filldata.get(14)+"' name='aoc' class='common' style=\"margin-left:30px;\"></li>");
				out.println("<li>Permanent Address<input type='text' value='"+filldata.get(15)+"' name='aoc' class='common' style=\"margin-left:-40px;\"></li>");
				out.println("<li>Pin Code<input type='text' value='"+filldata.get(16)+"' name='aoc' class='common' style=\"margin-left:40px;\"></li>");
				out.println("</ul></div>");	
				out.println("<div id='form_2' style='display:none'>");
				out.println("<ul style='margin:0;padding:0;list-style: none;overflow: auto;'><li style=\"margin-left:0;padding:7px\">Schooling Information<hr></li>");
				out.println("<li>Xth Board<input type='text' value='"+filldata.get(17)+"' name='aoc' class='common' style=\"margin-left:70px;\"></li>");
				out.println("<li>Xth Marks(%)<input type='text' value='"+filldata.get(18)+"' name='aoc' class='common' style=\"margin-left:43px;\"></li>");
				out.println("<li>Year Of Passing Xth<input type='text' value='"+filldata.get(19)+"' name='aoc' class='common' style=\"margin-left:-5px;\"></li>");
				out.println("<li>XIIth Board<input type='text' value='"+filldata.get(20)+"' name='aoc' class='common' style=\"margin-left:60px;\"></li>");
				out.println("<li>XIIth Marks(%)<input type='text' value='"+filldata.get(21)+"' name='aoc' class='common' style=\"margin-left:33px;\"></li>");
				out.println("<li>Year Of Passing Xth<input type='text' value='"+filldata.get(22)+"' name='aoc' class='common' style=\"margin-left:-5px;\"></li>");
				out.println("<li style=\"margin-left:0;padding:7px\">Graduation Information<hr></li>");
				out.println("<li>Graduation Degree<input type='text' value='"+filldata.get(23)+"' name='aoc' class='common' style=\"margin-left:5px;\"></li>");
				out.println("<li>Graduation Department<input type='text' value='"+filldata.get(24)+"' name='aoc' class='common' style=\"margin-left:-27px;\"></li>");
				out.println("<li>Name Of College<input type='text' value='"+filldata.get(25)+"' name='aoc' class='common' style=\"margin-left:15px;\"></li>");
				out.println("<li>Name Of University<input type='text' value='"+filldata.get(26)+"' name='aoc' class='common' style=\"margin-left:0px;\"></li>");
				out.println("<li>City<input type='text' value='"+filldata.get(27)+"' name='aoc' class='common' style=\"margin-left:110px;\"></li>");
				out.println("<li>State<input type='text' value='"+filldata.get(28)+"' name='aoc' class='common' style=\"margin-left:100px;\"></li>");
				out.println("<li>Year Of Graduation<input type='text' value='"+filldata.get(29)+"' name='aoc' class='common' style=\"margin-left:-2px;\"></li>");
				out.println("<li>Marks<input type='text' value='"+filldata.get(30)+"' name='aoc' class='common' style=\"margin-left:93px;\"></li>");
				out.println("<hr>");
				for(int k=31;k<filldata.size();k++){
					out.println("<li>"+before.get(k)+"<input type='text' value='"+filldata.get(k)+"' class='common' style=\"margin-left:0px;\"></li>");
				}
				
				request.getRequestDispatcher("/content3.html").include (request,response);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		if(found_email!=1){
			request.getRequestDispatcher("/content1.html").include (request,response);
			out.println("<li>Email*<input type='text' name='email' value="+a4+" class='common' placeholder='Enter E-mail' style=\"margin-left:66px;\" required></li>");
			out.println("<li>Name*<input type='text' name='name' class='common' placeholder='Enter Name' style=\"margin-left:66px;\" required></li>"
			+"<li>Enrollment No*<input type='text' name='enroll_no' value="+n+" class='common' style=\"margin-left:8px;\" disabled></li>");
			request.getRequestDispatcher("/content2.html").include (request,response);
			request.getRequestDispatcher("/content3.html").include (request,response);

		}			
	}
}