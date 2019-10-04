package com.example.listview411;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    public static final String KEY_TEXT = "text";
    public static final String KEY_COUNT = "count";
    private String[] array_from = {KEY_TEXT, KEY_COUNT};
    private int[] array_to = {R.id.textList, R.id.countList};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.list);

        List<Map<String, String>> result = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(result);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> result) {
        return new SimpleAdapter(this, result, R.layout.list_item, array_from, array_to);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> resultList = new ArrayList<>();
        String[] result = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < result.length; i++) {
            Map<String, String> RowMap = new HashMap<>();
            RowMap.put(KEY_TEXT, result[i]);
            RowMap.put(KEY_COUNT, Integer.toString(result[i].length()));
            resultList.add(RowMap);
        }
        return resultList;
    }
}
