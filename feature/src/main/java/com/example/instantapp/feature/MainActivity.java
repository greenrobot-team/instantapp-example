package com.example.instantapp.feature;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.instantapp.model.DaoMaster;
import com.example.instantapp.model.DaoSession;
import com.example.instantapp.model.ExampleEntity;
import com.example.instantapp.model.ExampleEntityDao;
import com.example.instantapp.model.RelatedEntity;
import com.example.instantapp.model.RelatedEntityDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // greenDAO setup (should do this in Application class, only here for simplicity)
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "example", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        // simple delete all and insert
        RelatedEntityDao relatedEntityDao = daoSession.getRelatedEntityDao();
        relatedEntityDao.deleteAll();
        ExampleEntityDao exampleEntityDao = daoSession.getExampleEntityDao();
        exampleEntityDao.deleteAll();

        RelatedEntity relatedEntity = new RelatedEntity();
        relatedEntityDao.insert(relatedEntity);

        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setId(42);
        exampleEntity.setRelated(relatedEntity);
        exampleEntityDao.insert(exampleEntity);
    }
}
