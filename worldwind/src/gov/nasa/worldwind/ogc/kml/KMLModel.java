/*
 * Copyright 2006-2009, 2017, 2020 United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 * 
 * The NASA World Wind Java (WWJ) platform is licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * NASA World Wind Java (WWJ) also contains the following 3rd party Open Source
 * software:
 * 
 *     Jackson Parser – Licensed under Apache 2.0
 *     GDAL – Licensed under MIT
 *     JOGL – Licensed under  Berkeley Software Distribution (BSD)
 *     Gluegen – Licensed under Berkeley Software Distribution (BSD)
 * 
 * A complete listing of 3rd Party software notices and licenses included in
 * NASA World Wind Java (WWJ)  can be found in the WorldWindJava-v2.2 3rd-party
 * notices and licenses PDF found in code directory.
 */

package gov.nasa.worldwind.ogc.kml;

/**
 * Represents the KML <i>Model</i> element and provides access to its contents.
 *
 * @author tag
 * @version $Id: KMLModel.java 1171 2013-02-11 21:45:02Z dcollins $
 */
public class KMLModel extends KMLAbstractGeometry
{
    /** Flag to indicate that the link has been fetched from the hash map. */
    protected boolean linkFetched = false;
    protected KMLLink link;

    /**
     * Construct an instance.
     *
     * @param namespaceURI the qualifying namespace URI. May be null to indicate no namespace qualification.
     */
    public KMLModel(String namespaceURI)
    {
        super(namespaceURI);
    }

    public String getAltitudeMode()
    {
        return (String) this.getField("altitudeMode");
    }

    public KMLLocation getLocation()
    {
        return (KMLLocation) this.getField("Location");
    }

    public KMLOrientation getOrientation()
    {
        return (KMLOrientation) this.getField("Orientation");
    }

    public KMLScale getScale()
    {
        return (KMLScale) this.getField("Scale");
    }

    public KMLLink getLink()
    {
        if (!this.linkFetched)
        {
            this.link = (KMLLink) this.getField("Link");
            this.linkFetched = true;
        }
        return this.link;
    }

    public KMLResourceMap getResourceMap()
    {
        return (KMLResourceMap) this.getField("ResourceMap");
    }
}