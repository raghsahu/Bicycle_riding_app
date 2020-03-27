package dev.raghav.bicycleapp.model_pojo;

public class ListBikeStoreItem {
    String store_name;
    String store_distance;
    String bike_avail;

    public ListBikeStoreItem(String store_name, String store_distance, String bike_avail) {
        this.store_name = store_name;
        this.store_distance = store_distance;
        this.bike_avail = bike_avail;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_distance() {
        return store_distance;
    }

    public void setStore_distance(String store_distance) {
        this.store_distance = store_distance;
    }

    public String getBike_avail() {
        return bike_avail;
    }

    public void setBike_avail(String bike_avail) {
        this.bike_avail = bike_avail;
    }
}
