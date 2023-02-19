package cn.bugstack.ai;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppApplicationTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885854544282/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "zsxq_access_token=0BB9E723-5956-35D2-C359-0260B22F6C50_7CEAB9989E60F393; zsxqsessionid=b650332d997c1ae0612dec7a039ca70f; abtest_env=product; sensorsdata2015jssdkcross={\"distinct_id\":\"186557c8bbea7d-0a48c6346f10b2-74525476-921600-186557c8bbf989\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"186557c8bbea7d-0a48c6346f10b2-74525476-921600-186557c8bbf989\"}");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/584158812414844/answer");

        post.addHeader("cookie", "zsxq_access_token=0BB9E723-5956-35D2-C359-0260B22F6C50_7CEAB9989E60F393; zsxqsessionid=b650332d997c1ae0612dec7a039ca70f; abtest_env=product; sensorsdata2015jssdkcross={\"distinct_id\":\"186557c8bbea7d-0a48c6346f10b2-74525476-921600-186557c8bbf989\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"186557c8bbea7d-0a48c6346f10b2-74525476-921600-186557c8bbf989\"}");
        /*1、格式要求注意*/
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"一边凉快去！\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
