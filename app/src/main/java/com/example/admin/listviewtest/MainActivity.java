package com.example.admin.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
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
