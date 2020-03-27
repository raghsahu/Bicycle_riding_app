package dev.raghav.bicycleapp.model_pojo;

/**
 * Created by Raghvendra Sahu on 23-Mar-20.
 */
public class DrawerItem {
    private long iconImg;
    private String itemName;
    private String item_id;


    public DrawerItem(long iconImg, String itemName) {
        this.iconImg = iconImg;
        this.itemName = itemName;
    }



    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public long getIconImg() {
        return iconImg;
    }

    public void setIconImg(long iconImg) {
        this.iconImg = iconImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
