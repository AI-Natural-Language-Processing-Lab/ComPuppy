package com.genius.color.lovelypet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private static final String TAG = "AnimationStarter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);

        Button bounceBallButton = (Button) findViewById(R.id.bounceBallButton);
        final ImageView bounceBallImage = (ImageView) findViewById(R.id.bounceBallImage);

        bounceBallButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                bounceBallImage.clearAnimation();
                TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0,
                        getDisplayHeight()/2);
                transAnim.setStartOffset(500);
                transAnim.setDuration(3000);
                transAnim.setFillAfter(true);
                transAnim.setInterpolator(new BounceInterpolator());
                transAnim.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.i(TAG, "Starting button dropdown animation");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.i(TAG,
                                "Ending button dropdown animation. Clearing animation and setting layout");
                        bounceBallImage.clearAnimation();
                        final int left = bounceBallImage.getLeft();
                        final int top = bounceBallImage.getTop();
                        final int right = bounceBallImage.getRight();
                        final int bottom = bounceBallImage.getBottom();
                        bounceBallImage.layout(left, top, right, bottom);

                    }
                });
                bounceBallImage.startAnimation(transAnim);
            }
        });

    }

    private int getDisplayHeight() {
        return this.getResources().getDisplayMetrics().heightPixels;
    }
}