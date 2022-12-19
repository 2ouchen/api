package com.example.api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Posts> postsListAdapter;
    Context context;

    public PostAdapter(List<Posts> postsList , Context context) {
        this.postsListAdapter = postsList;
        this.context=context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
            return  new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {

        holder.mytitle.setText(postsListAdapter.get(position).getTitle());
        holder.mDescription.setText(postsListAdapter.get(position).getBody());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("atitle",postsListAdapter.get(position).getTitle());
                intent.putExtra("adescription",postsListAdapter.get(position).getBody());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postsListAdapter.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView mytitle;
        TextView mDescription;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mytitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            cardView=itemView.findViewById(R.id.cards);

        }
    }
}
