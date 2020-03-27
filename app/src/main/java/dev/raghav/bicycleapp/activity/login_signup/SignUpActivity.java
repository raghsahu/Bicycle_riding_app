package dev.raghav.bicycleapp.activity.login_signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sign_up);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sign_up);


        binding.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                //finish();
            }
        });

        binding.cardSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(SignUpActivity.this, OtpActivity.class);
                startActivity(mainIntent);
                //finish();
            }
        });


    }
}
