package mx.tecnm.chihuahua2.httpjason;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class CultivoAdapter extends RecyclerView.Adapter<CultivoAdapter.ViewHolder> {
    private Context context;
    private List<Cultivo> list;
    public CultivoAdapter(Context context, List<Cultivo> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false );
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cultivo cultivo = list.get(position);
        holder.textId.setText(String.valueOf(cultivo.getId()));
        holder.textNombreComun.setText(cultivo.getNombreComun());
        holder.textNombreCientifico.setText(cultivo.getNombreCientifico());
        // Nuevo código, notar que se agrega también “parentLayout”
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intent intent = new Intent(context, CultivoDetalle.class);
                intent.putExtra("id", String.valueOf(cultivo.getId()));
                intent.putExtra("nombreComun", cultivo.getNombreComun());
                intent.putExtra("nombreCientifico", cultivo.getNombreCientifico());
                intent.putExtra("descripcion", cultivo.getDescripcion());
                intent.putExtra("imagen", cultivo.getImagen());
                // Nuevo código. Para llamar a una actividad fuera del contexto de una actividad principal.
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textId, textNombreComun, textNombreCientifico;
        // Nuevo código, de la parte 2
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.main_id);
            textNombreComun = itemView.findViewById(R.id.main_nombrecomun);
            textNombreCientifico = itemView.findViewById(R.id.main_nombrecientifico);

            parentLayout =
                    itemView.findViewById(R.id.parentLayout);
        }
    }
}