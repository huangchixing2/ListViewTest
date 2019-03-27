package com.example.admin.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    private String[] data = {"Apple", "Banana", "Pear", "Grape", "Pineapple", "Cheery", "Watermelon", "Mango", "Strawberry", "Mango", "Grape", "Pear", "Apple", "Banana", "Pear", "Grape"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,data);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //listview的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);//通过 position 参数 判断 出 用户 点击 的 是 哪一个 子项，
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initFruits() {

        for (int i = 0; i < 5; i++) {
            Fruit apple = new Fruit("Apple", R.mipmap.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.mipmap.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.mipmap.orange_pic);
            fruitList.add(orange);
        }
    }
}
