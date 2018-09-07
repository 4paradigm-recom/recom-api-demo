package material;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tools.HttpTools;

public class MaterialService {
    // 物料的访问token，不同的accessToken对应不同的物料集
    private static String accessToken = "407265caafcb4c31bf9dbfb6b3b1ed32";
    private static String saveUrl = "https://nbrecsys.4paradigm.com/business/items?source=1&accessToken="+accessToken;
    // type表示查询类型 : 1-itemId；2-url
    private static String searchUrl = "https://nbrecsys.4paradigm.com/business/items/search?type=1&accessToken="+accessToken;
    // type表示删除类型 : 1-itemId；2-url
    private static String deleteUrl = "https://nbrecsys.4paradigm.com/business/items/remove?type=1&accessToken="+accessToken;
    
    public static void save(){
        // 做多一次可以上报100条
        JSONArray materials = new JSONArray();
        JSONObject material = new JSONObject();
        material.put("itemId", "1234567");//物料ID,物料唯一标识
        material.put("title", "测试物料");
        material.put("content", "物料内容");
        material.put("url", "http://www.material.com/1234567");//物料链接，物料库中唯一
        material.put("categoryId", "科技,计算机");
        material.put("publishTime", System.currentTimeMillis());//物料发布时间，毫秒级时间戳
        material.put("publisherId", "测试作者");
        material.put("isRecommend", 1);
        material.put("tag", "iOS,客户端");
        material.put("coverUrl", "http://www.coverUrl.com");//物料封面链接
        material.put("location", "用户地址");
        materials.add(material);
        
        System.out.println("物料上报内容："+material.toJSONString());
        String result = HttpTools.post(saveUrl, materials.toJSONString(), HttpTools.HTTP_TIMEOUT_MS);
        System.out.println("返回结果为："+result);
    }
    
    public static void search(){
        JSONArray itemIds = new JSONArray();
        itemIds.add("123456");
        itemIds.add("1234567");
        
        System.out.println("物料查询itemIds："+itemIds.toJSONString());
        String result = HttpTools.post(searchUrl, itemIds.toJSONString(), HttpTools.HTTP_TIMEOUT_MS);
        System.out.println("返回结果为："+result);
    }
    
    public static void delete(){
        JSONArray itemIds = new JSONArray();
        itemIds.add("123456");
        itemIds.add("1234567");
        
        System.out.println("物料查询itemIds："+itemIds.toJSONString());
        String result = HttpTools.post(deleteUrl, itemIds.toJSONString(), HttpTools.HTTP_TIMEOUT_MS);
        System.out.println("返回结果为："+result);
    }
    
    public static void main(String[] args) {
        save();
        search();
        delete();
    }
}
