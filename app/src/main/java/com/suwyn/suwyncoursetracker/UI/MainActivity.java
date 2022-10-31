package com.suwyn.suwyncoursetracker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.suwyn.suwyncoursetracker.Database.Repository;
import com.suwyn.suwyncoursetracker.Entity.Term;
import com.suwyn.suwyncoursetracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, TermList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Term term = new Term(1, "Test Term One", "10/31/2022", "04/31/2022");
        repo.insert(term);
    }
}