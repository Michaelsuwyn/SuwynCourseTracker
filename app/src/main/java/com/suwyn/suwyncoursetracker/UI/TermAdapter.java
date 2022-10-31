package com.suwyn.suwyncoursetracker.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suwyn.suwyncoursetracker.Entity.Term;
import com.suwyn.suwyncoursetracker.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;
        private TermViewHolder(View termView){
            super(termView);
            termItemView=termView.findViewById(R.id.textView2);
            termView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    final Term current = mTerms.get(position);
                    Intent intent = new Intent(context, CourseList.class);
                    intent.putExtra("id", current.getTermID());
                    intent.putExtra("Name", current.getTitle());
                    intent.putExtra("Start Date", current.getStartDate());
                    intent.putExtra("End Date", current.getEndDate());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;

    public TermAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms!=null){
            Term current = mTerms.get(position);
            String name = current.getTitle();
            holder.termItemView.setText(name);
        }
        else {
            holder.termItemView.setText("No Term Name");
        }
    }
    public void setTerms(List<Term> terms){
        mTerms=terms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mTerms!=null){
            return mTerms.size();
        }
        else {
            return 0;
        }
    }
}
