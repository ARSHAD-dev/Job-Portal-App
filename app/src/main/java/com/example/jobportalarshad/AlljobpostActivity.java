package com.example.jobportalarshad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.jobportalarshad.Database.data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlljobpostActivity extends AppCompatActivity {
 private Toolbar toolbar;
 private RecyclerView recyclerView;
 private FirebaseAuth firebaseAuth;
 private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_alljobpost );
        toolbar=findViewById( R.id.recycler_alljobpost );
        setActionBar( toolbar );
        getActionBar().setTitle( "JOB POST" );
        recyclerView=findViewById( R.id.recycler_alljobpost );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true );
        recyclerView.setHasFixedSize(true  );
        recyclerView.setLayoutManager( linearLayoutManager );
        databaseReference = FirebaseDatabase.getInstance().getReference().child( "JOB POST" );
        databaseReference.keepSynced( true );




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<data,Alljobpostview>adapter=new FirebaseRecyclerAdapter<data, Alljobpostview>(
                data.class,
                Alljobpostview.class,
                R.id.recycler_alljobpost,
                databaseReference

        ) {

            @Override
            protected void onBindViewHolder(@NonNull Alljobpostview alljobpostview, int i, @NonNull data data) {

            }

            @NonNull
            @Override
            public Alljobpostview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
    }

    public static class Alljobpostview extends RecyclerView.ViewHolder{
        View myview;

            public Alljobpostview( View itemView) {
                super( itemView );
                myview=itemView;
            }
        public void setjobtitle(String title){
            TextView mtext=myview.findViewById( R.id.alljob_tittle);
            mtext.setText( title );
        }
        public void setjobdate(String date){
            TextView mtext=myview.findViewById( R.id.All_job_post_date );
            mtext.setText( date );
        }
        public void setDescription(String description){
            TextView mtext=myview.findViewById( R.id.all_job_description);
            mtext.setText( description );
        }
        public void setjobskill(String skill){
            TextView mtext=myview.findViewById( R.id.alljob_skill );
            mtext.setText( skill );
        }
        public void setjobsalary(String salary){
            TextView mtext=myview.findViewById( R.id.alljob_salary);
            mtext.setText( salary );
        }



    }
}
