package Login.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Login.Member;
import Login.Data.IMembershipManage;
import Login.Data.MembershipManageImpl;

public class MembershipServiceImpl implements MembershipService {
	IMembershipManage membershipManage;
	@Override
	public boolean comparePW(String pw, String pwOk) {
		/*
		 * if(!pw.contentEquals(pwOk)) return true; return false;
		 */
		return pw.contentEquals(pwOk);
	}




	@Override
	public boolean MembershipProc(Member member) {
		IMembershipManage membershipManage = new MembershipManageImpl();
		return membershipManage.MembershipProc(member);
	}




	@Override
	public Map<String, String> getMember() {
		IMembershipManage membershipManage =new MembershipManageImpl();
		List<Member> lstMember =membershipManage.getMember();
		Map<String, String> mapMember =new HashMap<String, String>();
		
		for(Member member : lstMember)
			mapMember.put(member.getId(), member.getName());
		
		return mapMember;
	}

}











