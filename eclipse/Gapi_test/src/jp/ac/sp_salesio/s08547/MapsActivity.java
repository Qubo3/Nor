package jp.ac.sp_salesio.s08547;

import java.io.IOException;
import java.util.*;

import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.app.AlertDialog;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MapsActivity extends com.google.android.maps.MapActivity implements OnCheckedChangeListener {

    private MapView map = null;
	private RadioButton normalMapRadio = null;
	private RadioGroup radioGroup = null;
	private ToggleButton currentLocationToggle = null;
	private MapController controller = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        
        map  = (MapView)findViewById(R.id.map);
        normalMapRadio  = (RadioButton)findViewById(R.id.normalMapRadio);
        
        normalMapRadio.setChecked(true);
        radioGroup  = (RadioGroup)findViewById(R.id.mapRadioGroup);
        
        radioGroup.setOnCheckedChangeListener(this);
        currentLocationToggle  = (ToggleButton)findViewById(R.id.currentLocationToggle);
        
        controller = map.getController();
        map.setBuiltInZoomControls(true);
        map.setSatellite(false);
        map.setClickable(true);
        map.setEnabled(true);
        
        Geocoder geocoder = new Geocoder( this, Locale.getDefault());
        
        //Intent intent = getIntent();
        String strAddress = "東京都小平市上水南町1-24-16-8";
        
        try {
        	List<Address> addressList = geocoder.getFromLocationName(strAddress, 10);
        	
        	Address address = null;
        	
        	if( addressList.isEmpty()){
        		String message = getResources().getString(R.string.cannot_get_address);
        		Toast toast = Toast.makeText(this, message + "[" + strAddress + "]", Toast.LENGTH_SHORT);
        		toast.show();
        	}else if( addressList.size() == 1){
        		address = addressList.get(0);
        	}else{
        		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        		alertDialogBuilder.setTitle(R.string.select_target);
        		
        		List<String> strAddressList = new ArrayList<String>();
        		for( Address element:addressList){
        			int maxAddressLineIdx = element.getMaxAddressLineIndex();
        			strAddressList.add(element.getAddressLine(maxAddressLineIdx));
        		}
        		
        		AddressSelectionListener listener = new AddressSelectionListener( addressList);
        		ListView listView = new ListView(this);
        		ArrayAdapter<String> listAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strAddressList);
        		listView.setAdapter(listAdaptor);
        		listView.setOnItemClickListener(listener);
        		
        		alertDialogBuilder.setView(listView);
        		
        		AlertDialog dialog = alertDialogBuilder.create();
        		listener.setDialog(dialog);
        		dialog.show();
        	}
        	
        	if( address != null){
        		setDist(address);
        	}
        } catch (IOException e) {
        	Toast toast = Toast.makeText(this, R.string.cannot_get_address, Toast.LENGTH_SHORT);
        	toast.show();
        }
    }
	
	class AddressSelectionListener implements OnItemClickListener{
		private List<Address> listAddress = null;
		private AlertDialog dialog = null;
		private AddressSelectionListener( List<Address> listAddress){
			this.listAddress = listAddress;
		}
		public AlertDialog getDialog() {
			return dialog;
		}
		public void setDialog(AlertDialog dialog) {
			this.dialog = dialog;
		}
		public void onItemClick(AdapterView<?> parent, View view, int position,    long id) {
			Address address = listAddress.get( position);
			setDist( address);
			dialog.dismiss();
		}
	}
	
	protected void setDist(Address address){
		//TODO あとで
	}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_maps, menu);
        return true;
    }*/
    
    @Override
    protected boolean isRouteDisplayed(){
    	return false;
    }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if( checkedId == R.id.normalMapRadio){
			map.setSatellite(false);
		}
		else if( checkedId == R.id.satelliteMapRadio){
			map.setSatellite(true);
		}
	}
}
