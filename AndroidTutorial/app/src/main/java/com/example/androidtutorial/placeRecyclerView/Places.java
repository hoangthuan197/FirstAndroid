package com.example.androidtutorial.placeRecyclerView;

public class Places {
    String placeName;
    int isMoreDetail,isPromotion;

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setIsMoreDetail(int isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }

    public Places(String placeName, int isMoreDetail, int  isPromotion) {
        this.placeName = placeName;
        this.isMoreDetail = isMoreDetail;
        this.isPromotion = isPromotion;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getIsMoreDetail() {
        return isMoreDetail;
    }

    public int getIsPromotion() {
        return isPromotion;
    }
}

