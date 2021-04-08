package com.example.jobportalarshad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.jobportalarshad.Database.data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class InsertjobActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText etjobtitle;
    private EditText etjobdesc;
    private EditText etskill;
    private EditText etsal;
    private Button btn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference jobpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_insertjob );
        toolbar=(Toolbar)findViewById( R.id.toolbarinsert );
        setActionBar( toolbar );
        getActionBar().setTitle( "JOB POST" );
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        String uid=user.getUid();
        jobpost= FirebaseDatabase.getInstance().getReference().child( "JOB POST" ).child( uid );

        jobinsert();

    }

  private void jobinsert(){
        etjobtitle=(EditText)findViewById( R.id.jobtitle );
        etjobdesc= (EditText)findViewById( R.id.jobdescription );
        etskill=(EditText) findViewById( R.id.skill );
        etsal=(EditText) findViewById( R.id.salary );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etjobtitle.getText().toString().trim();
                String description = etjobdesc.getText().toString().trim();
                String skill = etskill.getText().toString().trim();
                String salary = etsal.getText().toString().trim();

                if (TextUtils.isEmpty( title )) {
                    etjobtitle.setError( " Requiredfill..." );
                    return;
                }
                if (TextUtils.isEmpty( description )) {
                    etjobdesc.setError( "Requiredfill..." );
                    return;
                }
                if (TextUtils.isEmpty( skill )) {
                    etskill.setError( "Requiredfill..." );
                    return;
                }
                if (TextUtils.isEmpty( salary )) {
                    etsal.setError( "Requiredfill..." );
                    return;
                }
                String id=jobpost.push().getKey();
                String date= DateFormat.getDateInstance().format(new Date(  ) );
                data Data= new data( title,description,skill,salary,id,date );
                jobpost.child( id ).setValue( Data );
                Toast.makeText( getApplicationContext(),"Sucessful...",Toast.LENGTH_SHORT).show();
                startActivity( new Intent( getApplicationContext(), JobpostActivity.class ) );


            }
        } );


  }

}
