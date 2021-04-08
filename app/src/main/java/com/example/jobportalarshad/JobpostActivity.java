package com.example.jobportalarshad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jobportalarshad.Database.data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class JobpostActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference jobpostdatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_jobpost );
        floatingActionButton=(FloatingActionButton)findViewById( R.id.fab_add );
        floatingActionButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(),InsertjobActivity.class ) );
                firebaseAuth=FirebaseAuth.getInstance();
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                String uid= firebaseUser.getUid();
                jobpostdatabaseReference=FirebaseDatabase.getInstance().getReference().child( "JOB POST" ).child( uid );
                 recyclerView=findViewById( R.id.recyclerid );
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager( JobpostActivity.this);
                linearLayoutManager.setStackFromEnd( true );
                linearLayoutManager.setReverseLayout( true );
                recyclerView.setHasFixedSize( true );
                recyclerView.setLayoutManager( linearLayoutManager );


            }
        } );

    }

    @Override
    protected void onStart() {
        super.onStart();


            FirebaseRecyclerAdapter<data,Myviewholder>adapter=new FirebaseRecyclerAdapter<data, Myviewholder>() {



            };

    public static class Myviewholder extends RecyclerView.ViewHolder{
        View myview;
        public Myviewholder(View itemview){
            super(itemview);
            myview=itemview;

        }
        public void setjobtitle(String title){
            TextView mtext=myview.findViewById( R.id.job_title);
            mtext.setText( title );
        }
        public void setjobdate(String date){
            TextView mtext=myview.findViewById( R.id.jobpostdate );
            mtext.setText( date );
        }
        public void setDescription(String description){
            TextView mtext=myview.findViewById( R.id.description);
            mtext.setText( description );
        }
        public void setjobskill(String skill){
            TextView mtext=myview.findViewById( R.id.skilltest );
            mtext.setText( skill );
        }
        public void setjobsalary(String salary){
            TextView mtext=myview.findViewById( R.id.sal);
            mtext.setText( salary );
        }


    }
}
