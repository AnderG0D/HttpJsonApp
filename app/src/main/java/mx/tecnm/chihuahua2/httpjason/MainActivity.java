package mx.tecnm.chihuahua2.httpjason;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private String url =
            "https://sebastiangarcia1.000webhostapp.com/programas_PHP/consultar_gramineas.php";
    private RecyclerView mList;
    private DividerItemDecoration dividerItemDecoration;
    private LinearLayoutManager linearLayoutManager;
    private List<Cultivo> cultivoList;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.main_List);
        cultivoList = new ArrayList<>();
        adapter = new CultivoAdapter(getApplicationContext(), cultivoList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),
                linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getData();
        // mList.setAdapter(adapter);
    }
    private void getData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando ...");
        progressDialog.show();
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Cultivo cultivo = new Cultivo();
                                cultivo.setId(jsonObject.getInt("id"));
                                cultivo.setNombreComun(jsonObject.getString("nombreComun"));
                                cultivo.setNombreCientifico(jsonObject.getString("nombreCientifico"));

                                cultivo.setDescripcion(jsonObject.getString("descripcion"));
                                cultivo.setImagen(jsonObject.getString("imagen"));
                                cultivoList.add(cultivo);
                                Toast.makeText(getApplicationContext(), cultivo.getNombreComun(),
                                        Toast.LENGTH_LONG).show();
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                                progressDialog.dismiss();
                            }
                        }
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
        Toast.makeText(getApplicationContext(), cultivoList.toString(),
                Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), String.valueOf(cultivoList.size()), Toast.LENGTH_LONG).show();
    }
}
