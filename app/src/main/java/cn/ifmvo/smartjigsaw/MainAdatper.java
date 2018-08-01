//package cn.ifmvo.smartjigsaw;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import java.util.List;
//
///**
// * Created by 陈序员 on 2017/9/9.
// * Email: Matthew_Chen_1994@163.com
// * Blog: https://blog.ifmvo.cn
// */
//
//public class MainAdatper extends RecyclerView.Adapter<MainAdatper.MainViewHolder> {
//
//    private Context context;
//    private List<ImgItem> list;
//
//    public MainAdatper(Context context, List<ImgItem> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item_img, null);
//        return new MainViewHolder(inflate);
//    }
//
//    @Override
//    public void onBindViewHolder(MainViewHolder holder, int position) {
//        holder.ivImage.setImageResource(list.get(position).imgResId);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        layoutParams.height = ViewUtils.getScreenWidth(context) / 3;
//        holder.ivImage.setLayoutParams(layoutParams);
//        Log.e("ifmvo", ViewUtils.getScreenWidth(context) / 3 + "");
//
//
//
//        holder.ivImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    static class MainViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView ivImage;
//
//        public MainViewHolder(View itemView) {
//            super(itemView);
//            ivImage = (ImageView) itemView.findViewById(R.id.iv_img);
//        }
//
//    }
//}
