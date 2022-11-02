package com.suwyn.suwyncoursetracker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.suwyn.suwyncoursetracker.Database.Repository;
import com.suwyn.suwyncoursetracker.Entity.Course;
import com.suwyn.suwyncoursetracker.Entity.Term;
import com.suwyn.suwyncoursetracker.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, TermList.class);
        startActivity(intent);
//        Repository repo = new Repository(getApplication());
//        Term term = new Term(1, "Test Term One", "10/31/2022", "04/31/2022");
//        Term termTwo = new Term(2, "Test Term Two", "10/31/2022", "04/31/2022");
//        Course course = new Course(1, "Course One", "10/31/2022", "12/31/2022","In Progress","Test Instructor", "test@test.com", "4809999122", "Optional note", 1);
//        repo.insert(termTwo);
//        repo.insert(course);
    }
}