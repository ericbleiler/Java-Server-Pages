package net.codejava.javaee.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	private List<Exam> exams = new ArrayList<>();

	
	public ExamDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertExam(Exam exam) throws SQLException {
		String sql = "INSERT INTO jspexam (answer1, answer2, answer3, answer4, selected, correct) VALUES (?, ?, ?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, exam.getAnswer1());
		statement.setString(2, exam.getAnswer2());
		statement.setString(3, exam.getAnswer3());
		statement.setString(4, exam.getAnswer4());
		statement.setString(5, exam.getSelected());
		statement.setString(6, exam.getCorrect());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Exam> listAll() throws SQLException {
		List<Exam> listExam = new ArrayList<>();

		String sql = "SELECT * FROM jspexam";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String answer1 = resultSet.getString("answer1");
			String answer2 = resultSet.getString("answer2");
			String answer3 = resultSet.getString("answer3");
			String answer4 = resultSet.getString("answer4");
			String selected = resultSet.getString("selected");
			String correct = resultSet.getString("correct");
			
			Exam exam = new Exam(id, answer1, answer2, answer3, answer4, selected, correct);
			listExam.add(exam);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listExam;
	}
	
	public void setExams(){
		try {
			exams = listAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setExam(){
		
	}
	
	public List<Exam> getExam(){
		return exams;
	}
	public boolean updateExam(Exam exam) throws SQLException {
		String sql = "UPDATE jspexam SET answer1 = ?, answer2 = ?, answer3 = ?, answer4 = ?, selected = ?, correct = ?";
		sql += " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, exam.getAnswer1());
		statement.setString(2, exam.getAnswer2());
		statement.setString(3, exam.getAnswer3());
		statement.setString(4, exam.getAnswer4());
		statement.setString(5, exam.getSelected());
		statement.setString(6, exam.getCorrect());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
}
