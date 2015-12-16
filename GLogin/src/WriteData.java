import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class WriteData
 */
@WebServlet("/WriteData")
@MultipartConfig

public class WriteData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public WriteData() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String get="", roll="", n="";
		int l=999;
		String datawrite="";
		BufferedReader br2=null;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		try
		{
            br2 = new BufferedReader(new FileReader("C:/Users/User/Desktop/deepakthukra/adminfinal/src/input.txt"));
		//	br2 = new BufferedReader(new FileReader("C:/Users/Darvesh/Desktop/all_data.txt"));
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
		finally{
			if(br2 !=null){br2.close();}
		}
	
		n = "PHD"+(l+1);
		
	    if(request.getParameter("email") != null)
			datawrite += "Email :" + request.getParameter("email").toString() + "\n";
		if(request.getParameter("name")!=null)
			datawrite += "Name :" + request.getParameter("name").toString() + "\n";
		
		datawrite +="Enrollment Number :"+ n + "\n";

		if(request.getParameter("aoc")!=null)
			datawrite += "Address of Correspondence :" + request.getParameter("aoc").toString() + "\n";
		if(request.getParameter("mobile")!=null)
			datawrite += "Mobile :" + request.getParameter("mobile").toString() + "\n";
		if(request.getParameter("phd_p")!=null)
			datawrite += "PHD Stream :" + request.getParameter("phd_p").toString() + "\n";
		if(request.getParameter("phd_1")!=null)
			datawrite += "PhD Area Preference 1 :" + request.getParameter("phd_1").toString() + "\n";
		if(request.getParameter("phd_2")!=null)
			datawrite += "PhD Area Preference 2 :" + request.getParameter("phd_2").toString() + "\n";
		if(request.getParameter("phd_3")!=null)
			datawrite += "PhD Area Preference 3 :" + request.getParameter("phd_3").toString() + "\n";
		if(request.getParameter("gender")!=null)
			datawrite += "Gender :" + request.getParameter("gender").toString() + "\n";
		if(request.getParameter("category")!=null)
			datawrite += "Category :" + request.getParameter("category").toString() + "\n";
		if(request.getParameter("phy_d")!=null)
			datawrite += "Physically Disabled :" + request.getParameter("phy_d").toString() + "\n";
		if(request.getParameter("dob")!=null)
			datawrite += "Date Of Birth :" + request.getParameter("dob").toString() + "\n";

		if(request.getParameter("father")!=null)
			datawrite += "Father's Name :" + request.getParameter("father").toString() + "\n";
		if(request.getParameter("nationality")!=null)
			datawrite += "Nationality :" + request.getParameter("nationality").toString() + "\n";
		if(request.getParameter("p_add")!=null) 
			datawrite += "Permanent address :" + request.getParameter("p_add").toString() + "\n";
		if(request.getParameter("pcode")!=null)
			datawrite += "Pin Code :" + request.getParameter("pcode").toString() + "\n";
		if(request.getParameter("x_b")!=null)
			datawrite += "X Board :" + request.getParameter("x_b").toString() + "\n";
		if(request.getParameter("x_m")!=null)
			datawrite += "X Board(%) :" + request.getParameter("x_m").toString() + "\n";
		if(request.getParameter("x_year")!=null)
			datawrite += "X Year :" + request.getParameter("x_year").toString() + "\n";
		if(request.getParameter("xii_b")!=null)
			datawrite += "XII Board :" + request.getParameter("xii_b").toString() + "\n";
		if(request.getParameter("xii_m")!=null)
			datawrite += "XIIth Board(%) :" + request.getParameter("xii_m").toString() + "\n";
		if(request.getParameter("xii_year")!=null)
			datawrite += "XII Year :" + request.getParameter("xii_year").toString() + "\n";
		if(request.getParameter("g_deg")!=null)
			datawrite += "Graduation Degree :" + request.getParameter("g_deg").toString() + "\n";
		if(request.getParameter("g_dept")!=null)
			datawrite += "Graduation Department :" + request.getParameter("g_dept").toString() + "\n";
		if(request.getParameter("g_col_name")!=null)
			datawrite += "Graduation College :" + request.getParameter("g_col_name").toString() + "\n";
		if(request.getParameter("g_univ_name")!=null)
			datawrite += "Graduation University :" + request.getParameter("g_univ_name").toString() + "\n";
		if(request.getParameter("g_city")!=null)
			datawrite += "Graduation City :" + request.getParameter("g_city").toString() + "\n";
		
		if(request.getParameter("g_state")!=null)
			datawrite += "Graduation State :" + request.getParameter("g_state").toString() + "\n";
        
		if(request.getParameter("g_year")!=null && !request.getParameter("g_year").toString().equals(""))
			datawrite += "Graduation Year :" + request.getParameter("g_year").toString()+"\n";

		
		if(request.getParameter("g_marks")!=null){
			if(request.getParameter("g_marks").equals("CGPA")){
				float g_m = (Float.parseFloat(request.getParameter("cg_c_m"))*100 ) / Float.parseFloat(request.getParameter("out_of"));
				datawrite += "Graduation Marks :" + g_m + " (CGPA - "+request.getParameter("cg_c_m")+" ) \n";
			}else{
				datawrite += "Graduation Marks :" + request.getParameter("mr_c_m").toString() + "\n";
			}
		}
			
		if(request.getParameter("pg_deg")!=null && !request.getParameter("pg_deg").toString().equals(""))
			datawrite += "Post Graduation Degree :" + request.getParameter("pg_deg").toString()+"\n";
		if(request.getParameter("pg_dept")!=null && !request.getParameter("pg_dept").toString().equals(""))
			datawrite += "Post Graduation Department :" + request.getParameter("pg_dept").toString()+"\n";
		if(request.getParameter("pg_col_name")!=null && !request.getParameter("pg_col_name").toString().equals(""))
			datawrite += "Post Graduation College :" + request.getParameter("pg_col_name").toString()+"\n";
		if(request.getParameter("pg_univ_name")!=null && !request.getParameter("pg_univ_name").toString().equals(""))
			datawrite += "Post Graduation University :" + request.getParameter("pg_univ_name").toString()+"\n";
		if(request.getParameter("pg_city")!=null && !request.getParameter("pg_city").toString().equals(""))
			datawrite += "Post Graduation College name :" + request.getParameter("pg_city").toString()+"\n";
		if(request.getParameter("pg_state")!=null && !request.getParameter("pg_state").toString().equals(""))
			datawrite += "Post Graduation State :" + request.getParameter("pg_state").toString()+"\n";
		
		if(request.getParameter("pg_year")!=null && !request.getParameter("pg_year").toString().equals(""))
			datawrite += "Post Graduation Year :" + request.getParameter("pg_year").toString()+"\n";
				
		
		if(request.getParameter("pg_marks")!=null  && !request.getParameter("pg_marks").toString().equals("")){
			if(request.getParameter("pg_marks").equals("CGPA")){
				float g_m = (Float.parseFloat(request.getParameter("pgc_c_m"))*100 ) / Float.parseFloat(request.getParameter("pg_out_of"));
				datawrite += "Post-Graduation Marks :" + g_m + " (CGPA -"+request.getParameter("pgc_c_m")+" ) \n";
			}else{
				datawrite += "Post-Graduation Marks :" + request.getParameter("pgm_c_m").toString() + "\n";
			}
		}
		
		if(request.getParameter("if_ece_subject1")!=null && !request.getParameter("if_ece_subject1").toString().equals(""))
			datawrite += "ECE PHD Preference 1 :" + request.getParameter("if_ece_subject1").toString()+"\n";
		if(request.getParameter("if_ece_subject2")!=null && !request.getParameter("if_ece_subject2").toString().equals(""))
			datawrite += "ECE PHD Preference 2 :" + request.getParameter("if_ece_subject2").toString()+"\n";
		if(request.getParameter("if_ece_subject3")!=null && !request.getParameter("if_ece_subject3").toString().equals(""))
			datawrite += "ECE PHD Preference 3 :" + request.getParameter("if_ece_subject3").toString()+"\n";
		if(request.getParameter("if_ece_subject4")!=null && !request.getParameter("if_ece_subject4").toString().equals(""))
			datawrite += "ECE PHD Preference 4 :" + request.getParameter("if_ece_subject4").toString()+"\n";
	
		
		if(request.getParameter("oad_exam")!=null && !request.getParameter("oad_exam").toString().equals(""))
			datawrite += "Other Academic Degree Exam :" + request.getParameter("oad_exam").toString()+"\n";
		if(request.getParameter("oad_subject")!=null && !request.getParameter("oad_subject").toString().equals(""))
			datawrite += "Other Academic Degree Subject :" + request.getParameter("oad_subject").toString()+"\n";
		if(request.getParameter("oad_year")!=null && !request.getParameter("oad_year").toString().equals(""))
			datawrite += "Other Academic Degree Year :" + request.getParameter("oad_year").toString()+"\n";
		if(request.getParameter("oad_score")!=null && !request.getParameter("oad_score").toString().equals(""))
			datawrite += "Other Academic Degree Score :" + request.getParameter("oad_score").toString()+"\n";
		if(request.getParameter("oad_rank")!=null && !request.getParameter("oad_rank").toString().equals(""))
			datawrite += "Other Academic Degree Rank :" + request.getParameter("oad_rank").toString()+"\n";
		if(request.getParameter("gate_area")!=null && !request.getParameter("gate_area").toString().equals(""))
			datawrite += "Gate Area :" + request.getParameter("gate_area").toString()+"\n";
		if(request.getParameter("gate_subject")!=null && !request.getParameter("gate_subject").toString().equals(""))
			datawrite += "Gate Subject :" + request.getParameter("gate_subject").toString()+"\n";
		if(request.getParameter("gate_year")!=null && !request.getParameter("gate_year").toString().equals(""))
			datawrite += "Gate Year :" + request.getParameter("gate_year").toString()+"\n";
		if(request.getParameter("gate_score")!=null && !request.getParameter("gate_score").toString().equals(""))
			datawrite += "Gate Score :" + request.getParameter("gate_score").toString()+"\n";
		if(request.getParameter("gate_rank")!=null && !request.getParameter("gate_rank").toString().equals(""))
			datawrite += "Gate rank :" + request.getParameter("gate_rank").toString() + "\n";

		BufferedWriter output = null, output2=null;
        try
        {
            File file = new File("C:/Users/User/Desktop/deepakthukra/adminfinal/WebContent/Data/"+n+".txt");
         //   File file = new File("C:/Users/Darvesh/Desktop/"+n+".txt"); 
            
            output = new BufferedWriter(new FileWriter(file));
            output.write(datawrite);
        } 
        catch ( IOException e ) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if ( output != null ) 
            	output.close();
        }
