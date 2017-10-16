
package com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Sys {

    @SerializedName("pod")
    @Expose
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public Sys withPod(String pod) {
        this.pod = pod;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pod", pod).toString();
    }

}
