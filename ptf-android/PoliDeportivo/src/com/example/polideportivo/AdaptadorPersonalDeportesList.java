package com.example.polideportivo;

import java.util.List;

import junit.framework.Assert;
import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class AdaptadorPersonalDeportesList implements ListAdapter {

	private List<Deporte> deportes;
	private Activity context;

	public AdaptadorPersonalDeportesList(Activity context, List<Deporte> deportes) {
		this.context = context;
		this.deportes = deportes;
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
		
		holder.codigo.setText("Hobby Nº:"+ Integer.toString(deportes.get(position).getCodigo()));
		holder.nombre.setText(deportes.get(position).getNombre().toString());
	
		int idImagen = getDrawable(context, deportes.get(position).getNombreImagen());
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
	
	@Override
	public int getCount() {
		return deportes.size();
	}

	@Override
	public Object getItem(int position) {
		return deportes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		return R.layout.linea_deporte;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean areAllItemsEnabled() {
		return true;
	}

	@Override
	public boolean isEnabled(int position) {
		
		return true;
	}
}