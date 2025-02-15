package org.heigit.ors.api.responses.isochrones.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import org.locationtech.jts.geom.Coordinate;
import io.swagger.v3.oas.annotations.media.Schema;
import org.heigit.ors.common.AttributeValue;
import org.heigit.ors.isochrones.Isochrone;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GeoJSONIsochroneProperties {
    @Schema(description = "Id of the isochrone based on the position in the `locations` query-parameter. Every location comprises its own group of polygons.", example ="1")
    @JsonProperty(value = "group_index")
    private final Integer groupIndex;

    @Schema(description = "The range value of this isochrone/equidistant in seconds/meters.", example = "90")
    @JsonProperty("value")
    private final Double value;

    @Schema(description = "The coordinates of the specific analysis location.", example = "[8.676441,49.411648]")
    @JsonProperty("center")
    private final Double[] center;

    @Schema(description = "Area of the polygon in square meters (for attributes=area).",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "attributes"),
                    @ExtensionProperty(name = "containsValue", value = "area")}
            )},
            example = "567.827")
    @JsonProperty("area")
    private Double area;

    @Schema(description = """
            Returns a reachability score between 0 and 1 (for attributes=reachfactor). \
            As the maximum reachfactor would be achieved by travelling as the crow flies at maximum speed in a vacuum \
            without obstacles, naturally it can never be 1. The availability of motorways however produces a higher score over normal roads.\
            """,
            example = "0.56")
    @JsonProperty("reachfactor")
    private Double reachfactor;

    @Schema(description = "Total population of the polygon (for attributes=total_pop).",
            extensions = { @Extension(name = "validWhen", properties = {
                    @ExtensionProperty(name = "ref", value = "attributes"),
                    @ExtensionProperty(name = "containsValue", value = "total_pop")}
            )},
            example = "562789")
    @JsonProperty(value = "total_pop")
    private Double totalPop;


    public GeoJSONIsochroneProperties(Isochrone isochrone, Coordinate center, int groupIndex) {
        this.groupIndex = groupIndex;
        if (isochrone.hasArea())
            this.area = isochrone.getArea();
        this.value = isochrone.getValue();
        this.center = new Double[]{center.x, center.y};
        if (isochrone.hasReachfactor())
            this.reachfactor = isochrone.getReachfactor();
        if (isochrone.getAttributes() != null && !isochrone.getAttributes().isEmpty())
            for (AttributeValue attributeValue : isochrone.getAttributes()) {
                if (attributeValue.getName().equalsIgnoreCase("total_pop"))
                    this.totalPop = attributeValue.getValue();
            }
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    public Double getValue() {
        return value;
    }

    public Double[] getCenter() {
        return center;
    }

    public Double getArea() {
        return area;
    }

    public Double getReachfactor() {
        return reachfactor;
    }

    public Double getTotalPop() {
        return totalPop;
    }
}
