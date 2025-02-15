/*
 * This file is part of Openrouteservice.
 *
 * Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, see <https://www.gnu.org/licenses/>.
 */

package org.heigit.ors.api.requests.routing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "Profile Weightings", name = "profileWeightings", description = "Describe additional weightings to be applied to edges on the routing.")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RequestProfileParamsWeightings {
    public static final String PARAM_STEEPNESS_DIFFICULTY = "steepness_difficulty";
    public static final String PARAM_GREEN_INDEX = "green";
    public static final String PARAM_QUIETNESS = "quiet";
    private static final String PARAM_CSV_FACTOR = "csv_factor";
    private static final String PARAM_CSV_COLUMN = "csv_column";
    public static final String PARAM_SHADOW_INDEX = "shadow";

    @Schema(name= PARAM_STEEPNESS_DIFFICULTY, description = """
            Specifies the fitness level for `cycling-*` profiles.

             level: 0 = Novice, 1 = Moderate, 2 = Amateur, 3 = Pro. The prefered gradient increases with level.""",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "profile"),
                    @ExtensionProperty(name = "value", value = "cycling-*")}
            )}, example = "2")
    @JsonProperty(PARAM_STEEPNESS_DIFFICULTY)
    private Integer steepnessDifficulty;
    @JsonIgnore
    private boolean hasSteepnessDifficulty = false;

    @Schema(name= PARAM_GREEN_INDEX, description = """
            Specifies the Green factor for `foot-*` profiles.

            factor: Multiplication factor range from 0 to 1. 0 is the green routing base factor without multiplying it by the manual factor and is already different from normal routing. 1 will prefer ways through green areas over a shorter route.""",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "profile"),
                    @ExtensionProperty(name = "value", value = "foot-*")}
            )}, example = "0.4")
    @JsonProperty(PARAM_GREEN_INDEX)
    private Float greenIndex;
    @JsonIgnore
    private boolean hasGreenIndex = false;

    @Schema(name= PARAM_QUIETNESS, description = """
            Specifies the Quiet factor for foot-* profiles.

            factor: Multiplication factor range from 0 to 1. 0 is the quiet routing base factor without multiplying it by the manual factor and is already different from normal routing. 1 will prefer quiet ways over a shorter route.""",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "profile"),
                    @ExtensionProperty(name = "value", value = "foot-*")}
            )}, example = "0.8")
    @JsonProperty(PARAM_QUIETNESS)
    private Float quietIndex;
    @JsonIgnore
    private boolean hasQuietIndex = false;

    @Schema(name = PARAM_CSV_FACTOR, description = "Specifies the factor of csv-column (range 0 to 1)", hidden = true)
    @JsonProperty(PARAM_CSV_FACTOR)
    private Float csvFactor;

    @Schema(name = PARAM_CSV_COLUMN, description = "Specifies the csv column name", hidden = true)
    @JsonProperty(PARAM_CSV_COLUMN)
    private String csvColumn;
    @JsonIgnore
    private boolean hasCsv = false;

    @Schema(name= PARAM_SHADOW_INDEX, description = """
            Specifies the shadow factor for `foot-*` profiles.

            factor: Multiplication factor range from 0 to 1. 0 is the shadow routing base factor without multiplying it by the manual factor and is already different from normal routing. 1 will prefer ways through shadow areas over a shorter route.""",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "profile"),
                    @ExtensionProperty(name = "value", value = "foot-*")}
            )}, example = "0.4")
    @JsonProperty(PARAM_SHADOW_INDEX)
    private Float shadowIndex;
    @JsonIgnore
    private boolean hasShadowIndex = false;

    public Integer getSteepnessDifficulty() {
        return steepnessDifficulty;
    }

    public void setSteepnessDifficulty(Integer steepnessDifficulty) {
        this.steepnessDifficulty = steepnessDifficulty;
        hasSteepnessDifficulty = true;
    }

    public Float getGreenIndex() {
        return greenIndex;
    }

    public void setGreenIndex(Float greenIndex) {
        this.greenIndex = greenIndex;
        hasGreenIndex = true;
    }

    public Float getQuietIndex() {
        return quietIndex;
    }

    public void setQuietIndex(Float quiteIndex) {
        this.quietIndex = quiteIndex;
        hasQuietIndex = true;
    }

    public Float getCsvFactor() {return csvFactor; }

    public void setCsvFactor(Float csvFactor) {
        this.csvFactor = csvFactor;
        hasCsv = true;
    }

    public String getCsvColumn() { return csvColumn; }

    public void setCsvColumn(String csvColumnName) {
        this.csvColumn = csvColumnName;
    }

    public Float getShadowIndex() {
        return shadowIndex;
    }

    public void setShadowIndex(Float shadowIndex) {
        this.shadowIndex = shadowIndex;
        hasShadowIndex = true;
    }

    public boolean hasSteepnessDifficulty() {
        return hasSteepnessDifficulty;
    }

    public boolean hasGreenIndex() {
        return hasGreenIndex;
    }

    public boolean hasQuietIndex() {
        return hasQuietIndex;
    }

    public boolean hasCsv() {
        return hasCsv;
    }

    public boolean hasShadowIndex() {
        return hasShadowIndex;
    }
}
