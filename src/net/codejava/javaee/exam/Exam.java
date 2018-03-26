package net.codejava.javaee.bookstore;


/**
 * Exam.java
 * This is a model class represents a Exam entity
 * @author www.codejava.net
 *
 */
public class Exam {
	protected int id;
	protected String answer1;
	protected String answer2;
	protected String answer3;
	protected String answer4;
	protected String selected;
	protected String correct;


	public Exam() {
	}

	public Exam(int id) {
		this.id = id;
	}

	public Exam(int id, String answer1, String answer2, String answer3, String answer4, String selected, String correct) {
		this(answer1, answer2, answer3, answer4, selected, correct);
		this.id = id;
	}
	
	public Exam(String answer1, String answer2, String answer3, String answer4, String selected, String correct) {
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.selected = selected;
		this.correct = correct;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setnAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setnAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}

	public void setnAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}

	public void setnAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String ToString(){
		
		return answer1;
	}
}
