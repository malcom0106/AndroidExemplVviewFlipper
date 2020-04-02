package com.example.exempleviewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //On déclare le context
        context = this;

        //On rtecupere notre viewFlipper
        ViewFlipper viewFlipper = findViewById(R.id.vfpFlipper);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context,android.R.anim.fade_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context,android.R.anim.fade_in));
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);

    }
}
