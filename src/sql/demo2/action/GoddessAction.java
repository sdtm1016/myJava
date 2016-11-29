package sql.demo2.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import sql.demo2.dao.GoddessDao;
import sql.demo2.model.Goddess;

/**
 * 
 * @author 控制层，声明add，get，edit，del，query，通过这些方法分级传递调用底层
 *
 */
public class GoddessAction {
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		goddess.setSex(1);
		goddess.setCreate_user("ADMIN");
		goddess.setUpdate_user("ADMIN");
		goddess.setIsdel(0);
		
		dao.addGoddess(goddess);
	}
	
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	public void edit(Goddess goddess) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	public void del(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);;
	}
	
	public List<Goddess> query() throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.query();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}

	// public static void main(String[] args) throws Exception {
	// GoddessDao g = new GoddessDao();
	//
	// MyList<Goddess> gs = g.query();
	//
	// for (Goddess goddess : gs) {
	// System.out.println(goddess.getUser_name()+","+goddess.getAge());
	// }
	//
	//
	// //addGoddess
	// Goddess g1 = new Goddess();
	// g1.setUser_name("小夏");
	// g1.setAge(22);
	// g1.setSex(1);
	// g1.setBirthday(new Date());
	// g1.setEmail("xiaoxia@qq.com");
	// g1.setMobile("18536442233");
	// g1.setCreate_user("ADMIN");
	// g1.setUpdate_user("ADMIN");
	// g1.setIsdel(1);
	//
	// g.addGoddess(g1);
	//
	// //update
	// Goddess g1 = new Goddess();
	// g1.setUser_name("小王");
	// g1.setSex(1);
	// g1.setAge(21);
	// g1.setBirthday(new Date());
	// g1.setEmail("xiaoxia@qq.com");
	// g1.setMobile("18536446666");
	// g1.setUpdate_user("ADMIN");
	// g1.setIsdel(4);
	// g1.setId(3);
	// g.updateGoddess(g1);
	//
	//
	// //del
	// Goddess g1 = new Goddess();
	// g.delGoddess(3);
	//
	// //get
	// Goddess g2 = g.get(2);
	// System.out.println(g2.toString());
	//
	// //优化方法调用1
	// MyList<Goddess> result = g.query("小美","18712345678","xiaomei@qq.com");
	// for (int i = 0; i < result.size(); i++) {
	// System.out.println(result.get(i).toString());
	// }
	//
	// //优化方法调用2使用List和Map
	// MyList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
	// Map<String, Object> param = new HashMap<String,Object>();
	// param.put("name", "user_name");
	// param.put("rela", "like");
	// param.put("value", "'%小美%'");
	// params.add(param);
	//
	// param = new HashMap<String,Object>();
	// param.put("name", "mobile");
	// param.put("rela", "=");
	// param.put("value", "'18712345678'");
	// params.add(param);
	// MyList<Goddess> result = g.query(params);
	// for (int i = 0; i < result.size(); i++) {
	// System.out.println(result.get(i).toString());
	// }
	// }

}