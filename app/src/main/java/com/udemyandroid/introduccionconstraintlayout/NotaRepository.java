package com.udemyandroid.introduccionconstraintlayout;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.udemyandroid.introduccionconstraintlayout.db.NotaRoomDatabase;
import com.udemyandroid.introduccionconstraintlayout.db.dao.NotaDao;
import com.udemyandroid.introduccionconstraintlayout.db.entity.NotaEntity;

import java.util.List;

public class NotaRepository {

    private NotaDao notaDao;
    private LiveData<List<NotaEntity>> allNotas;
    private LiveData<List<NotaEntity>> allNotasFavoritas;

    public NotaRepository (Application application){
        NotaRoomDatabase db = NotaRoomDatabase.getDatabase(application);
        notaDao = db.notaDao();
        allNotas = notaDao.getAll();
        allNotasFavoritas = notaDao.getAllFavoritas();
    }

    public LiveData<List<NotaEntity>> getAll(){
        return allNotas;
    }

    public LiveData<List<NotaEntity>> getAllFav(){
        return allNotasFavoritas;
    }

    public void insert(NotaEntity nota){
        new InsertAsyncTask(notaDao).execute();
    }

    private static class InsertAsyncTask extends AsyncTask<NotaEntity, Void, Void>{

        private NotaDao notaDaoAsyncTask;

        InsertAsyncTask(NotaDao notaDao){
            notaDaoAsyncTask = notaDao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsyncTask.insert(notaEntities[0]);
            return null;
        }
    }
}
