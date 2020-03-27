package dev.raghav.bicycleapp.activity.login_signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dev.raghav.bicycleapp.activity.MainActivity;
import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {
    ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_otp);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_otp);


        binding.cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(OtpActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });


    }
}
