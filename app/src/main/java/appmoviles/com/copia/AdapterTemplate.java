package appmoviles.com.copia;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTemplate extends RecyclerView.Adapter<AdapterTemplate.CustomViewHolder> {

    //Los datos que vamos a mostrar (View)
    private ArrayList<Persona> data;

    //Renglon y construccion
    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout root;
        public CustomViewHolder(LinearLayout v) {
            super(v);
            root = v;
        }
    }

    public AdapterTemplate(){
        data = new ArrayList<>();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        ((TextView) holder.root.findViewById(R.id.row_nombre)).setText(data.get(position).nombre);
        ((TextView) holder.root.findViewById(R.id.row_numero)).setText(data.get(position).numero);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void agregarPersona(Persona persona){
        data.add(persona);
        notifyDataSetChanged();
    }


}