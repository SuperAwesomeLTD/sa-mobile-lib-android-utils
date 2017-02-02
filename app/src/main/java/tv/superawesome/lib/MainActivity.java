package tv.superawesome.lib;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import tv.superawesome.lib.sautils.SAImageUtils;

public class MainActivity extends AppCompatActivity {

    ImageView testImageView = null;
    RelativeLayout testLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testImageView = (ImageView) findViewById(R.id.TestImageView);
        testImageView.setAlpha(0.5f);
        Bitmap bitmap = SAImageUtils.createVideoGradientBitmap();
        if (bitmap != null) {
            testImageView.setImageBitmap(bitmap);
        }

        testLayout = (RelativeLayout) findViewById(R.id.TestLayout);
        testLayout.setBackgroundDrawable(SAImageUtils.createVideoGradientDrawable());

    }
}
