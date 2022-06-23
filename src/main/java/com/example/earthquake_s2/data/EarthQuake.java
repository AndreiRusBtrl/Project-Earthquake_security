
package com.example.earthquake_s2.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "occurred_on",
    "latitude",
    "longitude",
    "depth",
    "magnitude",
    "calculation_method",
    "network_id",
    "place",
    "cause"
})
@Generated("jsonschema2pojo")
public class EarthQuake {

    @JsonProperty("id")
    private int id;
    @JsonProperty("occurred_on")
    private String occurredOn;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("depth")
    private float depth;
    @JsonProperty("magnitude")
    private float magnitude;
    @JsonProperty("calculation_method")
    private String calculationMethod;
    @JsonProperty("network_id")
    private String networkId;
    @JsonProperty("place")
    private String place;
    @JsonProperty("cause")
    private String cause;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EarthQuake() {
    }

    /**
     * 
     * @param calculationMethod
     * @param depth
     * @param latitude
     * @param cause
     * @param magnitude
     * @param networkId
     * @param id
     * @param place
     * @param occurredOn
     * @param longitude
     */
    public EarthQuake(int id, String occurredOn, double latitude, double longitude, float depth, float magnitude, String calculationMethod, String networkId, String place, String cause) {
        super();
        this.id = id;
        this.occurredOn = occurredOn;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.calculationMethod = calculationMethod;
        this.networkId = networkId;
        this.place = place;
        this.cause = cause;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("occurred_on")
    public String getOccurredOn() {
        return occurredOn;
    }

    @JsonProperty("occurred_on")
    public void setOccurredOn(String occurredOn) {
        this.occurredOn = occurredOn;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("depth")
    public float getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(float depth) {
        this.depth = depth;
    }

    @JsonProperty("magnitude")
    public float getMagnitude() {
        return magnitude;
    }

    @JsonProperty("magnitude")
    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    @JsonProperty("calculation_method")
    public String getCalculationMethod() {
        return calculationMethod;
    }

    @JsonProperty("calculation_method")
    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    @JsonProperty("network_id")
    public String getNetworkId() {
        return networkId;
    }

    @JsonProperty("network_id")
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    @JsonProperty("place")
    public String getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(String place) {
        this.place = place;
    }

    @JsonProperty("cause")
    public String getCause() {
        return cause;
    }

    @JsonProperty("cause")
    public void setCause(String cause) {
        this.cause = cause;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EarthQuake.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("occurredOn");
        sb.append('=');
        sb.append(((this.occurredOn == null)?"<null>":this.occurredOn));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(this.latitude);
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(this.longitude);
        sb.append(',');
        sb.append("depth");
        sb.append('=');
        sb.append(this.depth);
        sb.append(',');
        sb.append("magnitude");
        sb.append('=');
        sb.append(this.magnitude);
        sb.append(',');
        sb.append("calculationMethod");
        sb.append('=');
        sb.append(((this.calculationMethod == null)?"<null>":this.calculationMethod));
        sb.append(',');
        sb.append("networkId");
        sb.append('=');
        sb.append(((this.networkId == null)?"<null>":this.networkId));
        sb.append(',');
        sb.append("place");
        sb.append('=');
        sb.append(((this.place == null)?"<null>":this.place));
        sb.append(',');
        sb.append("cause");
        sb.append('=');
        sb.append(((this.cause == null)?"<null>":this.cause));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
