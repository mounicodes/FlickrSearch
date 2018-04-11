package com.mounica.flickrlookup;

/**
 * Created by mounicachikkam on 4/9/18.
 */

public class FlickrDataObject {

  private String id;
  private String owner;
  private String secret;
  private String server;
  private int farm;
  private String title;
  private int ispublic;
  private int isfriend;
  private int isfamily;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FlickrDataObject withId(String id) {
    this.id = id;
    return this;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public FlickrDataObject withOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public FlickrDataObject withSecret(String secret) {
    this.secret = secret;
    return this;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public FlickrDataObject withServer(String server) {
    this.server = server;
    return this;
  }

  public int getFarm() {
    return farm;
  }

  public void setFarm(int farm) {
    this.farm = farm;
  }

  public FlickrDataObject withFarm(int farm) {
    this.farm = farm;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public FlickrDataObject withTitle(String title) {
    this.title = title;
    return this;
  }

  public int getIspublic() {
    return ispublic;
  }

  public void setIspublic(int ispublic) {
    this.ispublic = ispublic;
  }

  public FlickrDataObject withIspublic(int ispublic) {
    this.ispublic = ispublic;
    return this;
  }

  public int getIsfriend() {
    return isfriend;
  }

  public void setIsfriend(int isfriend) {
    this.isfriend = isfriend;
  }

  public FlickrDataObject withIsfriend(int isfriend) {
    this.isfriend = isfriend;
    return this;
  }

  public int getIsfamily() {
    return isfamily;
  }

  public void setIsfamily(int isfamily) {
    this.isfamily = isfamily;
  }

  public FlickrDataObject withIsfamily(int isfamily) {
    this.isfamily = isfamily;
    return this;
  }

}
