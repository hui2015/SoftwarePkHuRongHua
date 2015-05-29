package org.uml.hotelsystem.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbGood entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbGood
 * @author MyEclipse Persistence Tools
 */
public class TbGoodDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbGoodDAO.class);
	// property constants
	public static final String GOOD_NAME = "goodName";
	public static final String GOOD_PRICE = "goodPrice";
	public static final String GOOD_USEABLE = "goodUseable";

	public void save(TbGood transientInstance) {
		log.debug("saving TbGood instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbGood persistentInstance) {
		log.debug("deleting TbGood instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbGood findById(java.lang.Integer id) {
		log.debug("getting TbGood instance with id: " + id);
		try {
			TbGood instance = (TbGood) getSession().get(
					"org.uml.hotelsystem.dao.TbGood", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbGood instance) {
		log.debug("finding TbGood instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbGood")
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
		log.debug("finding TbGood instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbGood as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodName(Object goodName) {
		return findByProperty(GOOD_NAME, goodName);
	}

	public List findByGoodPrice(Object goodPrice) {
		return findByProperty(GOOD_PRICE, goodPrice);
	}

	public List findByGoodUseable(Object goodUseable) {
		return findByProperty(GOOD_USEABLE, goodUseable);
	}

	public List findAll() {
		log.debug("finding all TbGood instances");
		try {
			String queryString = "from TbGood";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbGood merge(TbGood detachedInstance) {
		log.debug("merging TbGood instance");
		try {
			TbGood result = (TbGood) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbGood instance) {
		log.debug("attaching dirty TbGood instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbGood instance) {
		log.debug("attaching clean TbGood instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}