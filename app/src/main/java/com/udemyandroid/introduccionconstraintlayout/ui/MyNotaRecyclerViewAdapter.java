package com.udemyandroid.introduccionconstraintlayout.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udemyandroid.introduccionconstraintlayout.R;
import com.udemyandroid.introduccionconstraintlayout.db.entity.NotaEntity;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private List<NotaEntity> mValues;
    private final Context context;

    public MyNotaRecyclerViewAdapter(List<NotaEntity> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewContenido.setText(holder.mItem.getContenido());

        if (holder.mItem.isFavorita()){
            holder.imageViewFavorita.setImageResource(R.drawable.ic_star_black_24dp);
        }else{
            holder.imageViewFavorita.setImageResource(R.drawable.ic_star_border_black_24dp);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != context) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    //context.favoritaNotaClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setNuevasNotas(List<NotaEntity> nuevasNotas){
        this.mValues = nuevasNotas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewTitulo;
        public final TextView textViewContenido;
        public final ImageView imageViewFavorita;
        public NotaEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = view.findViewById(R.id.textViewTitulo);
            textViewContenido = view.findViewById(R.id.textViewContendo);
            imageViewFavorita = view.findViewById(R.id.imageViewFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewContenido.getText() + "'";
        }
    }
}
