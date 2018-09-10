import com.jingsky.util.common.DBUtil;
import org.json.JSONObject;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jing on 1/6/17.
 */
public class MyTest {

    @Test
    public void a(){
        DBUtil dbUtil=DBUtil.getInstance("com.mysql.jdbc.Driver","jdbc:mysql://rm-bp1199mw7hkop7ad1o.mysql.rds.aliyuncs.com:3306/kaishi_user?useUnicode=true&characterEncoding=utf8",
                "kaishi","haoyun","asas");
        int i=0;
        try {
            List<Map<String,Object>> list=dbUtil.query("select json from user limit 10000");
            System.out.println(list.size()+" list");
            int now=0;
            for(Map<String,Object> map : list){
                System.out.println("剩余"+(list.size()-(now++)));
                String json=map.get("json").toString();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    //System.out.println(json);
                    if(jsonObject.getJSONObject("info").getLong("dueDate")>new Date().getTime()){
                        //是否有宝宝
                        String babySql="select count(*) from i_userbaby_userid where userId='"+jsonObject.getString("id")+"'";
                        System.out.println(babySql);
                        List<Map<String,Object>> numList=dbUtil.query(babySql);
                        int num=Integer.parseInt(numList.get(0).get("count(*)").toString());
                        if(num>0){
                            System.out.println("找到："+(++i));
                        }
                    }else{
                        //System.out.println(jsonObject.getJSONObject("info").getLong("dueDate"));
                    }
                }catch (Exception e){
                    //e.printStackTrace();;
                }
            }

            System.out.println("找到："+(++i));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
