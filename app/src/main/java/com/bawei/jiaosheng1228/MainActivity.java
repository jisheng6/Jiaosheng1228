package com.bawei.jiaosheng1228;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simple;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simple = findViewById(R.id.simple);
        button = findViewById(R.id.button);
        simple.setImageURI("http://img5.imgtn.bdimg.com/it/u=2031358516,4280366237&fm=27&gp=0.jpg");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaActivity.class);
                startActivity(intent);
            }
        });
    }
}
