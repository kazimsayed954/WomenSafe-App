package com.kazim.womensafe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginScreen extends AppCompatActivity {
    private EditText mname,mpassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        mname = findViewById(R.id.name);
        mpassword = findViewById(R.id.password);
        TextView forgot = findViewById(R.id.forgot);
        auth = FirebaseAuth.getInstance();
        Button loginbtn = findViewById(R.id.loginbtn);
        Button registerbtn = findViewById(R.id.registerbtn);
        progressBar = findViewById(R.id.progressBar);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mname.getText().toString();
                String password = mpassword.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z.]+";

                if (TextUtils.isEmpty(name)) {
//                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    mname.setError("Enter Email");
                    return;
                }

                if(!(name.matches(emailPattern))){
//                    Toast.makeText(getApplicationContext(), "Invalid email address!", Toast.LENGTH_SHORT).show();
                    mname.setError("Enter Valid Email");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    mpassword.setError("Enter Password");
                    return;
                }

                if (password.length() < 6) {
//                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    mpassword.setError("Password too short");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(name, password)
                        .addOnCompleteListener(LoginScreen.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    String yourString = Objects.requireNonNull(task.getException()).toString();
                                    String target = "Exception:";
                                    String error = yourString.substring(yourString.indexOf(target) + target.length() + 1, yourString.length());
                                        Toast.makeText(LoginScreen.this, "Error: "+error, Toast.LENGTH_LONG).show();
                                }
                                else {
                                    checkIfEmailVerified();
                                }
                            }
                        });

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginScreen.this, ForgotScreen.class);
                LoginScreen.this.startActivity(myIntent);
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginScreen.this, RegisterScreen.class);
                LoginScreen.this.startActivity(myIntent);
                finish();
            }
        });
    }

    private void checkIfEmailVerified() {
        FirebaseUser user = auth.getCurrentUser();

        if (user.isEmailVerified())
        {
            // user is verified, so you can finish this activity or send user to activity which you want.
            Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();


        }
        else
        {
            // email is not verified, so just prompt the message to the user and restart this activity.
            // NOTE: don't forget to log out the user.
            Toast.makeText(this, "Email not verified", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();

            //restart this activity

        }
    }
}
