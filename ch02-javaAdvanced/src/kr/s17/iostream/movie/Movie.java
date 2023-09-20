package kr.s17.iostream.movie;

public class Movie {
	/*
	 * [실습]
	 * 1.멤버변수 : 영화제목(name),제작연도(create_year),감독(director),
	 *            배우(actor),장르(genre),상영시간(time)
	 * 2.생성자 : 인자가 없는 생성자, 인자가 있는 생성자
	 * 3.get/set 메서드           
	 */
	private String name;
	private String create_year;
	private String director;
	private String actor;
	private String genre;
	private int time;
	
	public Movie() {}
	public Movie(String name, String create_year, String director,
			              String actor, String genre, int time) {
		this.name = name;
		this.create_year = create_year;
		this.director = director;
		this.actor = actor;
		this.genre = genre;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreate_year() {
		return create_year;
	}
	public void setCreate_year(String create_year) {
		this.create_year = create_year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%d\n", 
				  name, create_year, director, actor, genre, time);
	}
}






