package mx.tecnm.chihuahua2.httpjason;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CultivoDetalle extends AppCompatActivity {
    Button btnRegresar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultivo_detalle);
        btnRegresar = findViewById(R.id.buttonRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getIncomingIntent();
    }
    private void getIncomingIntent(){
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("nombreComun") &&
                getIntent().hasExtra("nombreCientifico") &&
                getIntent().hasExtra("descripcion") &&
                getIntent().hasExtra("imagen")) {
            String id = getIntent().getStringExtra("id");
            String nombreComun =
                    getIntent().getStringExtra("nombreComun");
            String nombreCientifico =
                    getIntent().getStringExtra("nombreCientifico");
            String descripcion =
                    getIntent().getStringExtra("descripcion");
            String imagen = getIntent().getStringExtra("imagen");
            setDatos(id, nombreComun, nombreCientifico, descripcion,
                    imagen);
        }
    }
    public void setDatos(String id, String nombreComun, String
            nombreCientifico, String descripcion,
                         String imagen) {
        TextView id1 = findViewById(R.id.textViewId);
        id1.setText(id);
        TextView nombrecomun1 = findViewById(R.id.textViewNombre);
        nombrecomun1.setText(nombreComun);
        TextView nombrecientifico1 =
                findViewById(R.id.textViewNombreC);
        nombrecientifico1.setText(nombreCientifico);
        TextView descripcion1 =
                findViewById(R.id.textViewDescripcion);
        descripcion1.setText(descripcion);

        String imageURL =
                "https://sebastiangarcia1.000webhostapp.com/imagenes/" + imagen;
        ImageView image = findViewById(R.id.imageView);
 /*
 Para usar la clase "Glide" se agregó al archivo build.gradle las líneas:
 implementation 'com.github.bumptech.glide:glide:4.7.1'
 annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'

 */
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(image);
    }
}