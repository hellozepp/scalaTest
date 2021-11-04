package myscala.jettyTest.JettyReceiveHttpMsg;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class JettyReceive extends AbstractHandler {

    @Override
    public void handle(String url, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
        // 验证url是否合法
        try {
            String[] tp = url.split("/");
            if (tp.length < 2) {
                try {
                    response.sendError(404);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 验证请求ip是否在白名单之内（ip过滤）

            // 判断请求类型，并进行对应操作,注意最好放到其他类中进行，以提高响应速度。
            String s = tp[2];
            switch (s) {
                case "test":
                    try {
                        System.out.println(url);
                        System.out.println(getIpAdrress(request));
                        System.out.println(getBodyDate(request));
                        out(response, "ok");
                    } catch (Exception e) {
                        out(response, "error");
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void out(HttpServletResponse response, String content) {
        OutputStream ops = null;
        try {
            ops = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            ops.write(content.getBytes());
            ops.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ops != null) {
                try {
                    ops.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    // 从请求中获取数据
    public String getBodyDate(HttpServletRequest request) {
        String bodyStr = null;
        BufferedReader br = null;

        try {
            // 设置编码
            request.setCharacterEncoding("UTF-8");
            // 创建输入流
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            // 获取body内容
            String line = "";
            StringBuffer buf = new StringBuffer();
            while ((line = br.readLine()) != null) {
                buf.append(line);
            }
            bodyStr = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bodyStr;
    }

    /**
     * 获取request的客户端IP地址
     *
     * @param request
     * @return
     */
    private static String getIpAdrress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}