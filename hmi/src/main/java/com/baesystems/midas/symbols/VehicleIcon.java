package com.baesystems.midas.symbols;

import java.awt.Color;
import java.awt.Point;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.fixedfunc.GLLightingFunc;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import gov.nasa.worldwind.cache.GpuResourceCache;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Matrix;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.geom.Vec4;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.pick.PickSupport;
import gov.nasa.worldwind.pick.PickedObject;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.DrawContext;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.OrderedRenderable;
import gov.nasa.worldwind.render.ShapeAttributes;
import gov.nasa.worldwind.util.OGLStackHandler;

/**
 * @author graham.lund
 *
 */
public final class VehicleIcon implements OrderedRenderable, IDraggable, IDeletable
{
	private static final String FRONT = "Front";
	private static final String TAIL = "Tail";
	private static final String BORDER = "Border";
	private static final String LEADER = "Leader";
	private static final String STALE = "Stale";

	private static final Material RED = new Material(Color.BLACK, Color.RED, Color.RED, Color.RED, 0);

	/**
	 * @param dc
	 * @param radius
	 * @param key
	 * @return
	 */
	private static final int[] createDisplayList(final DrawContext dc, final int radius, final String part,
	            final java.lang.Object cacheKey)
	{
		// GL initialization checks for GL2 compatibility.
		final GL2 gl = dc.getGL().getGL2();

		final int[] dlResource = new int[]
			{ gl.glGenLists(1), 1 };

		int size;
		try
		{
			gl.glNewList(dlResource[0], GL2.GL_COMPILE);
			size = VehicleIcon.drawShape(dc, part);
			gl.glEndList();
		}
		catch (final Exception e)
		{
			gl.glEndList();
			gl.glDeleteLists(dlResource[0], dlResource[1]);
			return null;
		}

		dc.getGpuResourceCache().put(cacheKey, dlResource, GpuResourceCache.DISPLAY_LISTS, size);

		return dlResource;
	}

	/**
	 * @param dc
	 * @param part
	 * @return
	 */
	private static final int drawShape(final DrawContext dc, final String part)
	{
		final GL2 gl = dc.getGL().getGL2();

		final float yOffset = 0.5f;

		if (FRONT.equals(part))
		{
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0f, 1f, yOffset - 0.85f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset + 0.0f);
			gl.glVertex3f(.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glEnd();

			// gl.glBegin(GL2.GL_POLYGON);
			// gl.glNormal3f(0f, 1f, -0.2f);
			// gl.glVertex3f(0, 0, 0.65f);
			// gl.glVertex3f(0, 0.2f, -0.35f);
			// gl.glVertex3f(0, 0, -0.35f);
			// gl.glVertex3f(0, 0, 0.65f);
			// gl.glVertex3f(-.3f, 0, -0.2f);
			// gl.glEnd();

			return 5 * 3 * 5;
		}

		if (TAIL.equals(part))
		{
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0f, 1f, yOffset - 0.85f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset - 1.0f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glEnd();

			return 5 * 3 * 5;
		}

		if (BORDER.equals(part))
		{
			gl.glBegin(GL.GL_LINE_LOOP);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset - 1.0f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glEnd();

			gl.glBegin(GL.GL_LINE_LOOP);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset - 0.0f);
			gl.glVertex3f(.3f, 0, yOffset - 0.85f);
			gl.glVertex3f(-.3f, 0, yOffset - 0.85f);
			gl.glEnd();

			return 5 * 3 * 5;
		}

		if (LEADER.equals(part))
		{
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0f, 1f, yOffset - 0.85f);
			gl.glVertex3f(-.4f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset - 1.1f);
			gl.glVertex3f(.4f, 0, yOffset - 0.85f);
			gl.glVertex3f(0, 0, yOffset + 0.85f / 3);
			gl.glVertex3f(-.4f, 0, yOffset - 0.85f);
			gl.glEnd();

