package org.uml.hotelsystem.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbLivein entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbLivein
 * @author MyEclipse Persistence Tools
 */
public class TbLiveinDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbLiveinDAO.class);
	// property constants
	public static final String LIVEIN_CUSTOM_ID = "liveinCustomId";
	public static final String LIVEIN_ROOM_ID = "liveinRoomId";
	public static final String LIVEIN_CREATE_ACCOUNT_ID = "liveinCreateAccountId";

	public void save(TbLivein transientInstance) {
		log.debug("saving TbLivein instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbLivein persistentInstance) {
		log.debug("deleting TbLivein instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbLivein findById(java.lang.Integer id) {
		log.debug("getting TbLivein instance with id: " + id);
		try {
			TbLivein instance = (TbLivein) getSession().get(
					"org.uml.hotelsystem.dao.TbLivein", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbLivein instance) {
		log.debug("finding TbLivein instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbLivein")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbLivein instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbLivein as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLiveinCustomId(Object liveinCustomId) {
		return findByProperty(LIVEIN_CUSTOM_ID, liveinCustomId);
	}

	public List findByLiveinRoomId(Object liveinRoomId) {
		return findByProperty(LIVEIN_ROOM_ID, liveinRoomId);
	}

	public List findByLiveinCreateAccountId(Object liveinCreateAccountId) {
		return findByProperty(LIVEIN_CREATE_ACCOUNT_ID, liveinCreateAccountId);
	}

	public List findAll() {
		log.debug("finding all TbLivein instances");
		try {
			String queryString = "from TbLivein";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbLivein merge(TbLivein detachedInstance) {
		log.debug("merging TbLivein instance");
		try {
			TbLivein result = (TbLivein) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbLivein instance) {
		log.debug("attaching dirty TbLivein instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbLivein instance) {
		log.debug("attaching clean TbLivein instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}