package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;

public class MemberDAO {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;   // executeQuery() 에서만 리턴받는 객체
    PreparedStatement pstmt = null;
    
    private static MemberDAO instance = new MemberDAO();
    
    public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	public int insert(MemberBean mem){
		String sql ="insert into member(id,pw,name,reg_date,ssn)"+"values('"+mem.getId()+"','"+mem.getPw()+"','"+mem.getName()+"','"+mem.getRegDate()+"','"+mem.getSsn()+"')";
        return exeUpdate(sql);		
	}
    public int update(MemberBean mem){
    	 String sql = "update member set pw = '"+mem.getPw()+"' where id = '"+mem.getId()+"'"; 
    	 return exeUpdate(sql);
    }
    public int delete(String id){
    	String sql = "delete from member where id = '"+id+"'";
    	return exeUpdate(sql);
    }
	public int exeUpdate(String sql) {
       int result = 0;
       
       try {
		Class.forName(Constants.ORACLE_DRIVER);
		con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
		stmt = con.createStatement();
		result = stmt.executeUpdate(sql);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       if (result==1) {
		System.out.println("성공");
	} else {
        System.out.println("실패");
	}
       return result;
	}

	public List<?> list() {
		String sql = "select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
		    rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		        MemberBean t = new MemberBean(
		    			  rs.getString("ID"),
			              rs.getString("PW"),
			              rs.getString("NAME"),
			              rs.getString("SSN"));
		    	t.setRegDate(rs.getString("REG_DATE"));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return list;
	}
    // list
	public MemberBean findById(String pk) {
		String sql = "select * from member where id = '"+pk+"'";
		MemberBean temp = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
		con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			temp = new MemberBean(rs.getString("ID"),
					              rs.getString("PW"),
					              rs.getString("NAME"),
					              rs.getString("SSN"));
			temp.setRegDate(rs.getString("REG_DATE"));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return temp;
	}
    // findByPK
	public List<?> findByName(String name) {
		String sql = "select * from member where name = '"+name+"'";
		List<MemberBean> temp = new ArrayList<MemberBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
		con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			 MemberBean t = new MemberBean(
	    			  rs.getString("ID"),
		              rs.getString("PW"),
		              rs.getString("NAME"),
		              rs.getString("SSN"));
	    	t.setRegDate(rs.getString("REG_DATE"));
	    	temp.add(t);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return temp;
	}
    // findByNotPK
	public int count() {
	String sql ="select count(*) as count from member";
	int count = 0;
	try {
		Class.forName(Constants.ORACLE_DRIVER);
	    con = DriverManager.getConnection(
	    		Constants.ORACLE_URL,
				Constants.USER_ID,
				Constants.USER_PW);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			count = rs.getInt("count");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
    return count;
	}
	// count
	public boolean login(MemberBean member) {
		boolean loginOk = false;
		MemberBean m = this.findById(member.getId());
		if (m.getPw().equals(member.getPw())) {
			loginOk = true;
		}
		return loginOk;
	}

}
