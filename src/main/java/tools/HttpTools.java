package tools;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class HttpTools {
    
    public static int HTTP_TIMEOUT_MS = 4000;

    public static String get(String url, int timeoutMs) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            RequestConfig requestConfig =
                    RequestConfig.custom().setConnectionRequestTimeout(timeoutMs)
                            .setConnectTimeout(timeoutMs).setSocketTimeout(timeoutMs).build();
            get.setConfig(requestConfig);
            get.setHeader("Content-type", "application/json;charset=utf-8");
            HttpResponse response = client.execute(get);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (Exception e) {
            System.out.println("postForResponse error, url:" + url + ", ex:" + e);
        }
        return "";
    }

    public static String post(String url, String jsonContent, int timeoutMs) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            RequestConfig requestConfig =
                    RequestConfig.custom().setConnectionRequestTimeout(timeoutMs)
                            .setConnectTimeout(timeoutMs).setSocketTimeout(timeoutMs).build();
            post.setConfig(requestConfig);
            post.setHeader("Content-type", "application/json;charset=utf-8");
            StringEntity se = new StringEntity(jsonContent, ContentType.APPLICATION_JSON);
            post.setEntity(se);
            HttpResponse response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (Exception e) {
            System.out.println("postForResponse error, url:" + url + ", content:" + jsonContent + "ex:" + e);
        }
        return "";
    }
}
