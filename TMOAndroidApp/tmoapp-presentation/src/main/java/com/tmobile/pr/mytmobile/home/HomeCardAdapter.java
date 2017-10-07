package com.tmobile.pr.mytmobile.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.model.Model;

import java.util.List;

/**
 * Created by jonegalado on 10/4/17, Gimmyo Project.
 */

public class HomeCardAdapter extends RecyclerView.Adapter<HomeCardAdapter.ViewHolder> {

    private List<Model> mDataSet;
    private int viewWidth;
    private int viewHeight;

    public HomeCardAdapter(List<Model> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public HomeCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hello_world_card, parent, false);

        ViewTreeObserver viewTreeObserver = itemView.getViewTreeObserver();
        if(viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewWidth = itemView.getWidth();
                    viewHeight = itemView.getMeasuredHeight();
                }
            });
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeCardAdapter.ViewHolder holder, int position) {
        Model model = mDataSet.get(position);
        holder.titlemessage.setText(model.getTitle());
        holder.body.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titlemessage, body;

        public ViewHolder(View itemView) {
            super(itemView);

            titlemessage = itemView.findViewById(R.id.card_title);
            body = itemView.findViewById(R.id.card_body);
        }
    }

    public int getViewHeight() {
        return viewHeight;
    }
}
