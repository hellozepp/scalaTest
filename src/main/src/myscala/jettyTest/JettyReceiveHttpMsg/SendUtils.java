package myscala.jettyTest.JettyReceiveHttpMsg;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SendUtils {

    public static void main(String[] args) {
        String result = executeUrlOfPost("http://127.0.0.1:12345/stalin/test", "{\"name\":\"stalin\"}");
        System.out.println("server result :" + result);
    }

    // 发送get请求
    public static String executeUrl(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            // 设置连接超时时间，获取连接的超时时间，获取数据的超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() != 200) {
                return null;
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    // 发送post请求
    public static String executeUrlOfPost(String url, String data) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            // 设置连接超时时间，获取连接的超时时间，获取数据的超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(data, "UTF-8"));

            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != 200) {
                return null;
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    // 发送post请求并将响应的数据解压缩
    public static String executeUrlOfPostForGzip(String url, String data) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            // 设置连接超时时间，获取连接的超时时间，获取数据的超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(data, "UTF-8"));

            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != 200) {
                return null;
            }

            HttpEntity entity = new GzipDecompressingEntity(response.getEntity());
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

}
