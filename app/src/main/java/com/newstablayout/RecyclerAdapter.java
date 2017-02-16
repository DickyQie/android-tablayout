package com.newstablayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by zq on 2017/1/12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AuthorViewHolder> {

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.item, parent, false);
        AuthorViewHolder viewHolder = new AuthorViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AuthorViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 15;
    }


    class AuthorViewHolder extends RecyclerView.ViewHolder {

        TextView mNickNameView;
        TextView mMottoView;
        public AuthorViewHolder(View itemView) {
            super(itemView);

            mNickNameView = (TextView) itemView.findViewById(R.id.tv_nickname);
            mMottoView = (TextView) itemView.findViewById(R.id.tv_motto);

        }
    }
}
