package com.mounica.flickrlookup;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
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

  private static final String FLICKR_URL = "https://api.flickr.com/services/rest/?\n"
      + "method=flickr.photos.search";
  private SearchView mSearch;
  private RequestQueue mRequestQueue;
  private List<FlickrDataObject> mImageList = new ArrayList<>();
  private static final String TAG = "MainActivity";
  private FlckrAdapter mFlckrAdapter;
  private RecyclerView mRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mSearch = findViewById(R.id.searchbutton);
    mRecyclerView = findViewById(R.id.recyclerview);
    mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    mFlckrAdapter = new FlckrAdapter(mImageList, this);
    mRecyclerView.setAdapter(mFlckrAdapter);
    mSearch.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        if (query != null) {
          loadImages(query);
        }
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        //TODO implement on query change
        return true;
      }
    });
  }

  private void loadImages(String searchText) {
    mRequestQueue = Volley.newRequestQueue(this);
    String url = Uri.parse(FLICKR_URL)
        .buildUpon()
        .appendQueryParameter("api_key", getResources().getString(R.string.api_key))
        .appendQueryParameter("format", "json")
        .appendQueryParameter("nojsoncallback", "1")
        .appendQueryParameter("text", searchText)
        .toString();

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
            try {
              JSONObject photos = response.getJSONObject("photos");
              JSONArray photoList = photos.getJSONArray("photo");
              for (int i = 0; i < photoList.length(); i++) {
                JSONObject eachPhoto = photoList.getJSONObject(i);
                FlickrDataObject flckr = new FlickrDataObject();
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
}



