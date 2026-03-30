package com.kofu.seasong.content.dimensions;

public enum OceanDimension {
    SURFACE_DEPTHS,
    TWILIGHT_DEPTHS,
    THALASSIC_ABYSS;

    public static OceanDimension fromValue(int idx) throws IllegalArgumentException {
        OceanDimension[] dims = OceanDimension.values();
        if (idx < 0 || idx >= dims.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        return dims[idx];
    }
}
