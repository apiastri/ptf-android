package com.example.polideportivo;

import junit.framework.Assert;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPersonalDeportesArray extends ArrayAdapter<Object> {

	private Deporte[] deportes;
	private Activity context;

	public AdaptadorPersonalDeportesArray(Activity context, Deporte[] datos) {
		super(context, R.layout.linea_deporte, datos);
		this.context = context;
		this.deportes = datos;
	}

	static class ViewHolderDeporte {
	    TextView codigo;
	    TextView nombre;
	    ImageView imagen;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		ViewHolderDeporte holder;
		
	    if(rowView == null){
	        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
	        rowView = inflater.inflate(R.layout.linea_deporte, null);
	        
	        holder = new ViewHolderDeporte();
	        holder.codigo = (TextView) rowView.findViewById(R.id.tvLineaCodigo);
	        holder.nombre = (TextView)  rowView.findViewById(R.id.tvLineaNombre);
	        holder.imagen = (ImageView) rowView.findViewById(R.id.icon);
	        
	        rowView.setTag(holder);

	    }else{
	    	
	        holder = (ViewHolderDeporte) rowView.getTag();
	    }
		
		holder.codigo.setText("Hobby Nº:"+ Integer.toString(deportes[position].getCodigo()));
		holder.nombre.setText(deportes[position].getNombre().toString());
	
		int idImagen = getDrawable(context, deportes[position].getNombreImagen());
		if (idImagen == 0){
			idImagen = getDrawable(context, "ic_launcher");
		}
		holder.imagen.setImageResource(idImagen);
		
		return rowView;
	}

	public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }
	
}