package com.example.instantapp.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.instantapp.model.ExampleEntity;
import com.example.instantapp.model.MyObjectBox;
import com.example.instantapp.model.RelatedEntity;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ObjectBox setup (should do in Application class, only here for simplicity)
        BoxStore boxStore = MyObjectBox.builder().androidContext(getApplicationContext()).build();

        // simple remove and put (should do in background thread)
        Box<ExampleEntity> box = boxStore.boxFor(ExampleEntity.class);
        box.removeAll();

        ExampleEntity entity = new ExampleEntity();
        entity.getRelated().setTarget(new RelatedEntity());
        box.put(entity);
    }
}