datawrite = "";
        
        if(request.getParameter("email")!=null)
			datawrite+=request.getParameter("email").toString();
        datawrite+="#";
        
		if(request.getParameter("name")!=null)
			datawrite+=request.getParameter("name").toString();
		datawrite+="#";
		
		datawrite+=n+"#";
		
		if(request.getParameter("category")!=null)
			datawrite += request.getParameter("category").toString();
		datawrite +="#";
		
		if(request.getParameter("gender")!=null)
			datawrite += request.getParameter("gender").toString();
		datawrite +="#";
		
		if(request.getParameter("phy_d")!=null)
			datawrite += request.getParameter("phy_d").toString();
		datawrite += "#";
		
		if(request.getParameter("dob")!=null)
			datawrite += request.getParameter("dob").toString();
		datawrite += "#";
		
		if(request.getParameter("phd_p")!=null)
			datawrite += request.getParameter("phd_p").toString();
		datawrite += "#";
		
		if(request.getParameter("g_deg")!=null)
			datawrite += request.getParameter("g_deg").toString();
		datawrite += "#";
		
		if(request.getParameter("pg_deg")!=null && !request.getParameter("pg_deg").equals(""))
			datawrite += request.getParameter("pg_deg").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("x_b")!=null)
			datawrite+=request.getParameter("x_b").toString();
		datawrite += "#";
		
		if(request.getParameter("xii_b")!=null)
			datawrite+=request.getParameter("xii_b").toString();
		datawrite += "#";
		
		if(request.getParameter("g_dept")!=null)
			datawrite+=request.getParameter("g_dept").toString();
		datawrite += "#";
		
		if(request.getParameter("pg_dept")!=null && !request.getParameter("pg_dept").equals(""))
			datawrite+=request.getParameter("pg_dept").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("g_univ_name")!=null)
			datawrite+=request.getParameter("g_univ_name").toString();
		datawrite += "#";
		
		if(request.getParameter("pg_univ_name")!=null && !request.getParameter("pg_univ_name").equals(""))
			datawrite+=request.getParameter("pg_univ_name").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("g_state")!=null)
			datawrite+=request.getParameter("g_state").toString();
		datawrite += "#";
		
		if(request.getParameter("pg_state")!=null && !request.getParameter("pg_state").equals(""))
			datawrite+=request.getParameter("pg_state").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("x_m")!=null)
			datawrite+=request.getParameter("x_m").toString();
		datawrite += "#";
		
		if(request.getParameter("xii_m")!=null)
			datawrite+=request.getParameter("xii_m").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("g_marks")!=null){
			if(request.getParameter("g_marks").equals("CGPA")){
				float g_m = (Float.parseFloat(request.getParameter("cg_c_m"))*100 ) / Float.parseFloat(request.getParameter("out_of"));
				datawrite += g_m;
			}else{
				datawrite +=request.getParameter("mr_c_m").toString();
			}
		}
		datawrite += "#";
		
		if(request.getParameter("pg_marks")!=null && !request.getParameter("pg_marks").equals("")){
			if(request.getParameter("pg_marks").equals("CGPA")){
				float g_m = (Float.parseFloat(request.getParameter("pgc_c_m"))*100 ) / Float.parseFloat(request.getParameter("pg_out_of"));
				datawrite += g_m;
			}else{
				datawrite +=request.getParameter("pgm_c_m").toString();
			}
		}else
			datawrite += "null";
		datawrite += "#";
		
		if(request.getParameter("gate_score")!=null && !request.getParameter("gate_score").equals(""))
			datawrite+=request.getParameter("gate_score").toString();
		else
			datawrite += "null";
		datawrite += "#";
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(new Date());
		datawrite+=timeStamp+"#"+timeStamp2;
		
		datawrite+="\n";
	
		try 
		{
            File file2 = new File("C:/Users/User/Desktop/deepakthukra/adminfinal/src/input.txt");
		//	File file2 = new File("C:/Users/Darvesh/Desktop/all_data.txt");
			output2 = new BufferedWriter(new FileWriter(file2, true));
            output2.write(datawrite);
        } 
		catch ( IOException e ) 
		{
            e.printStackTrace();
        } 
		finally 
		{
            if ( output2 != null ) 
            	output2.close();
        }
		
		
		final String path = "C:/Users/User/Desktop/deepakthukra/adminfinal/WebContent/Cv/";
    	final String path2 = "C:/Users/User/Desktop/deepakthukra/adminfinal/WebContent/Sop/";
		
	//	final String path = "C:/Users/Darvesh/Desktop/CV";
    //	final String path2 = "C:/Users/Darvesh/Desktop/SOP";
        
		final Part filePart = request.getPart("file1");
        final Part filePart2 = request.getPart("file2");
        final String fileName = n;
        final String fileName2 = n;

        OutputStream out = null, out2=null;
        InputStream filecontent = null, filecontent2 = null;

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName + ".txt"));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            
            out2 = new FileOutputStream(new File(path2 + File.separator
                    + fileName2 + ".txt"));
            filecontent2 = filePart2.getInputStream();

            int read2 = 0;
            final byte[] bytes2 = new byte[1024];

            while ((read2 = filecontent2.read(bytes2)) != -1) {
                out2.write(bytes2, 0, read2);
            }
            
            writer.println("Data Saved Successfully!");
            writer.println("<a href='Login' style='text-decoration:none;color:blue'>Log Out</a>");
   
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        } finally {
        	if (out != null) {
                out.close();
            }
            if (out2 != null) {
                out2.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (filecontent2 != null) {
                filecontent2.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
