package com.example.networkprotocolmilestone0;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private Button register;
    private FirebaseAuth firebaseAuth;

    //private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(), List.class));
//            finish();
        //}
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(MainActivity.this, List.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "couldn't register please try again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Register.class);
                startActivity(intent1);
            }
        });

    }


//    private void userLogin(){
//        String editusername=username.getText().toString().trim();
//        String editpass=password.getText().toString().trim();
//        if(TextUtils.isEmpty(editusername)){
//            Toast.makeText(this,"Please enter email. ",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(TextUtils.isEmpty(editpass)){
//            Toast.makeText(this,"Please enter password. ",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        progressDialog.setMessage("Registering user...");
//        progressDialog.show();
//
//        firebaseAuth.createUserWithEmailAndPassword(editusername,editpass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
//        {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if(task.isSuccessful()){
//                            Intent intent5 = new Intent(MainActivity.this, List.class);
//                            startActivity(intent5);
//
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this,"couldn't register please try again",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
//        firebaseAuth.signInWithEmailAndPassword(editusername,editpass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if(task.isSuccessful()){
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), List.class));
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this,"couldn't register please try again",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
//    }
//    @Override
//    public void onClick(View view){
//        if(view==register){
//            userLogin();
//        }
//
//    }

}