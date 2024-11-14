package com.baesystems.environmentinfrastructure.db;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.locationtech.jts.geom.Geometry;

import com.baesystems.environmentinfrastructure.airspace.Airspace;
import com.baesystems.environmentinfrastructure.airspace.AirspaceVolume;
import com.baesystems.environmentinfrastructure.application.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class AirspaceDao {

	private Session session;

	public AirspaceDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public List<Airspace> getAirspace() {
		// Get all features and convert
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Airspace> cr = cb.createQuery(Airspace.class);
		Root<Airspace> root = cr.from(Airspace.class);
		cr.select(root);

		Query<Airspace> query = session.createQuery(cr);

		return query.list();
	}

	public List<AirspaceVolume> getAirspaceVolumes(Geometry bounds) {
		// Get features and convert
		Query<AirspaceVolume> query = session.createQuery(
				"select v from AirspaceVolume v where intersects(:bounds, v.horizontalProjection) = true",
				AirspaceVolume.class);
		query.setParameter("bounds", bounds);

		return query.list();
	}

	public Airspace getAirspace(String ref) {
		// Get the database object
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Airspace> cr = cb.createQuery(Airspace.class);
		Root<Airspace> root = cr.from(Airspace.class);
		cr.select(root).where(cb.equal(root.get("uid"), ref));

		Query<Airspace> query = session.createQuery(cr);

		return query.getSingleResultOrNull();
	}

	public void addAirspace(Airspace airspace) {
		try {
			// Start a new transaction to save the feature
			session.beginTransaction();

			// Save the feature
			session.persist(airspace);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
