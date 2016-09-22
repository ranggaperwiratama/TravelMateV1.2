package com.example.swipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailTourismSpot extends Fragment {
	View v;
	
	public static String _nama_spot;
	public static String _alamat_spot;
	
	private String nama_villa = "0", alamat_villa="0";
	
	private TextView textFull,textAlamat;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.detailturismspot, container, false);
        
		/*_harga_villa = MainActivity2.harga_villa;*/
		
		Bundle b = getActivity().getIntent().getExtras();
		nama_villa = b.getString("namaspot");
		alamat_villa = b.getString("alamatspot");
		
		textFull = (TextView) v.findViewById(R.id.textFull);
		textAlamat =(TextView) v.findViewById(R.id.textAlamat);
		
		textFull.setText(nama_villa);
		textAlamat.setText(alamat_villa);
		return v;
	}
	
}
