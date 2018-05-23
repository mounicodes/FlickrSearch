package com.mounica.flickrlookup;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private static final String FLICKR_URL = "https://api.flickr.com/services/rest/?\n"
      + "method=flickr.photos.search";
  private RequestQueue mRequestQueue;
  private List<Photo> mImageList = new ArrayList<>();
  private FlckrAdapter mFlckrAdapter;
  private RecyclerView mRecyclerView;
  private Toolbar mToolBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolBar = findViewById(R.id.toolbar);
    setSupportActionBar(mToolBar);
    mRecyclerView = findViewById(R.id.recyclerview);
    mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    mFlckrAdapter = new FlckrAdapter(mImageList, this);
    mRecyclerView.setAdapter(mFlckrAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    MenuItem item = menu.findItem(R.id.action_search);
    final SearchView search = (SearchView) item.getActionView();
    search.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        search.clearFocus();
        if (query != null) {
          mImageList.clear();
          mRequestQueue = Volley.newRequestQueue(getBaseContext());
          String url = buildUrl(FLICKR_URL, getResources().getString(R.string.api_key), query);
          createJsonRequest(url);
        }
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    return super.onCreateOptionsMenu(menu);
  }

  private void createJsonRequest(String url) {
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
            try {
              JSONObject photos = response.getJSONObject("photos");
              JSONArray photoList = photos.getJSONArray("photo");
              for (int i = 0; i < photoList.length(); i++) {
                JSONObject eachPhoto = photoList.getJSONObject(i);
                Photo flckr = new Photo();
                flckr.setFarm(eachPhoto.getInt("farm"));
                flckr.setId(eachPhoto.getString("id"));
                flckr.setSecret(eachPhoto.getString("secret"));
                flckr.setServer(eachPhoto.getString("server"));
                mImageList.add(flckr);
              }
              mFlckrAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
              Toast.makeText(MainActivity.this, "JsonException", Toast.LENGTH_SHORT).show();
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "Volley Error");
      }
    });
    mRequestQueue.add(request);
  }

  private String buildUrl(String url, String apiKey, String query) {
    return Uri.parse(url)
        .buildUpon()
        .appendQueryParameter("api_key", apiKey)
        .appendQueryParameter("format", "json")
        .appendQueryParameter("nojsoncallback", "1")
        .appendQueryParameter("text", query)
        .toString();
  }
}



