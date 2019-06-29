
package com.example.roomapp.network.http;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Alsultanh {

    @SerializedName("Emps")
    private List<Emp> mEmps;
    @SerializedName("error")
    private Boolean mError;

    public List<Emp> getEmps() {
        return mEmps;
    }

    public Boolean getError() {
        return mError;
    }

    public static class Builder {

        private List<Emp> mEmps;
        private Boolean mError;

        public Alsultanh.Builder withEmps(List<Emp> emps) {
            mEmps = emps;
            return this;
        }

        public Alsultanh.Builder withError(Boolean error) {
            mError = error;
            return this;
        }

        public Alsultanh build() {
            Alsultanh alsultanh = new Alsultanh();
            alsultanh.mEmps = mEmps;
            alsultanh.mError = mError;
            return alsultanh;
        }

    }

}