			return 5 * 3 * 5;
		}

		if (STALE.equals(part))
		{
			gl.glBegin(GL.GL_LINE_STRIP);
			gl.glVertex2d(1, 1);
			gl.glVertex2d(-1, -1);
			gl.glEnd();

			gl.glBegin(GL.GL_LINE_STRIP);
			gl.glVertex2d(1, -1);
			gl.glVertex2d(-1, 1);
			gl.glEnd();

			return 5 * 3 * 5;
		}

		return 0;
	}

	/***********************************************************************************/

	private java.lang.Object frontKey = new java.lang.Object();
	private java.lang.Object tailKey = new java.lang.Object();
	private java.lang.Object borderKey = new java.lang.Object();
	private java.lang.Object leaderKey = new java.lang.Object();
	private java.lang.Object staleKey = new java.lang.Object();

	private PickSupport pickSupport = new PickSupport();
	private boolean stale = false;
	private boolean formationLeader = false;
	private Angle heading = null;
	private Angle pitch = null;
	private Angle roll = null;
	private Position position = null;
	private Double size = 1.0;
	private Material tailFill = null;
	private ShapeAttributes shapeAttributes = new BasicShapeAttributes();
	private boolean visible = true;
	private boolean isInitialized = false;
	private GLUquadric quadric = null;
	private Layer pickLayer = null;
	private double eyeDistance = 0;
	private boolean dragging = false;

	private boolean disposed = false;
	private com.baesystems.midas.Object object;

	/***********************************************************************************/

	/**
	 * Constructor
	 *
	 * @param decorator
	 */
	public VehicleIcon(com.baesystems.midas.Object object)
	{
		final Color color = Color.CYAN;
		this.tailFill = new Material(Color.BLACK, color, color, color, 0);

		this.formationLeader = false;

		this.object = object;
	}

	/**
	 * @param dc
	 */
	private void begin(final DrawContext dc)
	{
		if (this.disposed) { return; }

		final GL2 gl = dc.getGL().getGL2(); // GL initialization checks for GL2
		                                    // compatibility.
		final Vec4 cameraPosition = dc.getView().getEyePoint();

		if (dc.isPickingMode())
		{
			this.pickSupport.beginPicking(dc);

			gl.glPushAttrib(GL2.GL_ENABLE_BIT | GL2.GL_CURRENT_BIT | GL2.GL_TRANSFORM_BIT);
			gl.glDisable(GLLightingFunc.GL_COLOR_MATERIAL);
		}
		else
		{
			gl.glPushAttrib(GL2.GL_ENABLE_BIT | GL2.GL_CURRENT_BIT | GL2.GL_LIGHTING_BIT | GL2.GL_TRANSFORM_BIT
			            | GL.GL_COLOR_BUFFER_BIT);

			final float[] lightPosition =
				{ (float) (cameraPosition.x * 2), (float) (cameraPosition.y / 2), (float) cameraPosition.z, 0.0f };

			final float[] lightDiffuse =
				{ 1.0f, 1.0f, 1.0f, 1.0f };

			final float[] lightAmbient =
				{ 1.0f, 1.0f, 1.0f, 1.0f };

			final float[] lightSpecular =
				{ 1.0f, 1.0f, 1.0f, 1.0f };

			gl.glDisable(GLLightingFunc.GL_COLOR_MATERIAL);

			gl.glLightfv(GLLightingFunc.GL_LIGHT1, GLLightingFunc.GL_POSITION, lightPosition, 0);
			gl.glLightfv(GLLightingFunc.GL_LIGHT1, GLLightingFunc.GL_DIFFUSE, lightDiffuse, 0);
			gl.glLightfv(GLLightingFunc.GL_LIGHT1, GLLightingFunc.GL_AMBIENT, lightAmbient, 0);
			gl.glLightfv(GLLightingFunc.GL_LIGHT1, GLLightingFunc.GL_SPECULAR, lightSpecular, 0);

			gl.glDisable(GLLightingFunc.GL_LIGHT0);
			gl.glEnable(GLLightingFunc.GL_LIGHT1);
			gl.glEnable(GLLightingFunc.GL_LIGHTING);
			gl.glEnable(GLLightingFunc.GL_NORMALIZE);

			// Set up for opacity, either explictly via attributes or implicitly
			// as alpha in the marker color
			gl.glEnable(GL.GL_BLEND);
			gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

			gl.glEnable(GL.GL_LINE_SMOOTH);
			gl.glLineWidth((float) this.shapeAttributes.getOutlineWidth());

			if (this.shapeAttributes.getOutlineStippleFactor() > 0)
			{
				gl.glEnable(GL2.GL_LINE_STIPPLE);
				gl.glLineStipple(this.shapeAttributes.getOutlineStippleFactor(),
				            this.shapeAttributes.getOutlineStipplePattern());
			}
		}

		gl.glDepthFunc(GL.GL_ALWAYS);

		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
		gl.glPushMatrix();
	}

	public Position getReferencePosition() {
		return position;
	}

	/**
	 * @param dc
	 */
	public void drawOrderedRenderable(final DrawContext dc)
	{
		if (this.disposed) { return; }

		if (null == this.pitch) { return; }

		if (null == this.roll) { return; }

		if (null == this.heading) { return; }

		if (null == this.position) { return; }

		try
		{
			int[] dlResource = null;

			this.begin(dc);

			if (dc.isPickingMode())
			{
				final java.awt.Color color = dc.getUniquePickColor();
				final int colorCode = color.getRGB();
				final PickedObject po = new PickedObject(colorCode, this, this.position, false);

				this.pickSupport.addPickableObject(po);

				final GL2 gl = dc.getGL().getGL2(); // GL initialization checks
				                                    // for GL2 compatibility.
				gl.glColor3ub((byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue());
			}

			if (!this.isInitialized)
			{
				this.initialize(dc);
			}

			final GL2 gl = dc.getGL().getGL2();

			if (null == this.heading) { return; }

			final Vec4 point = dc.getGlobe().computePointFromPosition(this.position);

			this.eyeDistance = point.distanceTo3(dc.getView().getEyePoint());

			dc.getView().pushReferenceCenter(dc, point);

			final LatLon p2ll = LatLon.greatCircleEndPosition(this.position, this.heading, Angle.fromDegrees(.1));
			final Vec4 p2 = dc.getGlobe().computePointFromPosition(p2ll.getLatitude(), p2ll.getLongitude(),
			            this.position.getElevation());

			final Vec4 p1p2 = p2.subtract3(point).normalize3();

			final Angle directionAngle = Angle.fromRadians(Math.acos(p1p2.z));

			final double A = -p1p2.y;
			final double B = p1p2.x;
			final double L = Math.sqrt(A * A + B * B);

			final Vec4 horizontalVector = dc.getGlobe().computeSurfaceNormalAtPoint(point).cross3(p1p2);
			final Vec4 rotatedX = Vec4.UNIT_X.transformBy3(Matrix.fromAxisAngle(directionAngle, A / L, B / L, 0));
			final Angle rollAngle = rotatedX.angleBetween3(horizontalVector);

			final double rollDirection = Math.signum(-horizontalVector.cross3(rotatedX).dot3(p1p2));

			gl.glRotated(directionAngle.degrees, A / L, B / L, 0);
			gl.glRotated(rollAngle.degrees, 0, 0, rollDirection);

			gl.glRotated(this.pitch.degrees * -1, 1, 0, 0);
			gl.glRotated(this.roll.degrees, 0, 0, 1);

			final double scale = point.distanceTo3(dc.getView().getEyePoint()) / 50 * this.size;
			gl.glScaled(scale, scale, scale);

			if (this.formationLeader)
			{
				if (!dc.isPickingMode())
				{
					final Material material = this.shapeAttributes.getInteriorMaterial();
					final float opacity = (float) this.shapeAttributes.getInteriorOpacity();
					if (!dc.isPickingMode() && null != material)
					{
						if (opacity < 1)
						{
							material.apply(gl, GL.GL_FRONT, opacity);
						}
						else
						{
							material.apply(gl, GL.GL_FRONT);
						}
					}
				}

				dlResource = (int[]) dc.getGpuResourceCache().get(this.leaderKey);
				if (null == dlResource)
				{
					dlResource = VehicleIcon.createDisplayList(dc, 6, LEADER, this.leaderKey);
				}

				gl.glCallList(dlResource[0]);
			}

			if (!dc.isPickingMode())
			{
				final Material material = this.shapeAttributes.getInteriorMaterial();
				final float opacity = (float) this.shapeAttributes.getInteriorOpacity();
				if (!dc.isPickingMode() && null != material)
				{
					if (opacity < 1)
					{
						material.apply(gl, GL.GL_FRONT, opacity);
					}
					else
					{
						material.apply(gl, GL.GL_FRONT);
					}
				}
			}

			dlResource = (int[]) dc.getGpuResourceCache().get(this.frontKey);
			if (null == dlResource)
			{
				dlResource = VehicleIcon.createDisplayList(dc, 6, FRONT, this.frontKey);
			}

			gl.glCallList(dlResource[0]);

			if (!dc.isPickingMode())
			{
				final float opacity = (float) this.shapeAttributes.getInteriorOpacity();
				if (!dc.isPickingMode() && null != this.tailFill)
				{
					if (opacity < 1)
					{
						this.tailFill.apply(gl, GL.GL_FRONT, opacity);
					}
					else
					{
						this.tailFill.apply(gl, GL.GL_FRONT);
					}
				}
			}

			dlResource = (int[]) dc.getGpuResourceCache().get(this.tailKey);
			if (null == dlResource)
			{
				dlResource = VehicleIcon.createDisplayList(dc, 6, TAIL, this.tailKey);
			}

			gl.glCallList(dlResource[0]);

			if (!dc.isPickingMode())
			{
				final Material material = this.shapeAttributes.getOutlineMaterial();
				final float opacity = (float) this.shapeAttributes.getOutlineOpacity();
				if (!dc.isPickingMode() && null != material)
				{
					if (opacity < 1)
					{
						material.apply(gl, GL.GL_FRONT, opacity);
					}
					else
					{
						material.apply(gl, GL.GL_FRONT);
					}
				}
			}

			dlResource = (int[]) dc.getGpuResourceCache().get(this.borderKey);
			if (null == dlResource)
			{
				dlResource = VehicleIcon.createDisplayList(dc, 6, BORDER, this.borderKey);
			}

			gl.glCallList(dlResource[0]);

			dc.getView().popReferenceCenter(dc);

			if (this.stale)
			{
				final OGLStackHandler osh = new OGLStackHandler();

				osh.pushProjectionIdentity(gl);
				gl.glOrtho(0d, dc.getView().getViewport().width, 0d, dc.getView().getViewport().height, -1d, 1d);

				final Vec4 sp = dc.getView().project(point);

				osh.pushModelviewIdentity(gl);
				gl.glTranslated(sp.x, sp.y, sp.z);
				gl.glScaled(10, 10, 1);

				gl.glDisable(GL2.GL_LINE_STIPPLE);

				if (!dc.isPickingMode())
				{
					RED.apply(gl, GL.GL_FRONT);
				}

				dlResource = (int[]) dc.getGpuResourceCache().get(this.staleKey);
				if (null == dlResource)
				{
					dlResource = VehicleIcon.createDisplayList(dc, 6, STALE, this.staleKey);
				}

				gl.glCallList(dlResource[0]);

				osh.pop(gl);
			}

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.end(dc);
		}
	}

	/**
	 * @param dc
	 */
	private void end(final DrawContext dc)
	{
		final GL2 gl = dc.getGL().getGL2(); // GL initialization checks for GL2
		                                    // compatibility.

		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
		gl.glPopMatrix();

		if (dc.isPickingMode())
		{
			this.pickSupport.endPicking(dc);
		}
		else
		{
			gl.glDisable(GLLightingFunc.GL_LIGHT1);
			gl.glEnable(GLLightingFunc.GL_LIGHT0);
			gl.glDisable(GLLightingFunc.GL_LIGHTING);
			gl.glDisable(GLLightingFunc.GL_NORMALIZE);
		}

		gl.glPopAttrib();
	}

	/*
	 * (non-Javadoc)
	 * @see gov.nasa.worldwind.render.OrderedRenderable#getDistanceFromEye()
	 */
	@Override
	public double getDistanceFromEye()
	{
		return this.eyeDistance;
	}

	/**
	 * @param dc
	 */
	private void initialize(final DrawContext dc)
	{
		this.quadric = dc.getGLU().gluNewQuadric();

		dc.getGLU().gluQuadricDrawStyle(this.quadric, GLU.GLU_FILL);
		dc.getGLU().gluQuadricNormals(this.quadric, GLU.GLU_SMOOTH);
		dc.getGLU().gluQuadricOrientation(this.quadric, GLU.GLU_OUTSIDE);
		dc.getGLU().gluQuadricTexture(this.quadric, false);

		this.isInitialized = true;
	}

	/**
	 * @param dc
	 */
	private void makeOrderedRenderable(final DrawContext dc)
	{
		dc.addOrderedRenderable(this);

		if (dc.isPickingMode())
		{
			this.pickLayer = dc.getCurrentLayer();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see gov.nasa.worldwind.render.OrderedRenderable#pick(gov.nasa.worldwind. render.DrawContext, java.awt.Point)
	 */
	@Override
	public void pick(final DrawContext dc, final Point pickPoint)
	{
		this.pickSupport.clearPickList();

		try
		{
			this.pickSupport.beginPicking(dc);

			this.render(dc);
		}
		finally
		{
			this.pickSupport.endPicking(dc);
			this.pickSupport.resolvePick(dc, pickPoint, this.pickLayer);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see gov.nasa.worldwind.render.Renderable#render(gov.nasa.worldwind.render. DrawContext)
	 */
	@Override
	public void render(final DrawContext dc)
	{
		if (!this.visible) { return; }

		if (dc.isOrderedRenderingMode())
		{
			this.drawOrderedRenderable(dc);
		}
		else
		{
			this.makeOrderedRenderable(dc);
		}
	}

	/**
	 * @param attributes
	 */
	public void setAttributes(final ShapeAttributes attributes)
	{
		attributes.setInteriorMaterial(new Material(Color.BLACK, attributes.getInteriorMaterial().getDiffuse(),
		            attributes.getInteriorMaterial().getDiffuse(), attributes.getInteriorMaterial().getDiffuse(), 0));

		attributes.setOutlineMaterial(new Material(Color.BLACK, attributes.getOutlineMaterial().getDiffuse(),
		            attributes.getOutlineMaterial().getDiffuse(), attributes.getOutlineMaterial().getDiffuse(), 0));

		this.shapeAttributes = attributes;
	}

	/**
	 * @param formationLeader
	 * @return
	 */
	public VehicleIcon setFormationLeader(final boolean formationLeader)
	{
		this.formationLeader = formationLeader;

		return this;
	}

	/**
	 * @param heading
	 * @return
	 */
	public void setHeading(final Angle heading)
	{
		this.heading = heading;
	}

	/**
	 * @param pitch
	 * @return
	 */
	public VehicleIcon setPitch(final Angle pitch)
	{
		this.pitch = pitch;

		return this;
	}

	/**
	 * @param position
	 * @return
	 */
	public void move(final Position position)
	{
		this.position = position;
	}

		/**
	 * @param position
	 * @return
	 */
	public void moveTo(final Position position)
	{
		move(position);
	}

	/**
	 * @param roll
	 * @return
	 */
	public VehicleIcon setRoll(final Angle roll)
	{
		this.roll = roll;

		return this;
	}

	/**
	 * @param size
	 * @return
	 */
	public VehicleIcon setSize(final Double size)
	{
		this.size = size;

		return this;
	}

	/**
	 * @param stale
	 */
	public void setStale(final boolean stale)
	{
		this.stale = stale;
	}

	/**
	 * @param colour
	 */
	public void setTailColour(final Color colour)
	{
		this.tailFill = new Material(Color.BLACK, colour, colour, colour, 0);
	}

	/**
	 * @param visible
	 */
	public void setVisible(final boolean visible)
	{
		this.visible = visible;
	}

	public void setPosition(Position position) {
		if(!this.dragging) {
			this.position = position;
		}
	}

	@Override
	public void drop() {
		this.dragging = false;
		object.notifyPosition(this.position);
	}

	@Override
	public void startDrag() {
		this.dragging = true;		
	}

	@Override
	public void delete() {
		object.deleted();
	}
}
