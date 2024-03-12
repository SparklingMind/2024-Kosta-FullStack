package app.mvc.session;

import java.util.HashSet;
import java.util.Set;

public class SessionSet {//싱글톤

	private static SessionSet ss = new SessionSet();
	private Set<Session> set; //set은 로그인한 각 사용자의 세션정보가 들어있으므로 중복 안 되고 순서없는 자료구조인 set을 사용한다.
	
	private SessionSet() {
		set = new HashSet<>();
	}
	
	public static SessionSet getInstance() {//SessionSet.getInstance()와 같은 형태로 호출해서 SessionSet 리턴받는다.
		return ss;
	}
	
	
	/**
	 * 사용자 찾기
	 * */
	
	public Session get(String sessionId) {
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	//모든 세션 객체(로그인된 사용자들) 반환
		public Set<Session> getSet(){
			return set;
		}
	
		/**
		 * 로그인 된 사용자 추가
		 * */
		public void add(Session session) {
			set.add(session);
		}
		
	/**
	 * 사용자 제거 - 로그아웃
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
	
	
}
