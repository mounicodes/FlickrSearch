package com.mounica.flickrlookup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter implementation
 */

public class FlckrAdapter extends RecyclerView.Adapter<FlckrAdapter.ImageHolder> {

  private List<Photo> mFlickrList = new ArrayList<>();
  private Context mContext;

  public FlckrAdapter(List<Photo> flickrList, Context context) {
    mFlickrList = flickrList;
    mContext = context;
  }

  @Override
  public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.imageholder, null);
    return new ImageHolder(view);
  }

  @Override
  public void onBindViewHolder(ImageHolder holder, int position) {
    Photo flckrObj = mFlickrList.get(position);
    String pictureUrl =
        "http://farm" + flckrObj.getFarm() + ".static.flickr.com/" + flckrObj.getServer() + "/"
            + flckrObj.getId() + "_" + flckrObj.getSecret() + ".jpg ";
    Glide.with(mContext)
        .load(pictureUrl)
        .into(holder.mImageView);
  }

  @Override
  public int getItemCount() {
    return mFlickrList.size();
  }

  public static class ImageHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;

    public ImageHolder(View itemView) {
      super(itemView);
      mImageView = itemView.findViewById(R.id.image);
      mImageView.getLayoutParams().width = (int) (itemView.getContext().getResources().getDisplayMetrics().widthPixels * 0.30);
      mImageView.getLayoutParams().height = (int) (itemView.getContext().getResources().getDisplayMetrics().widthPixels * 0.30);
    }
  }
}
