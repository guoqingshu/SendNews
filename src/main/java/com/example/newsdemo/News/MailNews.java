package com.example.newsdemo.News;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class MailNews {

    public String getmsg(String top){


        JSONObject jo=GetNews.result("top");

        //获取data里面的数据
       //JSONObject msg=jo.getJSONObject("data");
       JSONArray msg=jo.getJSONArray("data");
        //展示data里面的数据
       // System.out.println(msg.toString());

        StringBuffer sb=new StringBuffer();
       // String addmsg="";
        for(int i=0;i<msg.size();i++){
            JSONObject jsonmsg=msg.getJSONObject(i);
            String title=jsonmsg.getString("title");
            String date=jsonmsg.getString("date");
            String category=jsonmsg.getString("category");
            String author_name=jsonmsg.getString("author_name");
            String url=jsonmsg.getString("url");
            String thumbnail_pic_s=jsonmsg.getString("thumbnail_pic_s");
            String thumbnail_pic_s02="";
            String thumbnail_pic_s03="";
            if(jsonmsg.has("thumbnail_pic_s02")&jsonmsg.has("thumbnail_pic_s03")){
                 thumbnail_pic_s02=jsonmsg.getString("thumbnail_pic_s02");
                 thumbnail_pic_s03=jsonmsg.getString("thumbnail_pic_s03");
            }
            //System.out.println(title);
            String addmsg="<tr>"+"<td>"+title+"</td>"
                        +"<td>"+date+"</td>"
                        +"<td>"+category+"</td>"
                        +"<td>"+author_name+"</td>"
                        +"<td>"+url+"</td>"
                        +"<td>"+thumbnail_pic_s+"</td>"
                        +"<td>"+thumbnail_pic_s02+"</td>"
                        +"</tr>";
            //System.out.println(addmsg);
            sb.append(addmsg);

        }
            return sb.toString();
    }

    public static void main(String[] args) {
        MailNews mn = new MailNews();
        System.out.println(mn.getmsg("top"));
    }
}
