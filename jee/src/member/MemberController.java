package member;

import javax.swing.JOptionPane;

/**
 * @date : 2016. 6. 16.
 * @author : 한상호
 * @file : SchoolController.java
 * @story :
 */
public class MemberController {
	public static void main(String[] args) { // String[] params
    MemberService service = MemberServiceImpl.getInstance();
    int ok = 0;
		
		while (true) {
			switch (JOptionPane.showInputDialog("---회원이 보는 화면---\n"
					+"1회원가입 2로그인 3내정보보기(detail) 4내정보수정(비번) 5탈퇴 0종료\n"
					+"---관리자 화면---\n"
					+"11회원목록 12검색(ID) 13검색(이름) 14회원수(성별) 15회원수")) {
			case "1":
				MemberBean stu = new MemberBean();
				String input =JOptionPane.showInputDialog("ID,PW,이름,주민번호");
				String[] inputArr = input.split(",");
				stu.setId(inputArr[0]);
				stu.setPw(inputArr[1]);
				stu.setName(inputArr[2]);
				stu.setSsn(inputArr[3]);
				stu.setRegDate();
				String result = service.regist(stu);
				JOptionPane.showMessageDialog(null, result);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.show());
				break;
			case "4":
				MemberBean stu2 = new MemberBean();
				String input2 =JOptionPane.showInputDialog("변경할 ID,PW");
				String[] inputArr2 = input2.split(",");
				stu2.setId(inputArr2[0]);
				stu2.setPw(inputArr2[1]);
				String result2 = service.update(stu2);
				JOptionPane.showMessageDialog(null, result2);
                break;
			case "5":
				String result3 = service.delete(JOptionPane.showInputDialog("삭제하려는 ID?"));
				JOptionPane.showMessageDialog(null, result3);
				break;
			case "12":
				String findID = JOptionPane.showInputDialog("조회할 ID?");
				JOptionPane.showMessageDialog(null, service.findById(findID));
				break;
			case "11":
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "13":
				String findName = JOptionPane.showInputDialog("조회할 이름?");
				JOptionPane.showMessageDialog(null, service.findBy(findName));
				break;
			case "14":
				break;
			case "15":
				int count =  service.count();
				JOptionPane.showMessageDialog(null, count+"명");
				break;
			case "0":
				ok = JOptionPane.showConfirmDialog(null, "Close OK?");
				if (ok == 0) {
					return;
				} else {
					continue;
				}
				
			default:
				return;
			}
		}
	}
}
