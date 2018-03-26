package net.codejava.javaee.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExamDAO examDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		examDAO = new ExamDAO(jdbcURL, jdbcUsername, "root");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			
			case "/update":
				update(request, response);
				break;
			case "/finish":
				update(request, response);
				break;
			case "/clear":
				clear(request, response);
				break;
			default:
				list(request, response);
				examDAO.setExams();
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		  int page = 1;
          int recordsPerPage = 5;
  		  List<Exam> listExam = examDAO.listAll();

          if(request.getParameter("page") != null)
              page = Integer.parseInt(request.getParameter("page"));
          List<Exam> list = getCurrentPageRecords(listExam,page);
          int noOfRecords = examDAO.listAll().size();
          int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
          request.setAttribute("listExam", list);
          request.setAttribute("noOfPages", noOfPages);
          request.setAttribute("currentPage", page);
          
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}
	
	
	 public List<Exam> getCurrentPageRecords(List<Exam> totalList,int currentPageNo) {
		  if (totalList==null) {
			  return null;
		  }
		  	int startIndex = (currentPageNo-1)*5;
		  	int endIndex = (startIndex+5>totalList.size() ? totalList.size() : startIndex+5);
		  return totalList.subList(startIndex,endIndex);
		 }
	 

		private void update(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String question = request.getParameter("id");
			String selected = request.getParameter("selected");
			String correct = request.getParameter("correct");  		 
			
			List<Exam> listExam = examDAO.getExam();
			
			System.out.println(listExam.get(1).ToString());

		}

}
