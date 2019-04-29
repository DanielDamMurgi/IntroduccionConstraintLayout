package com.udemyandroid.introduccionconstraintlayout;

import com.udemyandroid.introduccionconstraintlayout.db.entity.NotaEntity;

public interface NotasInteractionListener {
    void editNotaClick (NotaEntity notaEntity);
    void eliminaNotaClick (NotaEntity notaEntity);
    void favoritaNotaClick (NotaEntity notaEntity);
}
