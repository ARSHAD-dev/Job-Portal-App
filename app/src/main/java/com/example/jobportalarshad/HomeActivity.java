package com.example.jobportalarshad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
 private Button buttonalljob;
 private Button buttonpostjob;
 private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonalljob=(Button)findViewById( R.id.btnalljob );
        buttonpostjob=(Button)findViewById( R.id.btnpost );
        toolbar=(Toolbar)findViewById( R.id.toolbar_home );
        setActionBar( toolbar );
        getActionBar().setTitle( "Job Portal" );
        buttonalljob.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(),AlljobpostActivity.class) );

            }
        } );
        buttonpostjob.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(),JobpostActivity.class ) );

            }
        } );
    }
}
