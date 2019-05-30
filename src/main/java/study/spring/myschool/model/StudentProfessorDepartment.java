package study.spring.myschool.model;

public class StudentProfessorDepartment extends Student {
	private String dname;
	private String pname;	
	private int limitStart;
	private int listCount;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	@Override
	public String toString() {
		return "StudentProfessorDepartment [dname=" + dname + ", pname=" + pname + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + ", getDname()=" + getDname() + ", getPname()=" + getPname()
				+ ", getLimitStart()=" + getLimitStart() + ", getListCount()=" + getListCount() + ", getStudno()="
				+ getStudno() + ", getName()=" + getName() + ", getUserid()=" + getUserid() + ", getGrade()="
				+ getGrade() + ", getIdnum()=" + getIdnum() + ", getBirthdate()=" + getBirthdate() + ", getTel()="
				+ getTel() + ", getHeight()=" + getHeight() + ", getWeight()=" + getWeight() + ", getDeptno()="
				+ getDeptno() + ", getProfno()=" + getProfno() + "]";
	}
}