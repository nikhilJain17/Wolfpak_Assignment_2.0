package com.hello.learning.wolfpak_assignmen;

import com.hello.learning.wolfpak_assignmen.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


/**
 * take the picture, etc
 * edit this later to say something useful
 *
 * @author Nikhil Jain
 */
public class TakePictureActivity extends Activity {

    final int CAMERA_REQUEST_CODE = 0;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        imageView = (ImageView) findViewById(R.id.imageView);

        // make the app fullscreen
        ActionBar actionBar = getActionBar();
        try {
            actionBar.hide();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Launch the camera
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE) {

            Bitmap pictureBMP = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(pictureBMP);

        }

    }
}
