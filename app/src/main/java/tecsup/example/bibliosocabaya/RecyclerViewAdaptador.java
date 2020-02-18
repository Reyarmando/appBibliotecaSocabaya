package tecsup.example.bibliosocabaya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id, titulo, autor, categoria, fecha_ingreso, description;
        ImageView imgLibro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.id);
            titulo=(TextView)itemView.findViewById(R.id.titulo);
            autor=(TextView)itemView.findViewById(R.id.autor);
            categoria=(TextView)itemView.findViewById(R.id.categoria);
            fecha_ingreso=(TextView)itemView.findViewById(R.id.fecha_ingreso);
            description=(TextView)itemView.findViewById(R.id.description);
            imgLibro= (ImageView) itemView.findViewById(R.id.imgLibro);
        }
    }

    public List<Libro> libroLista;

    public RecyclerViewAdaptador(List<Libro> libroLista) {
        this.libroLista = libroLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(libroLista.get(position).getId());
        holder.titulo.setText(libroLista.get(position).getTitulo());
        holder.autor.setText(libroLista.get(position).getAutor());
        holder.categoria.setText(libroLista.get(position).getCategoria());
        holder.fecha_ingreso.setText(libroLista.get(position).getFecha_ingreso());
        holder.description.setText(libroLista.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return libroLista.size();
    }
}