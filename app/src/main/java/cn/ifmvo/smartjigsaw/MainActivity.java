package cn.ifmvo.smartjigsaw;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Integer [] imgResArr = {
            R.mipmap.android_01,
            R.mipmap.android_02,
            R.mipmap.android_03,
            R.mipmap.android_04,
            R.mipmap.android_05,
            R.mipmap.android_06,
            R.mipmap.android_07,
            R.mipmap.android_08,
            android.R.color.white
    };

    RecyclerView recyclerView;

    List<Integer> imgResList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int space = 2;
                outRect.left = space;
                outRect.right = space;
                outRect.top = space;
//                outRect.bottom = space;
            }
        });

        initData();

        recyclerView.setAdapter(new MainAdatper(MainActivity.this, imgResList));


    }

    private void initData(){
        imgResList = Arrays.asList(imgResArr);
    }
}
