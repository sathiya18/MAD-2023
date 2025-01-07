package sathiya.cse.ptu.animationdemo10012024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView mImageView;

    private Animation mRotateAnim;
    private Animation mScaleAnim;
    private Animation mTranslateAnim;
    private Animation mAlphaAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.volleyball);
    }


    public void scaleAnimation(View view) {

        mScaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        mScaleAnim.setAnimationListener(this);
        mImageView.startAnimation(mScaleAnim);
    }

    public void translateAnimation(View view) {

        mTranslateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        mTranslateAnim.setAnimationListener(this);
        mImageView.startAnimation(mTranslateAnim);
    }

    public void alphaAnimation(View view) {
        mAlphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        mAlphaAnim.setAnimationListener(this);
        mImageView.startAnimation(mAlphaAnim);
    }

    public void rotateAnimation(View view) {

        mRotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        mRotateAnim.setAnimationListener(this);
        mImageView.startAnimation(mRotateAnim);
    }





    @Override
    public void onAnimationStart(Animation animation) {

        if(animation == mScaleAnim) {
            Toast.makeText(MainActivity.this, "Scale Animation Started ", Toast.LENGTH_SHORT).show();
        }

        if(animation == mRotateAnim){
            Toast.makeText(MainActivity.this, "Rotate Animation Started ", Toast.LENGTH_SHORT).show();

        }

        if(animation == mTranslateAnim){
            Toast.makeText(MainActivity.this, "Translate Animation Started ", Toast.LENGTH_SHORT).show();

        }

        if(animation == mAlphaAnim){
            Toast.makeText(MainActivity.this, "Alpha Animation Started ", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        Toast.makeText(MainActivity.this, "Animation Ended ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

        Toast.makeText(MainActivity.this, "Animation Repeated ", Toast.LENGTH_SHORT).show();

    }
}
