package com.example.a5th;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> mArticleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView articleTitle, articleContent;

        public ViewHolder(View view) {
            super(view);
            articleTitle = (TextView) view.findViewById(R.id.tv_title);
            articleContent = (TextView) view.findViewById(R.id.tv_content);
        }
    }

    public ArticleAdapter(List<Article> articleList) {
        mArticleList = articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = mArticleList.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleContent.setText(article.getContent());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

}
