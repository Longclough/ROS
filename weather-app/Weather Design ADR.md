# ADR Weather App Design

**Date:** 1st June 2023

**Author:** Luke Waddington

**Status:** `Current`

## Context

Design Decision taken by MIDAS team for weather app design.

## Decision

- Weather snapshot to be taken from meteomatics API in geotiff format. 

- geotiff to be converted into shapefiles using GDAL and read into geojson data.

- Weather app to receive REST API call from calculate route and return GeoJSON data.


