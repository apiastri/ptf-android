package com.example.polideportivo;

import java.util.List;
import java.util.Vector;

import junit.framework.Assert;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Deporte[] deportesArray;
	private List<Deporte> deportesLVector;
	private ListView lvDeportes;
	private TextView lDetalleDeporte;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// cargo datos en la lista de deportes
	    // el primer parametro del constructor es un codigo correlativo unico del deporte
		deportesLVector = new Vector<Deporte>();
		deportesLVector.add(new Deporte(1, "Futbol", "Nuestro principal deporte Nacional", "futbol"));
		deportesLVector.add(new Deporte(2, "Basketball", "Deporte muy popular y destacado", "basket")); 
		deportesLVector.add(new Deporte(3, "Tenis", "Deporte de alta exigencia tecnica","tenis")); 
		deportesLVector.add(new Deporte(4, "Natacion", "Un deporte muy completo y saludable", "natacion")); 
		
		deportesArray = new Deporte[]{
				new Deporte(1, "Futbol", "Nuestro principal deporte Nacional", "futbol"),
				new Deporte(2, "Basketball", "Deporte muy popular y destacado", "basket"),
				new Deporte(3, "Tenis", "Deporte de alta exigencia tecnica","tenis"),
				new Deporte(4, "Natacion", "Un deporte muy completo y saludable", "natacion")};

		// instancio los controles listView y label de detalles
		// a partir de los recursos del layout
		lvDeportes = (ListView) findViewById(R.id.listview);
	    lDetalleDeporte = (TextView) findViewById(R.id.textDetalle);
		
		// Creo un ListAdapter del tipo AdaptadorPersonalDeportes de Lista de Deporte
		ListAdapter adaptador = new AdaptadorPersonalDeportesList(this, deportesLVector);
	    
	    // Creo un ArrayAdapter del tipo AdaptadorPersonalDeportesArray de objetos Deporte
//		ArrayAdapter<Object> adaptador = new AdaptadorPersonalDeportesArray(this, deportesArray);
		
		// Defino el adaptador que debe usar mi ListView
		lvDeportes.setAdapter(adaptador);
		lvDeportes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		// Defino el comportamiento del evento de seleccion de un item de mi
		// lista de deportes, al pulsra click por el usuario cargo el label del
		// detalle del deporte seleccionado
		lvDeportes.setOnItemClickListener(new OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		       
		        String opcionSeleccionada =
		            ((Deporte) a.getAdapter().getItem(position)).getDescripcion();
		        lDetalleDeporte.setText(opcionSeleccionada);
		        
		        // Si el elemento lo tengo en el layou definido puedeo obtenerlo del mismo o
		        // a partir del adapter
		        String nombreSeleccionadoOpc1 =
		        		((Deporte) a.getAdapter().getItem(position)).getNombre();
		        Toast toast = Toast.makeText(getApplicationContext(),
						"Nombre del Deporte:"+ nombreSeleccionadoOpc1, 
						Toast.LENGTH_SHORT);
		        toast.show();
		        
//		        String nombreSeleccionadoOpc2 =
//		               ((TextView) v.findViewById(R.id.tvLineaNombre))
//		                   .getText().toString();
//		        Toast toast = Toast.makeText(getApplicationContext(),
//						"Nombre del Deporte:"+ nombreSeleccionadoOpc2, 
//						Toast.LENGTH_SHORT);
//				toast.show();
		        
		      
		    }
		});
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this,
				String.valueOf(lvDeportes.getCheckedItemCount()),
				Toast.LENGTH_LONG).show();
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
