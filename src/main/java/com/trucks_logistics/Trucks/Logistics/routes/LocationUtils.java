package com.trucks_logistics.Trucks.Logistics.routes;

public class LocationUtils {
    private static final double EARTH_RADIUS_KM = 6371.0;

    private LocationUtils() {
        // Evita que se cree una instancia de esta clase
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Calcula la distancia entre dos puntos geográficos usando la fórmula de
     * Haversine.
     * 
     * @param lat1 Latitud origen
     * @param lon1 Longitud origen
     * @param lat2 Latitud destino
     * @param lon2 Longitud destino
     * @return Distancia en kilómetros
     */
    public static double locationDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convertimos las latitudes y longitudes de grados a radianes
        double radLat = Math.toRadians(lat2 - lat1);
        double radLon = Math.toRadians(lon2 - lon1);

        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);

        // Aplicamos la fórmula: a es el cuadrado de la mitad de la longitud de la
        // cuerda
        // de un círculo máximo entre los puntos.
        double a = Math.sin(radLat / 2) * Math.sin(radLat / 2) +
                Math.cos(radLat1) * Math.cos(radLat2) *
                        Math.sin(radLon / 2) * Math.sin(radLon / 2);

        // c es la distancia angular en radianes
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }
}
