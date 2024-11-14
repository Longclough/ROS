package com.baesystems.midas;

public final class Cartesian
{
	public double n;
	public double e;
	public double d;

	/***********************************************************************************/

	/**
	 * The constructor
	 *
	 * @param n
	 *            - position north
	 * @param e
	 *            - position east
	 * @param d
	 *            - position down
	 */
	public Cartesian(final double n, final double e, final double d)
	{
		this.n = n;
		this.e = e;
		this.d = d;
	}
}