package cn.huawei.renlianlogin.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
* @program: renlian
*
* @description: 获取用户Token
*
* @author: huangmindong
*
* @create: 2019-02-10 14:47
**/
public class GetTon {

    public static String getToken(){
        BufferedReader bufferedReader=null;
        StringBuffer sb=new StringBuffer();
        //获取token地址
        String authHost="https://aip.baidubce.com/oauth/2.0/token?";
        //百度大脑官网获取的API Key
        String clientId="";
        //百度大脑官网获取的Secret Key
        String clientSecret="";
        String getAccessTokenUrl=authHost
                //1.grant_type为固定参数
                +"grant_type=client_credentials"
                //2.官网获取的API  Key
                +"&client_id="+clientId
                +"&client_secret="+clientSecret;

        try {
            //创建URL网络连接对象
            URL url=new URL(getAccessTokenUrl);
            //打开连接
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            //设置请求方法
            connection.setRequestMethod("GET");
            //进行实际链接
            connection.connect();
            //读取URL的响应
            bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while(bufferedReader.readLine()!=null){
                sb.append(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String token=getToken();
    }
}
