package hcmute.edu.vn.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {


    public MyAdapter(ArrayList<Model_Image> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    private ArrayList<Model_Image> dataList;
    private Context context;

    LayoutInflater layoutInflater;

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
        if(layoutInflater== null){
            layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view== null){
            view =layoutInflater.inflate(R.layout.grid_item, null);
        }
        ImageView gridImage = view.findViewById(R.id.gridImage);

        Glide.with(context).load(dataList.get(i).getImageUri()).into(gridImage);
        return view;
    }
}
