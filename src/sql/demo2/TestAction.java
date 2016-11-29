package sql.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sql.demo2.action.GoddessAction;
import sql.demo2.model.Goddess;

/**
 * 
 * @author 模型层，通过Test调用
 *
 */
public class TestAction {
	public static void main(String[] args) throws Exception {
		GoddessAction action = new GoddessAction();

		// //查询query
		// MyList<Goddess> result = action.query();
		//
		// for (int i = 0; i < result.size(); i++) {
		// System.out.println(result.get(i).getId()+
		// ":"+result.get(i).getUser_name()); }
		//

		// //add
		// Goddess g = new Goddess(); g.setUser_name("小青"); g.setSex(1);
		// g.setAge(25); g.setBirthday(new Date());
		// g.setEmail("xiaqing@qq.com"); g.setMobile("15688888888");
		// g.setIsdel(0); action.add(g);
		//

		// //update---edit方法
		// Goddess g = new Goddess(); g.setUser_name("小青1");
		// g.setSex(1); g.setAge(25); g.setBirthday(new Date());
		// g.setEmail("xiaqing@qq.com"); g.setMobile("15688888888");
		// g.setIsdel(0); g.setId(4); action.edit(g);
		//

		// 使用List，Map优化查询
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小美'");
		params.add(map);
		List<Goddess> result = action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + ":" + result.get(i).getUser_name());
		}
	}
}
