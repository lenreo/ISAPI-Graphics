package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Magnitude;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Graphic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-21T19:15:10.264Z[GMT]")
public class Graphic   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("magnitude")
  private Magnitude magnitude = null;

  @JsonProperty("start_date")
  private OffsetDateTime startDate = null;

  @JsonProperty("end_date")
  private OffsetDateTime endDate = null;

  @JsonProperty("data")
  private String data = null;

  public Graphic id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Graphic magnitude(Magnitude magnitude) {
    this.magnitude = magnitude;
    return this;
  }

  /**
   * Get magnitude
   * @return magnitude
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Magnitude getMagnitude() {
    return magnitude;
  }

  public void setMagnitude(Magnitude magnitude) {
    this.magnitude = magnitude;
  }

  public Graphic startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Graphic endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public Graphic data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  
    public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Graphic graphic = (Graphic) o;
    return Objects.equals(this.id, graphic.id) &&
        Objects.equals(this.magnitude, graphic.magnitude) &&
        Objects.equals(this.startDate, graphic.startDate) &&
        Objects.equals(this.endDate, graphic.endDate) &&
        Objects.equals(this.data, graphic.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, magnitude, startDate, endDate, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Graphic {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    magnitude: ").append(toIndentedString(magnitude)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
