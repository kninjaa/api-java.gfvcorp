/*
 * api_java_gfvcorp API
 * api_java_gfvcorp API
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * RresponseVehicle
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T13:06:09.898871600-03:00[America/Sao_Paulo]")
public class RresponseVehicle {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_CLIENT = "client";
  @SerializedName(SERIALIZED_NAME_CLIENT)
  private Integer client;

  public static final String SERIALIZED_NAME_PLATE = "plate";
  @SerializedName(SERIALIZED_NAME_PLATE)
  private String plate;

  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;

  public static final String SERIALIZED_NAME_WEIGHT = "weight";
  @SerializedName(SERIALIZED_NAME_WEIGHT)
  private Float weight;

  public static final String SERIALIZED_NAME_QUANTITY_AXES = "quantityAxes";
  @SerializedName(SERIALIZED_NAME_QUANTITY_AXES)
  private Integer quantityAxes;

  public static final String SERIALIZED_NAME_MODIFICATION = "modification";
  @SerializedName(SERIALIZED_NAME_MODIFICATION)
  private Boolean modification;

  public static final String SERIALIZED_NAME_BLINDAGE = "blindage";
  @SerializedName(SERIALIZED_NAME_BLINDAGE)
  private Boolean blindage;

  public static final String SERIALIZED_NAME_CHARGE = "charge";
  @SerializedName(SERIALIZED_NAME_CHARGE)
  private Boolean charge;

  public static final String SERIALIZED_NAME_MODEL = "model";
  @SerializedName(SERIALIZED_NAME_MODEL)
  private String model;

  public RresponseVehicle() {
  }

  public RresponseVehicle id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public RresponseVehicle client(Integer client) {
    
    this.client = client;
    return this;
  }

   /**
   * Get client
   * @return client
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getClient() {
    return client;
  }


  public void setClient(Integer client) {
    this.client = client;
  }


  public RresponseVehicle plate(String plate) {
    
    this.plate = plate;
    return this;
  }

   /**
   * Get plate
   * @return plate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPlate() {
    return plate;
  }


  public void setPlate(String plate) {
    this.plate = plate;
  }


  public RresponseVehicle size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }


  public RresponseVehicle weight(Float weight) {
    
    this.weight = weight;
    return this;
  }

   /**
   * Get weight
   * @return weight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Float getWeight() {
    return weight;
  }


  public void setWeight(Float weight) {
    this.weight = weight;
  }


  public RresponseVehicle quantityAxes(Integer quantityAxes) {
    
    this.quantityAxes = quantityAxes;
    return this;
  }

   /**
   * Get quantityAxes
   * @return quantityAxes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getQuantityAxes() {
    return quantityAxes;
  }


  public void setQuantityAxes(Integer quantityAxes) {
    this.quantityAxes = quantityAxes;
  }


  public RresponseVehicle modification(Boolean modification) {
    
    this.modification = modification;
    return this;
  }

   /**
   * Get modification
   * @return modification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getModification() {
    return modification;
  }


  public void setModification(Boolean modification) {
    this.modification = modification;
  }


  public RresponseVehicle blindage(Boolean blindage) {
    
    this.blindage = blindage;
    return this;
  }

   /**
   * Get blindage
   * @return blindage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getBlindage() {
    return blindage;
  }


  public void setBlindage(Boolean blindage) {
    this.blindage = blindage;
  }


  public RresponseVehicle charge(Boolean charge) {
    
    this.charge = charge;
    return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getCharge() {
    return charge;
  }


  public void setCharge(Boolean charge) {
    this.charge = charge;
  }


  public RresponseVehicle model(String model) {
    
    this.model = model;
    return this;
  }

   /**
   * Get model
   * @return model
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getModel() {
    return model;
  }


  public void setModel(String model) {
    this.model = model;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RresponseVehicle rresponseVehicle = (RresponseVehicle) o;
    return Objects.equals(this.id, rresponseVehicle.id) &&
        Objects.equals(this.client, rresponseVehicle.client) &&
        Objects.equals(this.plate, rresponseVehicle.plate) &&
        Objects.equals(this.size, rresponseVehicle.size) &&
        Objects.equals(this.weight, rresponseVehicle.weight) &&
        Objects.equals(this.quantityAxes, rresponseVehicle.quantityAxes) &&
        Objects.equals(this.modification, rresponseVehicle.modification) &&
        Objects.equals(this.blindage, rresponseVehicle.blindage) &&
        Objects.equals(this.charge, rresponseVehicle.charge) &&
        Objects.equals(this.model, rresponseVehicle.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, client, plate, size, weight, quantityAxes, modification, blindage, charge, model);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RresponseVehicle {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    quantityAxes: ").append(toIndentedString(quantityAxes)).append("\n");
    sb.append("    modification: ").append(toIndentedString(modification)).append("\n");
    sb.append("    blindage: ").append(toIndentedString(blindage)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("client");
    openapiFields.add("plate");
    openapiFields.add("size");
    openapiFields.add("weight");
    openapiFields.add("quantityAxes");
    openapiFields.add("modification");
    openapiFields.add("blindage");
    openapiFields.add("charge");
    openapiFields.add("model");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RresponseVehicle
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (RresponseVehicle.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in RresponseVehicle is not found in the empty JSON string", RresponseVehicle.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RresponseVehicle.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RresponseVehicle` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("plate") != null && !jsonObj.get("plate").isJsonNull()) && !jsonObj.get("plate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plate").toString()));
      }
      if ((jsonObj.get("model") != null && !jsonObj.get("model").isJsonNull()) && !jsonObj.get("model").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `model` to be a primitive type in the JSON string but got `%s`", jsonObj.get("model").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RresponseVehicle.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RresponseVehicle' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RresponseVehicle> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RresponseVehicle.class));

       return (TypeAdapter<T>) new TypeAdapter<RresponseVehicle>() {
           @Override
           public void write(JsonWriter out, RresponseVehicle value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RresponseVehicle read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RresponseVehicle given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RresponseVehicle
  * @throws IOException if the JSON string is invalid with respect to RresponseVehicle
  */
  public static RresponseVehicle fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RresponseVehicle.class);
  }

 /**
  * Convert an instance of RresponseVehicle to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

