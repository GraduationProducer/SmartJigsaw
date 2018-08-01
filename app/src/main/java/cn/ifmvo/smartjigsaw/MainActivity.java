package cn.ifmvo.smartjigsaw;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static int count = 3;

    RecyclerView recyclerView;

    List<ImgItem> imgResList = new ArrayList<>();

    BaseQuickAdapter<ImgItem, BaseViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int space = 2;
                outRect.left = space;
                outRect.right = space;
                outRect.top = space;
            }
        });

        adapter = new BaseQuickAdapter<ImgItem, BaseViewHolder>(R.layout.list_item_img) {
            @Override
            protected void convert(BaseViewHolder helper, ImgItem item)
            {
                ImageView ivImage = helper.getView(R.id.iv_img);
                helper.setImageResource(R.id.iv_img, item.imgResId);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.height = ViewUtils.getScreenWidth(MainActivity.this) / 3;
                ivImage.setLayoutParams(layoutParams);
                Log.e("ifmvo", ViewUtils.getScreenWidth(MainActivity.this) / 3 + "");
            }
        };

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                for (int i=0; i<imgResList.size(); i++){
                    ImgItem item = imgResList.get(i);
                    ImgItem clickItem = imgResList.get(position);
                    if (Math.abs(item.x - clickItem.x) + Math.abs(item.y - clickItem.y) == 1 && item.imgResId == 0){

                    }
                }
            }
        });


        recyclerView.setAdapter(adapter);

        initData();

        adapter.setNewData(imgResList);

    }

    private void initData(){
        for (int i=0; i<count*count; i++){
            int id = 0;
            if (i != count*count - 1){
                id = getDrawableId(String.format("android_0%d", i+1));
            }
            imgResList.add(new ImgItem(i%count, i/count, id, i));
        }
    }

    public static int getDrawableId(String name)
    {
        int result = -1;
        try
        {
            Class clz = Class.forName(R.drawable.class.getName());
            Field field = clz.getField(name);
            result = field.getInt(new R.drawable());
        } catch (Exception ignored) { }
        return result;
    }
}
