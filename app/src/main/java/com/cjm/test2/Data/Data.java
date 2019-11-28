package com.cjm.test2.Data;

import com.cjm.test2.R;
import com.cjm.test2.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjm on 2019/6/13.
 */

public class Data {
    private List<News> datas=new ArrayList<>();
    public List<News> setDatas(){
        News news;
        for (int i = 0; i <= 15; i++) {
            news = new News();
            news.setTitle("浙科志愿者服务世界环境日全球主题活动");
            news.setText("6月4日，2019年世界环境日·中国环境与发展国际合作委员会年会安吉现场交流活动在安吉县举行，安吉校区15名青年志愿者参与本次现场交流活动。志愿者们积极宣传习近平总书记“绿水青山就是金山银山”发展理念，助力生态文明建设中国方案、浙江样本走向世界。\n" +
                    "\n" +
                    "此次，我校从外国语/中德学院、中德工程师学院选拔学生担任志愿者。根据任务分工，他们负责外宾辅助翻译讲解及现场引导工作。志愿者们守时守纪、团结协作，以高尚的品格、清新的气质、专业的素质，代表浙江喜迎五洲来客，细致周到的服务得到主办方以及参会嘉宾的点赞。（安吉校区学生事务中心 贾晓龙/文）");
            news.setSource("新浪新闻");
            news.setImageViewUrl(R.mipmap.ic_news);
            news.setTime(1234124);
            datas.add(news);
        }
        return datas;
    }
}
