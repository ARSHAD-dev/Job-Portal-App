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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegistrationActivity extends AppCompatActivity {
    private EditText reglogin,regemail;
    private Button btnlogin,btnreg;
     private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth=FirebaseAuth.getInstance();
        mDialog= new ProgressDialog(this);
        Registration();
    }
    private void Registration(){
        reglogin=(EditText)findViewById(R.id.Password_registration);
        regemail=(EditText)findViewById(R.id.Email_registration);
        btnlogin=(Button)findViewById(R.id.btn_login1);
        btnreg=(Button)findViewById(R.id.Btn_Registration);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login=reglogin.getText().toString().trim();
                String email=regemail.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    regemail.setError("Required filed...");
                    return;
                }
                if(TextUtils.isEmpty(login)){
                    reglogin.setError(("Required filed"));
                    return;
                }
                mDialog.setMessage("processing");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(email,login).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"sucessful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            mDialog.dismiss();
                        }else {
                            Toast.makeText(getApplicationContext(), "Field", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}
