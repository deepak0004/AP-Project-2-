package admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class filteredcontent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	BufferedReader br;
	BufferedWriter bw = null;
	String getline = "";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        HttpSession session=request.getSession(true);  
        LocalDate dm = LocalDate.now();
        int  terimaa = 0;
        
        int flag, flag2;
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> getData = new ArrayList<String>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Enumeration<String> pnames = request.getParameterNames();
		while (pnames.hasMoreElements()) 
		{
			String pname = (String) pnames.nextElement();
			getData.add(request.getParameter(pname));
		}
		out.println("<html><head><title></title><style type='text/css'>table,th,td{border-collapse: collapse;border:1px solid grey;padding:10px;}</style></head><body>");
		out.println("<table><tr><td>Enrollment Id</td><td>Name</td><td>Link</td></tr>");
		br = new BufferedReader(new FileReader("C:/Users/User/Desktop/deepakthukra/adminfinal/src/input.txt"));
		
		while ((getline = br.readLine()) != null) 
		{
				flag = 0;
				flag2 = 0;
				String[] temp = getline.split("#");
				if((request.getParameter("us1") != null) && (!request.getParameter("us1").toString().equals("") )  )
				{
				    if( !temp[0].equalsIgnoreCase( request.getParameter("us1").toString() ) )
					{
					   flag = 1;	
					}	
				}
				if( (request.getParameter("us2") != null) && ( !request.getParameter("us2").toString().equals("") )  )
				{
					if( !temp[1].equalsIgnoreCase( request.getParameter("us2").toString() ) )
					{
					   flag = 1;	
					}	
				}
				if( ( request.getParameter("us3") != null ) && ( !request.getParameter("us3").toString().equals("") )  )
				{
					if( !temp[2].equalsIgnoreCase( request.getParameter("us3").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us4") != null ) && ( !request.getParameter("us4").toString().equals("all") ) && ( !request.getParameter("us4").toString().equals("") )  )
				{
					if( !temp[3].equalsIgnoreCase( request.getParameter("us4").toString() ) )
					{
					   flag = 1;	
					}					
				}

				if( ( request.getParameter("gender") != null ) && ( !request.getParameter("gender").toString().equals("All") )  )  // Selected
				{
					if( !temp[4].equalsIgnoreCase( request.getParameter("gender").toString()) )
					{
					   flag = 1;
					}	
				}
				if( ( request.getParameter("phyd") != null ) && ( !request.getParameter("phyd").toString().equals("") )  )  // Selected
				{
					if( !temp[5].equalsIgnoreCase( request.getParameter("phyd").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("dob") != null ) && ( !request.getParameter("dob").toString().equals("") )  )  // Selected
				{
					 try
					 {
			              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			              Date date1 = sdf.parse(temp[6]);
			              Date date2 = sdf.parse(request.getParameter("date"));
			             
			              if(request.getParameter("dob").toString().equals("before"))
			              {
			                  if( date1.compareTo(date2)>=0 )
			                  {
			                    flag = 1;
			                  }
			               }
			               else if(request.getParameter("dob").toString().equals("on"))
			               {
			                  if(date1.compareTo(date2)!=0)
			                  {
			                     flag = 1;
			                  }
			                }
			               else if(request.getParameter("dob").toString().equals("after"))
			               {
			                  if(date1.compareTo(date2)<=0)
			                  {
	 		                     flag = 1;
			                  }
			                }
			          }
					  catch(ParseException ex)
					  {  
			          }					
				}
				
				if( ( request.getParameter("us6") != null ) && ( !request.getParameter("us6").toString().equals("all") ) && ( !request.getParameter("us4").toString().equals("") )  )
				{
					if( !temp[7].equalsIgnoreCase( request.getParameter("us6").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us7") != null ) && ( !request.getParameter("us7").toString().equals("all") ) && ( !request.getParameter("us4").toString().equals("") )  )
				{
					if( !temp[8].equalsIgnoreCase( request.getParameter("us7").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us8") != null ) && ( !request.getParameter("us8").toString().equals("all") ) && ( !request.getParameter("us4").toString().equals("") )  )
				{
					if( !temp[9].equalsIgnoreCase( request.getParameter("us8").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us9") != null ) && ( !request.getParameter("us9").toString().equals("all") ) && ( !request.getParameter("us9").toString().equals("") )  )
				{
					if( !temp[10].equalsIgnoreCase( request.getParameter("us9").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us10") != null ) && ( !request.getParameter("us10").toString().equals("all") ) && ( !request.getParameter("us10").toString().equals("") )  )
				{
					if( !temp[11].equalsIgnoreCase( request.getParameter("us10").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us11") != null ) && ( !request.getParameter("us11").toString().equals("all") ) && ( !request.getParameter("us11").toString().equals("") )  )
				{
					if( !temp[12].equalsIgnoreCase( request.getParameter("us11").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us12") != null ) && ( !request.getParameter("us12").toString().equals("all") ) && ( !request.getParameter("us12").toString().equals("") )  )
				{
					if( !temp[13].equalsIgnoreCase( request.getParameter("us12").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us15") != null ) && ( !request.getParameter("us15").toString().equals("") )  )
				{
					if( !temp[14].equalsIgnoreCase( request.getParameter("us15").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us16") != null ) && ( !request.getParameter("us16").toString().equals("") )  )
				{
					if( !temp[15].equalsIgnoreCase( request.getParameter("us16").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us13") != null ) && ( !request.getParameter("us13").toString().equals("") ) && ( !request.getParameter("us13").toString().equals("all") )  )
				{
					if( !temp[16].equalsIgnoreCase( request.getParameter("us13").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("us14") != null ) && ( !request.getParameter("us14").toString().equals("") ) && ( !request.getParameter("us14").toString().equals("all") )  )
				{
					if( !temp[17].equalsIgnoreCase( request.getParameter("us13").toString() ) )
					{
					   flag = 1;	
					}					
				}
				if( ( request.getParameter("x_p1") != null ) && ( !request.getParameter("x_p1").toString().equals("") )  )
				{
					if( temp[18].equalsIgnoreCase("null") )
					{
						flag = 1;
					}
					else
					{
						/////////////
						flag2 = -1;
			            /////////////
						if( Float.parseFloat(temp[18])>Float.parseFloat(request.getParameter("x_p_val").toString()) )
						{
							flag2 = 1;
						}	
					}
				}
				if( ( request.getParameter("x_p2") != null ) && ( !request.getParameter("x_p2").toString().equals("") )  )
				{
					if( temp[18].equalsIgnoreCase("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[18])==Float.parseFloat(request.getParameter("x_p_val").toString()) )
						{
							flag2 = 1;
						}	
					}
				}
				if( ( request.getParameter("x_p3") != null ) && ( !request.getParameter("x_p3").toString().equals("") )  )
				{
					if( temp[18].equalsIgnoreCase("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[18])<Float.parseFloat(request.getParameter("x_p_val").toString()) )
						{
							flag2 = 1;
						}	
					}
				}
				if( flag2==-1 )
				{
					flag = 1;
				}
				
				flag2 = 0;
				if( ( request.getParameter("xii_p1") != null ) && ( !request.getParameter("xii_p1").toString().equals("") )  )
				{
					if( temp[19].equalsIgnoreCase("null") )
					{
						flag = 1;
					}
					else
					{
						flag2 = -1;
						if( Float.parseFloat(temp[19])>Float.parseFloat(request.getParameter("xii_p_val").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( ( request.getParameter("xii_p2") != null ) && ( !request.getParameter("xii_p2").toString().equals("") )  )
				{
					if( temp[19].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[19])==Float.parseFloat(request.getParameter("xii_p_val").toString()) )
						{
							flag2 = 1;
						}	
					}
				}
				if( ( request.getParameter("xii_p3") != null ) && ( !request.getParameter("xii_p3").toString().equals("") )  )
				{
					if( temp[19].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[19])<Float.parseFloat(request.getParameter("xii_p_val").toString()) )
						{
							flag2 = 1;
						}	
					}
				}
				if( flag2==-1 )
				{
					flag = 1;
				}
				
				flag2 = 0;
				if( ( request.getParameter("g_m1") != null ) && ( !request.getParameter("g_m1").toString().equals("") )  )
				{
					if( temp[20].equals("null") )
					{
						flag = 1;
					}
					else
					{
							flag2 = -1;
							if( Float.parseFloat(temp[20])>Float.parseFloat(request.getParameter("g_m_val").toString()) )
							{
								flag2 = 1;
							}	
						}
				}	
				if( ( request.getParameter("g_m2") != null ) && ( !request.getParameter("g_m2").toString().equals("") )  )
				{
					if( temp[20].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
					     	flag2 = -1;
						if( Float.parseFloat(temp[20])==Float.parseFloat(request.getParameter("g_m_val").toString()) )
						{
							flag2 = 1;
						}
					} 
				}
				if( ( request.getParameter("g_m3") != null ) && ( !request.getParameter("g_m3").toString().equals("") )  )
				{
					if( temp[20].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
					     	flag2 = -1;
						if( Float.parseFloat(temp[20])<Float.parseFloat(request.getParameter("g_m_val").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( flag2==-1 )
				{
					flag = 1;
				}
				
				flag2 = 0;
				if( ( request.getParameter("pg_p1") != null ) && ( !request.getParameter("pg_p1").toString().equals("") )  )
				{
					if( temp[21].equals("null") )
					{
						flag = 1;
					}
					else
					{
						flag2 = -1;
						if( Float.parseFloat(temp[21])>Float.parseFloat(request.getParameter("pg_val").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( ( request.getParameter("pg_p2") != null ) && ( !request.getParameter("pg_p2").toString().equals("") )  )
				{
					if( temp[21].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[21])==Float.parseFloat(request.getParameter("pg_val").toString()) )
						{
							flag2 = 1;
						}
					}				
				}
				if( ( request.getParameter("pg_p3") != null ) && ( !request.getParameter("pg_p3").toString().equals("") )  )
				{
					if( temp[21].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[21])<Float.parseFloat(request.getParameter("pg_val").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( flag2==-1 )
				{
					flag = 1;
				}
				////////////////////////////////////////////////////////////////////////////////////////////
				flag2 = 0;
				if( ( request.getParameter("gate_p1") != null ) && ( !request.getParameter("gate_p1").toString().equals("") )  )
				{
					if( temp[22].equals("null") )
					{
						flag = 1;
					}
					else
					{
						flag2 = -1;
						if( Float.parseFloat(temp[22])>Float.parseFloat(request.getParameter("gate_pval").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( ( request.getParameter("gate_p2") != null ) && ( !request.getParameter("gate_p2").toString().equals("") )  )
				{
					if( temp[22].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[22])==Float.parseFloat(request.getParameter("gate_pval").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( ( request.getParameter("gate_p3") != null ) && ( !request.getParameter("gate_p3").toString().equals("") )  )
				{
					if( temp[22].equals("null") )
					{
						flag = 1;
					}
					else
					{
						if( flag2==0 )
						{
							flag2 = -1;
						}
						if( Float.parseFloat(temp[22])<Float.parseFloat(request.getParameter("gate_pval").toString()) )
						{
							flag2 = 1;
						}
					}	
				}
				if( flag2==-1 )
				{
					flag = 1;
				}
				
				if( ( request.getParameter("us22") != null ) && ( !request.getParameter("us22").toString().equals("") ) )
				{
					try
			   	    {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        
				        Date date1 = sdf.parse(temp[23]);  // entry date
				        Date date2 = sdf.parse(request.getParameter("us22"));
				        
				        if( date1.compareTo(date2)<0 )   // date1 < date2
		                {
		                   flag = 1;
		                }   
					}
					catch(ParseException ex)
				    {  
			        }	
				}
					
				
				if( ( request.getParameter("us23") != null ) && ( !request.getParameter("us23").toString().equals("") ) )
				{
					try
			   	    {
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				        Date date1 = sdf.parse(temp[23]);   // entry date
				        Date date2 = sdf.parse(request.getParameter("us23")); 
				        
				        if( date1.compareTo(date2)>0 )   // date1 > date2
		                {
		                   flag = 1;
		                }   
					}
					catch(ParseException ex)
				    {  
			        }	
				}	
				
				if( flag==0 )
				{
					out.println("<tr><td>" + temp[2] + "</td><td>" + temp[1] + "</td><td>"
							+ "<a href='Data/" + temp[2] + ".txt' target='_blank'>Open Data</a><br><a target='_blank' href='Sop/" + temp[2]
							+ ".txt'>Open SOP</a><br><a target='_blank' href='Cv/" + temp[2] + ".txt'>Open CV</a></td></tr>");				
				}
			}
			out.println("</table>"); 
			out.println("<a href='http://localhost:8080/adminfinal/tr'>Back</a>");	
	}
}