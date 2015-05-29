package org.uml.hotelsystem.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbRoom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbRoom
 * @author MyEclipse Persistence Tools
 */
public class TbRoomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbRoomDAO.class);
	// property constants
	public static final String ROOM_NAME = "roomName";
	public static final String ROOM_TYPE = "roomType";
	public static final String ROOM_PRICE = "roomPrice";
	public static final String ROOM_USEABLE = "roomUseable";
	public static final String ROOM_CUR_STATE = "roomCurState";

	public void save(TbRoom transientInstance) {
		log.debug("saving TbRoom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbRoom persistentInstance) {
		log.debug("deleting TbRoom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbRoom findById(java.lang.Integer id) {
		log.debug("getting TbRoom instance with id: " + id);
		try {
			TbRoom instance = (TbRoom) getSession().get(
					"org.uml.hotelsystem.dao.TbRoom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbRoom instance) {
		log.debug("finding TbRoom instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbRoom")
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
		log.debug("finding TbRoom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbRoom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoomName(Object roomName) {
		return findByProperty(ROOM_NAME, roomName);
	}

	public List findByRoomType(Object roomType) {
		return findByProperty(ROOM_TYPE, roomType);
	}

	public List findByRoomPrice(Object roomPrice) {
		return findByProperty(ROOM_PRICE, roomPrice);
	}

	public List findByRoomUseable(Object roomUseable) {
		return findByProperty(ROOM_USEABLE, roomUseable);
	}

	public List findByRoomCurState(Object roomCurState) {
		return findByProperty(ROOM_CUR_STATE, roomCurState);
	}

	public List findAll() {
		log.debug("finding all TbRoom instances");
		try {
			String queryString = "from TbRoom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbRoom merge(TbRoom detachedInstance) {
		log.debug("merging TbRoom instance");
		try {
			TbRoom result = (TbRoom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbRoom instance) {
		log.debug("attaching dirty TbRoom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbRoom instance) {
		log.debug("attaching clean TbRoom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}