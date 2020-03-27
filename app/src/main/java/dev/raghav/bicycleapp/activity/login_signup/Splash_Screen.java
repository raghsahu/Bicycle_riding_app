package dev.raghav.bicycleapp.activity.login_signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.adapter.Fragment_Pager;
import dev.raghav.bicycleapp.databinding.ActivitySplashScreenBinding;

public class Splash_Screen extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    Fragment_Pager pagerAdapter;
    private int dotsCount;
    private ImageView[] dotes;
    //SessionManager sessionManager;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String[] mPermission = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.INTERNET,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_splash__screen);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash__screen);

        //sessionManager=new SessionManager(SplashActivity.this);

        FragmentManager fm = getSupportFragmentManager();
        pagerAdapter = new Fragment_Pager(fm);
        // Here you would declare which page to visit on creation
        binding.sliderPager.setAdapter(pagerAdapter);
        binding.sliderPager.setCurrentItem(0);
        binding.sliderPager.setPageTransformer(true, new ZoomOutSlideTransformer());
        binding.sliderPager.addOnPageChangeListener(pageChangeListener);
        dotesIndicater();

        binding.cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(Splash_Screen.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//              //  if (sessionManager.isLoggedIn()){
////                    Intent mainIntent = new Intent(Splash_Screen.this, MainActivity.class);
////                    startActivity(mainIntent);
////                    finish();
//              //  }else {
//                    Intent mainIntent = new Intent(Splash_Screen.this, LoginActivity.class);
//                    startActivity(mainIntent);
//                    finish();
//              //  }
//
//
//
//            }
//        }, SPLASH_DISPLAY_LENGTH);


//        try {
//            if (ActivityCompat.checkSelfPermission(this, mPermission[0])
//                    != PackageManager.PERMISSION_GRANTED ||
//                    ActivityCompat.checkSelfPermission(this, mPermission[1])
//                            != PackageManager.PERMISSION_GRANTED ||
//                    ActivityCompat.checkSelfPermission(this, mPermission[2])
//                            != PackageManager.PERMISSION_GRANTED ||
//                    ActivityCompat.checkSelfPermission(this, mPermission[3])
//                            != PackageManager.PERMISSION_GRANTED ||
//                    ActivityCompat.checkSelfPermission(this, mPermission[4])
//                            != PackageManager.PERMISSION_GRANTED ||
//                    ActivityCompat.checkSelfPermission(this, mPermission[5])
//                            != PackageManager.PERMISSION_GRANTED||
//                    ActivityCompat.checkSelfPermission(this, mPermission[6])
//                            != PackageManager.PERMISSION_GRANTED)
//
//            {
//
//                ActivityCompat.requestPermissions(this,
//                        mPermission, REQUEST_CODE_PERMISSION);
//
//                // If any permission aboe not allowed by user, this condition will execute every tim, else your else part will work
//            } else {
//
//                /* New Handler to start the Menu-Activity
//                 * and close this Splash-Screen after some seconds.*/
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        /* Create an Intent that will start the Menu-Activity. */
//                        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
//                        startActivity(mainIntent);
//                        finish();
//
//
//                    }
//                }, SPLASH_DISPLAY_LENGTH);
//
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.e("Req Code", "" + requestCode);
//        System.out.println(grantResults[0] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[1] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[2] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[3] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[4] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[5] == PackageManager.PERMISSION_GRANTED);
//        System.out.println(grantResults[6] == PackageManager.PERMISSION_GRANTED);
//
//
//        if (requestCode == REQUEST_CODE_PERMISSION) {
//            if (grantResults.length == 7 &&
//                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[1] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[2] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[3] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[4] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[5] == PackageManager.PERMISSION_GRANTED &&
//                    grantResults[6] == PackageManager.PERMISSION_GRANTED
//
//            ) {
//                /* New Handler to start the Menu-Activity
//                 * and close this Splash-Screen after some seconds.*/
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        /* Create an Intent that will start the Menu-Activity. */
//                        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
//                        startActivity(mainIntent);
//                        finish();
//
//                    }
//                }, SPLASH_DISPLAY_LENGTH);
//
//            } else {
//                Toast.makeText(SplashActivity.this, "Denied", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        }
//    }


    //**************************************
    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            for (int i = 0; i < dotsCount; i++) {
                dotes[i].setImageDrawable(getResources().getDrawable(R.drawable.circle_inactive));
            }

            dotes[position].setImageResource(R.drawable.circle_active);

            if (position + 1 == dotsCount) {
                // tv_skip.setText("Get Start");
               // tv_skip.setVisibility(View.VISIBLE);

            } else {
                // tv_skip.setText("Skip");
               // tv_skip.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @SuppressLint("ClickableViewAccessibility")
    public void dotesIndicater() {
        dotsCount = pagerAdapter.getCount();
        dotes = new ImageView[dotsCount];
        binding.linearLayout.removeAllViews();
        for (int i = 0; i < dotsCount; i++) {
            dotes[i] = new ImageView(this);
            dotes[i].setImageResource(R.drawable.circle_inactive);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    20,
                    20
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dotes[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    binding.sliderPager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            binding.linearLayout.addView(dotes[i], params);

        }
        dotes[0].setImageResource(R.drawable.circle_active);


    }
}
