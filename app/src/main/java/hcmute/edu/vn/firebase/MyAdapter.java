package hcmute.edu.vn.firebase;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyAdapter extends BaseAdapter {


    public MyAdapter(ArrayList<Model_Image> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    private ArrayList<Model_Image> dataList;
    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());


    LayoutInflater layoutInflater;
    // Sử dụng Executor để thực hiện tác vụ trên một luồng riêng
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(layoutInflater== null){
            layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view== null){
            view =layoutInflater.inflate(R.layout.grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.gridImage = view.findViewById(R.id.gridImage);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
//        ImageView gridImage = view.findViewById(R.id.gridImage);
//
//        Glide.with(context).load(dataList.get(i).getImageUri()).into(gridImage);

        // Lấy URL của ảnh từ đối tượng Model_Image tại vị trí position
        String imageUrl = dataList.get(i).getImageUri();

        // Sử dụng Executor để thực hiện tải ảnh trên một luồng riêng
        executor.execute(new ImageLoader(viewHolder.gridImage, imageUrl));
        return view;
    }

    static class ViewHolder {
        ImageView gridImage;
    }
    private class ImageLoader implements Runnable {
        public ImageLoader(ImageView imageView, String imageUrl) {
            this.imageView = imageView;
            this.imageUrl = imageUrl;
        }

        private ImageView imageView;
        private String imageUrl;

        @Override
        public void run() {
            handler.post(new Runnable() {
                              @Override
                              public void run() {
                                  // Tải ảnh từ URL bằng Glide và hiển thị vào ImageView
                                  Glide.with(context).load(imageUrl).into(imageView);
                              }
                          });

        }
    }

}
