package member;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

/**
 * @date   :2016. 6. 16. 
 * @author :한상호
 * @file   :Student.java
 * @story  :
*/
public class MemberBean {
	private String id,pw,name,regDate,gender,ssn; 
	private int birth;
	
	public MemberBean() {}
	
	public MemberBean(String id,String pw,String name,String ssn) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ssn = ssn;
		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.regDate = now;
		String[] ssnArr = ssn.split("-");
		String[] nowArr = now.split("-");
		int ageResult1 = (Integer.parseInt(ssnArr[0]));
		int genderResult = (Integer.parseInt(ssnArr[1]));
		int ageResult2 = (Integer.parseInt(nowArr[0]));
		int ageResult0 = 0;
		switch (genderResult%2) {
		case 1: case 5: 
			this.gender="남"; 
			ageResult0 = ageResult2 - 1900-(ageResult1/10000);
			this.birth = ageResult0;
			break;
		case 3: case 7:
			this.gender="남"; 
			ageResult0 = ageResult2 - 2000-(ageResult1/10000);
			this.birth = ageResult0;
			break;
		case 2: case 6:
			this.gender="여";
			ageResult0 = ageResult2 - 1900-(ageResult1/10000);
			this.birth = ageResult0;
			break;
		case 4: case 8:
			this.gender="여";
			ageResult0 = ageResult2 - 2000-(ageResult1/10000);
			this.birth = ageResult0;
			break;
		default:
			System.out.println("잘못된값이 입력됨");
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));;
	}
	public void setRegDate(String regDate){
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String toString() {
		return "학생 [아이디=" + id + ", 비번=" + pw  + ", 이름=" + name + ", 등록일=" + regDate + ", 성별=" + gender
				+ ", 주민번호=" + ssn + ", 나이=" + birth + "]";
	}
	

}