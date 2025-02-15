package org.heigit.ors.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.graphhopper.routing.weighting.Weighting.INFINITE_U_TURN_COSTS;

@Configuration
@ConfigurationProperties(prefix = "endpoints")
public class EndpointsProperties {
    private EndpointDefaultProperties defaults;
    private EndpointRoutingProperties routing;
    private EndpointMatrixProperties matrix;
    private EndpointIsochroneProperties isochrone;

    private String swaggerDocumentationUrl;

    public void setSwaggerDocumentationUrl(String swaggerDocumentationUrl) {
        this.swaggerDocumentationUrl = swaggerDocumentationUrl;
    }

    public String getSwaggerDocumentationUrl() {
        return swaggerDocumentationUrl;
    }

    public EndpointDefaultProperties getDefaults() {
        return defaults;
    }

    public void setDefaults(EndpointDefaultProperties defaults) {
        this.defaults = defaults;
    }

    public EndpointRoutingProperties getRouting() {
        return routing;
    }

    public void setRouting(EndpointRoutingProperties routing) {
        this.routing = routing;
    }

    public EndpointMatrixProperties getMatrix() {
        return matrix;
    }

    public void setMatrix(EndpointMatrixProperties matrix) {
        this.matrix = matrix;
    }

    public EndpointIsochroneProperties getIsochrone() {
        return isochrone;
    }

    public void setIsochrone(EndpointIsochroneProperties isochrone) {
        this.isochrone = isochrone;
    }

    public static class EndpointDefaultProperties {
        private String attribution;

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }
    }

    public static class EndpointRoutingProperties {
        private boolean enabled;
        private String attribution;
        private String gpxName;
        private String gpxDescription;
        private String gpxBaseUrl;
        private String gpxSupportMail;
        private String gpxAuthor;
        private String gpxContentLicence;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public String getGpxName() {
            return gpxName;
        }

        public void setGpxName(String gpxName) {
            this.gpxName = gpxName;
        }

        public String getGpxDescription() {
            return gpxDescription;
        }

        public void setGpxDescription(String gpxDescription) {
            this.gpxDescription = gpxDescription;
        }

        public String getGpxBaseUrl() {
            return gpxBaseUrl;
        }

        public void setGpxBaseUrl(String gpxBaseUrl) {
            this.gpxBaseUrl = gpxBaseUrl;
        }

        public String getGpxSupportMail() {
            return gpxSupportMail;
        }

        public void setGpxSupportMail(String gpxSupportMail) {
            this.gpxSupportMail = gpxSupportMail;
        }

        public String getGpxAuthor() {
            return gpxAuthor;
        }

        public void setGpxAuthor(String gpxAuthor) {
            this.gpxAuthor = gpxAuthor;
        }

        public String getGpxContentLicence() {
            return gpxContentLicence;
        }

        public void setGpxContentLicence(String gpxContentLicence) {
            this.gpxContentLicence = gpxContentLicence;
        }
    }

    public static class EndpointMatrixProperties {
        private boolean enabled;
        private String attribution;
        private int maximumRoutes = 2500;
        private int maximumRoutesFlexible = 25;
        private int maximumVisitedNodes = 100000;
        private double maximumSearchRadius = 2000;
        // TODO: this parameter is only used in a binary check for infinity (==-1);
        //       Can't we reduce it to a boolean "forbid_u_turns"?
        private double uTurnCost = INFINITE_U_TURN_COSTS;


        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public int getMaximumRoutes(boolean flexible) {
            return (flexible ? maximumRoutesFlexible : maximumRoutes);
        }

        public void setMaximumRoutes(int maximumRoutes) {
            this.maximumRoutes = maximumRoutes;
        }

        public void setMaximumRoutesFlexible(int maximumRoutesFlexible) {
            this.maximumRoutesFlexible = maximumRoutesFlexible;
        }

        public int getMaximumVisitedNodes() {
            return maximumVisitedNodes;
        }

        public void setMaximumVisitedNodes(int maximumVisitedNodes) {
            this.maximumVisitedNodes = maximumVisitedNodes;
        }

        public double getMaximumSearchRadius() {
            return maximumSearchRadius;
        }

        public void setMaximumSearchRadius(double maximumSearchRadius) {
            this.maximumSearchRadius = maximumSearchRadius;
        }

        public double getUTurnCost() {
            return uTurnCost;
        }

        public void setUTurnCost(double uTurnCosts) {
            this.uTurnCost = uTurnCosts;
        }
    }

    public static class EndpointIsochroneProperties {
        private boolean enabled;
        private String attribution;
        private int maximumLocations;
        private boolean allowComputeArea = true;
        private int maximumIntervals = 1;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public int getMaximumLocations() {
            return maximumLocations;
        }

        public void setMaximumLocations(int maximumLocations) {
            this.maximumLocations = maximumLocations;
        }

        public boolean isAllowComputeArea() {
            return allowComputeArea;
        }

        public void setAllowComputeArea(boolean allowComputeArea) {
            this.allowComputeArea = allowComputeArea;
        }

        public int getMaximumIntervals() {
            return maximumIntervals;
        }

        public void setMaximumIntervals(int maximumIntervals) {
            this.maximumIntervals = maximumIntervals;
        }
    }
}
