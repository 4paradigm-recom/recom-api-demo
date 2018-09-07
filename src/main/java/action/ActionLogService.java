package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tools.HttpTools;

public class ActionLogService {
    
    // 商家的clientToken
    private static String clientToken = "730eb3d190664a34a2cb83172f52b729";
    private static String url = "https://nbrecsys.4paradigm.com/action/api/log?clientToken=" + clientToken;
    
    public static void log(){
        JSONObject json = new JSONObject();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        json.put("date", time);
        
        JSONArray actions = new JSONArray();
        json.put("actions", actions);
        
        JSONObject action = new JSONObject();
        action.put("itemId", "123456");
        action.put("userId", "testUser");
        action.put("actionTime", System.currentTimeMillis());// 改行为触发时间，毫秒级时间戳
        action.put("requestId", "requestId");
        action.put("action", "show");// 行为事件：show\detailPageShow\collect\share\follow\like\dislike\duration        
        action.put("sceneId", 1);// 场景ID
        action.put("context", "I3WxRlJ4lbMLXZB7il18GRkqDfKdmQ1Xs1esaP8VbfMTk5GKscGAwYkxS277bjzADjEeWh8H");//推荐物料中，携带的context内容
        actions.add(action);
        
        System.out.println("日志上报内容为：" + json.toJSONString());
        String result = HttpTools.post(url, json.toJSONString(), HttpTools.HTTP_TIMEOUT_MS);
        System.out.println("返回结果为："+result);
    }
    
    public static void main(String[] args) {
        log();
    }
}

