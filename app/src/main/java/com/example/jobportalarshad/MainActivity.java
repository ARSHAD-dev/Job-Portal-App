package com.example.jobportalarshad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 private EditText et1,et2;
 private Button btn1,btn2;
 private FirebaseAuth mAuth;
 private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        functionlogin();
        mAuth=FirebaseAuth.getInstance();
        mDialog= new ProgressDialog(this);


    }
    private void functionlogin(){
        et1=(EditText)findViewById(R.id.Email_login);
        et2=(EditText)findViewById(R.id.Password_login);
        btn1=(Button)findViewById(R.id.Btn_login);
        btn2=(Button)findViewById(R.id.btn_reg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=et1.getText().toString().trim();
                String pass=et2.getText().toString().trim();
                if(TextUtils.isEmpty(mEmail)){
                    et1.setError("Required Field");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    et2.setError("Required Field");
                    return;
                }
                mDialog.setMessage("processing");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(mEmail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "sucessful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                          mDialog.dismiss();
                        }else {
                            Toast.makeText(getApplicationContext(),"Field",Toast.LENGTH_SHORT).show();
                        }
            }   }); }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));

            }
        });

}   }
