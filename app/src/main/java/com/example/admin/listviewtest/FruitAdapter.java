package com.example.admin.listviewtest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;


    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fruit fruit = getItem(position);//获取当前项的fruit实例
        View view;
        ViewHolder viewHolder;
        //getView() 方法 中 还有 一个 convertView 参数， 这个 参数 用于 将 之前 加载 好的 布局 进行 缓存， 以便 之后 可以 进行 重用。
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName =(TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); //将viewholder存储在view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

//        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView)view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId()); //设置显示的图片
//        fruitName.setText(fruit.getName());   //设置文字
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;  //将布局返回
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
