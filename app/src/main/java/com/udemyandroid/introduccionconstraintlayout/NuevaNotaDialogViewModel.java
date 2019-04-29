package com.udemyandroid.introduccionconstraintlayout;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.udemyandroid.introduccionconstraintlayout.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);

        notaRepository = new NotaRepository(application);

        allNotas = notaRepository.getAll();
    }

    // El fragmento que necesita recibir la lista de datos
    public LiveData<List<NotaEntity>> getAllNotas() {
        return allNotas;
    }

    // El fregment que inserter una nueva nota, deberá comunicarlo a este ViewModel
    public void insertarNota(NotaEntity nuevaNotaEntity) {
        notaRepository.insert(nuevaNotaEntity);
    }
}

