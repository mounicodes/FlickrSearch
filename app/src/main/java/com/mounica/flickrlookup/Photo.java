package com.mounica.flickrlookup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("owner")
  @Expose
  private String owner;
  @SerializedName("secret")
  @Expose
  private String secret;
  @SerializedName("server")
  @Expose
  private String server;
  @SerializedName("farm")
  @Expose
  private int farm;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("ispublic")
  @Expose
  private int ispublic;
  @SerializedName("isfriend")
  @Expose
  private int isfriend;
  @SerializedName("isfamily")
  @Expose
  private int isfamily;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Photo withId(String id) {
    this.id = id;
    return this;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Photo withOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public Photo withSecret(String secret) {
    this.secret = secret;
    return this;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public Photo withServer(String server) {
    this.server = server;
    return this;
  }

  public int getFarm() {
    return farm;
  }

  public void setFarm(int farm) {
    this.farm = farm;
  }

  public Photo withFarm(int farm) {
    this.farm = farm;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Photo withTitle(String title) {
    this.title = title;
    return this;
  }

  public int getIspublic() {
    return ispublic;
  }

  public void setIspublic(int ispublic) {
    this.ispublic = ispublic;
  }

  public Photo withIspublic(int ispublic) {
    this.ispublic = ispublic;
    return this;
  }

  public int getIsfriend() {
    return isfriend;
  }

  public void setIsfriend(int isfriend) {
    this.isfriend = isfriend;
  }

  public Photo withIsfriend(int isfriend) {
    this.isfriend = isfriend;
    return this;
  }

  public int getIsfamily() {
    return isfamily;
  }

  public void setIsfamily(int isfamily) {
    this.isfamily = isfamily;
  }

  public Photo withIsfamily(int isfamily) {
    this.isfamily = isfamily;
    return this;
  }

}
