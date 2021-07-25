package com.example.a5th;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private List<Article> articleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initArticles();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArticleAdapter adapter = new ArticleAdapter(articleList);
        recyclerView.setAdapter(adapter);
    }
    private void initArticles(){
        Article article1= new Article("一剑封喉！国服夏洛特金剑绝杀 孙一文夺中国奥运第三金","一剑封喉！国服夏洛特金剑绝杀 孙一文夺中国奥运第三金");
        articleList.add(article1);
        Article article2 = new Article("中国第4金！跳水无愧梦之队，施廷懋王涵双人3米板一路领跑夺冠","北京时间7月25日，东京奥运会跳水比赛启幕，有梦之队之称的中国跳水队拿到开门红。在女子双人3米板比赛里，施廷懋/王涵凭借稳定发挥一路领跑，她们以326.40分夺取该项目金牌。这是中国队在本届奥运会的第4金。施廷懋成功卫冕该项目冠军，她也拿到个人第3枚奥运金牌。王涵则是第一次站上了奥运会的最高领奖台。");
        articleList.add(article2);
        Article article3= new Article("中国女排七仙女首发，土耳其“表弟”发威，首局中国队21-25告负","北京时间7月25日下午15点25分，东京奥运会中国女排与土耳其的比赛打响。首局比赛，中国队没能抑制住“表弟”卡拉库尔特的火力，以21-25告负。");
        articleList.add(article3);
        Article article4 = new Article("奥运头条｜郭晶晶新工作是给裁判打分，跳水举重女排今日登场","7月24日，奔赴东京奥运会参加工作的郭晶晶现身东京水上运动中心。在接受采访时，郭晶晶透露了自己的新工作，这一次她主要是给裁判打分，而并非此前传出的给运动员评分。");
        articleList.add(article4);
    }

}