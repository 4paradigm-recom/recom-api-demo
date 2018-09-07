package recall;

import com.alibaba.fastjson.JSONObject;

import tools.HttpTools;

public class RecallService {
    
    // requestID:请求id，随机的字符串
    // sceneID:场景ID
    // userId:用户ID，能标识用户的唯一值
    private static final String url = "https://nbrecsys.4paradigm.com/api/v0/recom/recall?requestID=wsctsemv48&sceneID=440&userID=ox1yfwmi55";

    public static void recall(){

        JSONObject postJson = new JSONObject();
        postJson.put("page", 0);
        // 相关推荐，需要提交一个物料的ID - itemID
        postJson.put("itemID", "27717ef240af3664ea3a879f17164f78");
        
        System.out.println("查询物料数据为：" + postJson.toJSONString());
        String result = HttpTools.post(url, postJson.toJSONString(), HttpTools.HTTP_TIMEOUT_MS);
        System.out.println("返回结果为："+result);
    }
    
    public static void main(String[] args) {
        recall();
    }
}
