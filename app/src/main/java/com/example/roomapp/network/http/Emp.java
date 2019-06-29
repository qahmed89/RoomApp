
package com.example.roomapp.network.http;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Emp {

    @SerializedName("city_id")
    private Long mCityId;
    @SerializedName("city_name")
    private String mCityName;
    @SerializedName("emp_active")
    private Long mEmpActive;
    @SerializedName("emp_api_key")
    private String mEmpApiKey;
    @SerializedName("emp_city_id")
    private Long mEmpCityId;
    @SerializedName("emp_created_at")
    private String mEmpCreatedAt;
    @SerializedName("emp_firebase_token")
    private String mEmpFirebaseToken;
    @SerializedName("emp_home_phone")
    private String mEmpHomePhone;
    @SerializedName("emp_id")
    private Long mEmpId;
    @SerializedName("emp_lat")
    private String mEmpLat;
    @SerializedName("emp_lng")
    private String mEmpLng;
    @SerializedName("emp_minum_price")
    private Long mEmpMinumPrice;
    @SerializedName("emp_name")
    private String mEmpName;
    @SerializedName("emp_password")
    private String mEmpPassword;
    @SerializedName("emp_permisson")
    private Long mEmpPermisson;
    @SerializedName("emp_phone")
    private String mEmpPhone;
    @SerializedName("emp_pic_url")
    private String mEmpPicUrl;
    @SerializedName("emp_price_delivery")
    private Long mEmpPriceDelivery;
    @SerializedName("emp_time_lunch")
    private Long mEmpTimeLunch;
    @SerializedName("emp_type_delivery")
    private Long mEmpTypeDelivery;
    @SerializedName("feed_back")
    private String mFeedBack;
    @SerializedName("feed_back_number")
    private Long mFeedBackNumber;

    public Long getCityId() {
        return mCityId;
    }

    public String getCityName() {
        return mCityName;
    }

    public Long getEmpActive() {
        return mEmpActive;
    }

    public String getEmpApiKey() {
        return mEmpApiKey;
    }

    public Long getEmpCityId() {
        return mEmpCityId;
    }

    public String getEmpCreatedAt() {
        return mEmpCreatedAt;
    }

    public String getEmpFirebaseToken() {
        return mEmpFirebaseToken;
    }

    public String getEmpHomePhone() {
        return mEmpHomePhone;
    }

    public Long getEmpId() {
        return mEmpId;
    }

    public String getEmpLat() {
        return mEmpLat;
    }

    public String getEmpLng() {
        return mEmpLng;
    }

    public Long getEmpMinumPrice() {
        return mEmpMinumPrice;
    }

    public String getEmpName() {
        return mEmpName;
    }

    public String getEmpPassword() {
        return mEmpPassword;
    }

    public Long getEmpPermisson() {
        return mEmpPermisson;
    }

    public String getEmpPhone() {
        return mEmpPhone;
    }

    public String getEmpPicUrl() {
        return mEmpPicUrl;
    }

    public Long getEmpPriceDelivery() {
        return mEmpPriceDelivery;
    }

    public Long getEmpTimeLunch() {
        return mEmpTimeLunch;
    }

    public Long getEmpTypeDelivery() {
        return mEmpTypeDelivery;
    }

    public String getFeedBack() {
        return mFeedBack;
    }

    public Long getFeedBackNumber() {
        return mFeedBackNumber;
    }

    public static class Builder {

        private Long mCityId;
        private String mCityName;
        private Long mEmpActive;
        private String mEmpApiKey;
        private Long mEmpCityId;
        private String mEmpCreatedAt;
        private String mEmpFirebaseToken;
        private String mEmpHomePhone;
        private Long mEmpId;
        private String mEmpLat;
        private String mEmpLng;
        private Long mEmpMinumPrice;
        private String mEmpName;
        private String mEmpPassword;
        private Long mEmpPermisson;
        private String mEmpPhone;
        private String mEmpPicUrl;
        private Long mEmpPriceDelivery;
        private Long mEmpTimeLunch;
        private Long mEmpTypeDelivery;
        private String mFeedBack;
        private Long mFeedBackNumber;

        public Emp.Builder withCityId(Long cityId) {
            mCityId = cityId;
            return this;
        }

        public Emp.Builder withCityName(String cityName) {
            mCityName = cityName;
            return this;
        }

        public Emp.Builder withEmpActive(Long empActive) {
            mEmpActive = empActive;
            return this;
        }

        public Emp.Builder withEmpApiKey(String empApiKey) {
            mEmpApiKey = empApiKey;
            return this;
        }

        public Emp.Builder withEmpCityId(Long empCityId) {
            mEmpCityId = empCityId;
            return this;
        }

        public Emp.Builder withEmpCreatedAt(String empCreatedAt) {
            mEmpCreatedAt = empCreatedAt;
            return this;
        }

        public Emp.Builder withEmpFirebaseToken(String empFirebaseToken) {
            mEmpFirebaseToken = empFirebaseToken;
            return this;
        }

        public Emp.Builder withEmpHomePhone(String empHomePhone) {
            mEmpHomePhone = empHomePhone;
            return this;
        }

        public Emp.Builder withEmpId(Long empId) {
            mEmpId = empId;
            return this;
        }

        public Emp.Builder withEmpLat(String empLat) {
            mEmpLat = empLat;
            return this;
        }

        public Emp.Builder withEmpLng(String empLng) {
            mEmpLng = empLng;
            return this;
        }

        public Emp.Builder withEmpMinumPrice(Long empMinumPrice) {
            mEmpMinumPrice = empMinumPrice;
            return this;
        }

        public Emp.Builder withEmpName(String empName) {
            mEmpName = empName;
            return this;
        }

        public Emp.Builder withEmpPassword(String empPassword) {
            mEmpPassword = empPassword;
            return this;
        }

        public Emp.Builder withEmpPermisson(Long empPermisson) {
            mEmpPermisson = empPermisson;
            return this;
        }

        public Emp.Builder withEmpPhone(String empPhone) {
            mEmpPhone = empPhone;
            return this;
        }

        public Emp.Builder withEmpPicUrl(String empPicUrl) {
            mEmpPicUrl = empPicUrl;
            return this;
        }

        public Emp.Builder withEmpPriceDelivery(Long empPriceDelivery) {
            mEmpPriceDelivery = empPriceDelivery;
            return this;
        }

        public Emp.Builder withEmpTimeLunch(Long empTimeLunch) {
            mEmpTimeLunch = empTimeLunch;
            return this;
        }

        public Emp.Builder withEmpTypeDelivery(Long empTypeDelivery) {
            mEmpTypeDelivery = empTypeDelivery;
            return this;
        }

        public Emp.Builder withFeedBack(String feedBack) {
            mFeedBack = feedBack;
            return this;
        }

        public Emp.Builder withFeedBackNumber(Long feedBackNumber) {
            mFeedBackNumber = feedBackNumber;
            return this;
        }

        public Emp build() {
            Emp emp = new Emp();
            emp.mCityId = mCityId;
            emp.mCityName = mCityName;
            emp.mEmpActive = mEmpActive;
            emp.mEmpApiKey = mEmpApiKey;
            emp.mEmpCityId = mEmpCityId;
            emp.mEmpCreatedAt = mEmpCreatedAt;
            emp.mEmpFirebaseToken = mEmpFirebaseToken;
            emp.mEmpHomePhone = mEmpHomePhone;
            emp.mEmpId = mEmpId;
            emp.mEmpLat = mEmpLat;
            emp.mEmpLng = mEmpLng;
            emp.mEmpMinumPrice = mEmpMinumPrice;
            emp.mEmpName = mEmpName;
            emp.mEmpPassword = mEmpPassword;
            emp.mEmpPermisson = mEmpPermisson;
            emp.mEmpPhone = mEmpPhone;
            emp.mEmpPicUrl = mEmpPicUrl;
            emp.mEmpPriceDelivery = mEmpPriceDelivery;
            emp.mEmpTimeLunch = mEmpTimeLunch;
            emp.mEmpTypeDelivery = mEmpTypeDelivery;
            emp.mFeedBack = mFeedBack;
            emp.mFeedBackNumber = mFeedBackNumber;
            return emp;
        }

    }

}
