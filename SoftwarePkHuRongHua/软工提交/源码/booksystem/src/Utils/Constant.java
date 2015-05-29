package Utils;

import org.uml.hotelsystem.dao.TbAccount;

public class Constant {
	public static String[] ROOM_STATE = new String[] { "空闲", "已预约", "已入住",
			"不可用" };
	
	public static String[] ROOM_TYPE = new String[]{"普通房","大床房","单人房","豪华套房"};
	
	public static TbAccount curLoginAccount = new TbAccount("ADMIN", "王二麻子", "123456", 1, true);
	
	static{
		curLoginAccount.setAccountId(1);
	}
	
	public static String[] images = new String[]{"images\\room_free.png","images\\room_used.png","images\\room_cannotbeused.png"};
}
