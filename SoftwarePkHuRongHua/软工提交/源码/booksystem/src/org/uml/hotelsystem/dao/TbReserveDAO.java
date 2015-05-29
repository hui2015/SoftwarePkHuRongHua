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
 * TbReserve entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbReserve
 * @author MyEclipse Persistence Tools
 */
public class TbReserveDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbReserveDAO.class);
	// property constants
	public static final String RESERVE_ROOM_ID = "reserveRoomId";
	public static final String RESERVE_CUSTOM_ID = "reserveCustomId";
	public static final String RESERVE_CREATE_ACCOUNT_ID = "reserveCreateAccountId";

	public void save(TbReserve transientInstance) {
		log.debug("saving TbReserve instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbReserve persistentInstance) {
		log.debug("deleting TbReserve instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbReserve findById(java.lang.Integer id) {
		log.debug("getting TbReserve instance with id: " + id);
		try {
			TbReserve instance = (TbReserve) getSession().get(
					"org.uml.hotelsystem.dao.TbReserve", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbReserve instance) {
		log.debug("finding TbReserve instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbReserve")
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
		log.debug("finding TbReserve instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbReserve as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReserveRoomId(Object reserveRoomId) {
		return findByProperty(RESERVE_ROOM_ID, reserveRoomId);
	}

	public List findByReserveCustomId(Object reserveCustomId) {
		return findByProperty(RESERVE_CUSTOM_ID, reserveCustomId);
	}

	public List findByReserveCreateAccountId(Object reserveCreateAccountId) {
		return findByProperty(RESERVE_CREATE_ACCOUNT_ID, reserveCreateAccountId);
	}

	public List findAll() {
		log.debug("finding all TbReserve instances");
		try {
			String queryString = "from TbReserve";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbReserve merge(TbReserve detachedInstance) {
		log.debug("merging TbReserve instance");
		try {
			TbReserve result = (TbReserve) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbReserve instance) {
		log.debug("attaching dirty TbReserve instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbReserve instance) {
		log.debug("attaching clean TbReserve instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}