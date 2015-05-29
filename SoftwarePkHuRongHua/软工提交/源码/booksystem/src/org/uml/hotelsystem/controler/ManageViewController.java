package org.uml.hotelsystem.controler;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uml.hotelsystem.dao.TbAccount;
import org.uml.hotelsystem.dao.TbAccountDAO;
import org.uml.hotelsystem.dao.TbGood;
import org.uml.hotelsystem.dao.TbGoodDAO;
import org.uml.hotelsystem.sessionfactory.HibernateSessionFactory;

public class ManageViewController {
	
	private static ManageViewController manageViewController = null;
	private TbGoodDAO tbGoodDAO;
	private TbAccountDAO tbAccountDAO;
	
	private Session session;
	
	private ManageViewController() {

		session = HibernateSessionFactory.getSession();
		tbGoodDAO = new TbGoodDAO();
		tbAccountDAO = new TbAccountDAO();
	}

	public static ManageViewController getInstance() {
		if (manageViewController == null) {
			manageViewController = new ManageViewController();
		}
		return manageViewController;
	}
	
	public ArrayList<TbGood> getAllGood() {

		ArrayList<TbGood> resArr = (ArrayList<TbGood>) tbGoodDAO.findAll();
		return resArr;
	}
	
	public Object[][] arrToListGoodModel(ArrayList<TbGood> goods) {
		Object[][] objects = new Object[goods.size()][4];
		for(int  i = 0 ; i < goods.size() ; i++){
			TbGood good = goods.get(i);
			objects[i][0] = good.getGoodId();
			objects[i][1] = good.getGoodName();
			objects[i][2] = good.getGoodPrice();
			objects[i][3] = good.getGoodUseable();
		}
		return objects;
	}
	
	public boolean addGood(TbGood good){
		Transaction transaction = session.beginTransaction();
		tbGoodDAO.save(good);
		transaction.commit();
		System.out.println("添加物品成功");
		return true;
	}
	
	public boolean removeGood(TbGood good){
		Transaction transaction = session.beginTransaction();
		TbGood instance = tbGoodDAO.findById(good.getGoodId());
		tbGoodDAO.delete(instance);
		transaction.commit();
		System.out.println("删除物品成功");
		return true;
	}
	
	public boolean changeGoodState(TbGood good){
		Transaction transaction = session.beginTransaction();
		TbGood instance = tbGoodDAO.findById(good.getGoodId());
		instance.setGoodUseable(good.getGoodUseable());
		transaction.commit();
		System.out.println("修改物品成功");
		return true;
	}
	
public ArrayList<TbAccount> getAllAccount(){
		
		ArrayList<TbAccount> resArr = (ArrayList<TbAccount>)tbAccountDAO.findAll();
		return resArr;
	}
	
	public Object[][] arrToListAccountModel(ArrayList<TbAccount> accounts) {
		Object[][] objects = new Object[accounts.size()][6];
		for(int  i = 0 ; i < accounts.size() ; i++){
			TbAccount account = accounts.get(i);
			objects[i][0] = account.getAccountId();
			objects[i][1] = account.getAccountUser();
			objects[i][2] = account.getAccountName();
			objects[i][3] = account.getAccountPassword();
			objects[i][4] = account.getAccountAuthority();
			objects[i][5] = account.getAccountUsable();
		}
		return objects;
	}
	
	public boolean addAccount(TbAccount account){
		Transaction transaction = session.beginTransaction();
		tbAccountDAO.save(account);
		transaction.commit();
		System.out.println("添加用户成功");
		return true;
	}
	
	public boolean removeAccount(TbAccount account){
		Transaction transaction = session.beginTransaction();
		TbAccount instance = tbAccountDAO.findById(account.getAccountId());
		tbAccountDAO.delete(instance);
		transaction.commit();
		System.out.println("删除用户成功");
		return true;
	}
	
	public boolean changeAccountState(TbAccount account){
		Transaction transaction = session.beginTransaction();
		TbAccount instance = tbAccountDAO.findById(account.getAccountId());
		instance.setAccountUsable(account.getAccountUsable());
		transaction.commit();
		System.out.println("修改用户成功");
		return true;
	}
	
}
