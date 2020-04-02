package com.example.exempleviewflipper;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ArrayList<String> images = new ArrayList<>();
        images.add("att");
        images.add("dog");
        images.add("ile");

        // On récupère notre viewFlipper
        ViewFlipper viewFlipper = findViewById(R.id.vfpFlipper);
        // On associe des transitions entre chaque images
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));

        // On définit le view en mode auto
        viewFlipper.setAutoStart(true);
        // On définit l'interval de temps entre chaque images en milliseconde
        viewFlipper.setFlipInterval(3000);

        for(int i = 0; i < images.size(); i++){

            // On instancie notre objet ItemView
            ItemView itemView = new ItemView(this);

            // On récupère le nom de l'image
            String nomImage = images.get(i);
            // On récupère notre image dans les drawable a partir de son nom
            Drawable drawable = getDrawable(getDrawableByName(nomImage, "drawable"));

            // On l'associe à notre imageView
            ImageView imageView = itemView.findViewById(R.id.imgImageView);
            imageView.setImageDrawable(drawable);
            imageView.setMaxHeight(200);
            imageView.setMaxWidth(200);
            viewFlipper.addView(itemView);

            // Autre possibilité d'affichage imageView
            //ImageView imageView2 = new ImageView(context);
            //imageView2.setImageDrawable(drawable);
            //imageView2.setMaxHeight(200);
            //imageView2.setMaxWidth(200);
            //viewFlipper.addView(imageView2);

        }
    }

    private int getDrawableByName(String nomImage, String TypeRessource){

        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(nomImage, TypeRessource, pkgName);
        //Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;

    }
}