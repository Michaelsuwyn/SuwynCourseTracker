package com.suwyn.suwyncoursetracker.UI;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suwyn.suwyncoursetracker.Entity.Course;
import com.suwyn.suwyncoursetracker.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
   class CourseViewHolder extends RecyclerView.ViewHolder{
       private final TextView courseItemView;
       private CourseViewHolder(View courseView){
           super(courseView);
           courseItemView=courseView.findViewById(R.id.textView3);
           courseView.setOnClickListener(new View.OnClickListener(){

               @Override
               public void onClick(View view) {
                   int position = getAdapterPosition();
                   final Course current = mCourses.get(position);
                   Intent intent = new Intent(context, AssessmentList.class);
                   intent.putExtra("id", current.getCourseID());
                   intent.putExtra("Name", current.getTitle());
                   context.startActivity(intent);

               }
           });
       }
   }
   private List<Course> mCourses;
   private final Context context;
   private final LayoutInflater mInflater;

   public CourseAdapter(Context context){
       mInflater= LayoutInflater.from(context);
       this.context=context;
   }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
       return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses!=null){
            Course current = mCourses.get(position);
            String name = current.getTitle();
            holder.courseItemView.setText(name);
        }
        else {
            holder.courseItemView.setText("No Course Found");
        }
    }

    public void setCourses(List<Course> courses){
       mCourses=courses;
       notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       if(mCourses!=null){
           return mCourses.size();
       }
       else{
           return 0;

       }
    }
}
