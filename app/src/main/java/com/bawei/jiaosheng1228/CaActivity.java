package com.bawei.jiaosheng1228;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

/**
 * Created by Adminjs on 2017/12/28.
 */
//http://img0.imgtn.bdimg.com/it/u=3499177200,1803867959&fm=214&gp=0.jpg
public class CaActivity extends Activity{

    private SimpleDraweeView simp;
    private SimpleDraweeView si;
    private Button start;
    private Button clear;
    private Button pause;
    private Animatable animatable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);
        Fresco.initialize(this);
        simp = findViewById(R.id.simp);
        si = findViewById(R.id.simpledraw);
        start = findViewById(R.id.start);
        clear = findViewById(R.id.clera);
        pause = findViewById(R.id.pasue);
        simp.setImageURI("http://img5.imgtn.bdimg.com/it/u=2031358516,4280366237&fm=27&gp=0.jpg");
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        simp.getHierarchy().setRoundingParams(roundingParams);
        Uri uri = Uri.parse("http://img0.imgtn.bdimg.com/it/u=3499177200,1803867959&fm=214&gp=0.jpg");
        si.setImageURI(uri);
        DraweeController  draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setTapToRetryEnabled(true)
                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                        .setOldController(si.getController())
                        .build();

        si.setController(draweeController);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatable = si.getController().getAnimatable();

                if (animatable != null&& !animatable.isRunning()){
                    animatable.start();
                }

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatable = si.getController().getAnimatable();

                if (animatable != null&& animatable.isRunning()){
                    animatable.stop();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearCaches();
                imagePipeline.clearMemoryCaches();
                imagePipeline.clearDiskCaches();
                Toast.makeText(CaActivity.this, "清除成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
