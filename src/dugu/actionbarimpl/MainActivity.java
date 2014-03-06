package dugu.actionbarimpl;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnSuggestionListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getSupportActionBar().setDisplayShowHomeEnabled(false);
		//getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		MenuItem searchItem = menu.findItem(R.id.action_search);
		Log.i("menuitem", searchItem.getItemId()+"");
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		if(searchView==null){
			Log.i("null", "000");
			return false;
		}
		SearchManager manager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
		searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
		searchView.setOnSuggestionListener(new OnSuggestionListener() {
			
			@Override
			public boolean onSuggestionSelect(int arg0) {
				// TODO Auto-generated method stub
				Log.i("select", "select");
				return false;
			}
			
			@Override
			public boolean onSuggestionClick(int arg0) {
				// TODO Auto-generated method stub
				Log.i("click", "click");
				return false;
			}
		});
		searchView.setIconifiedByDefault(false);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.action_search: Log.i("search", "search");return true;
			case R.id.action_settings: Log.i("settings", "settings");return true;
			case R.id.action_refresh: Log.i("refresh","refresh");return true;
			default: return super.onOptionsItemSelected(item);
		}
	}
	
	
}
