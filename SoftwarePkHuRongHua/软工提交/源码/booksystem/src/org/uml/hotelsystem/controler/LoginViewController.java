package org.uml.hotelsystem.controler;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.uml.hotelsystem.sessionfactory.HibernateSessionFactory;

public class LoginViewController {
	
	private static LoginViewController instance = null;
	
	private Session session;
	private String FIND_USABLE = "select account_usable from tb_account where account_user = '%s' and account_password = '%s'";
	private String FIND_AUTHORITY = "select account_authority from tb_account where account_user = '%s' and account_password = '%s'";
	
	private LoginViewController(){
		session = HibernateSessionFactory.getSession();
	}
	
	public static synchronized LoginViewController getInstance() {
		if (instance == null) {
			instance = new LoginViewController();
		}
		return instance;
	}
	
	public int login(String username,String password){
		String querySql_usable = String.format(FIND_USABLE,username,password);
		SQLQuery query_usable = session.createSQLQuery(querySql_usable);
		if(query_usable.list().size() == 0){
			return 10;
		}else{
			if(String.valueOf(query_usable.list().get(0)).equals("false")){
				return 11;
			}else{
				String querySql_authority = String.format(FIND_AUTHORITY,username,password);
				SQLQuery query_authority = session.createSQLQuery(querySql_authority);
				if(String.valueOf(query_authority.list().get(0)).equals("0")){
					return 0;
				}else{
					return 1;
				}
			}
		}
	}

}
