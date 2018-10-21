package com.bitfield.ostello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth appAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appAuth = FirebaseAuth.getInstance();
        if(appAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }
        FirebaseUser user = appAuth.getCurrentUser();
    }

    public void logout(View view) {
        appAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(this,LoginActivity.class));
    }
}
