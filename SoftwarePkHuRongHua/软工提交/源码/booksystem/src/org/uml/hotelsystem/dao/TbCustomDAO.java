package org.uml.hotelsystem.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbCustom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbCustom
 * @author MyEclipse Persistence Tools
 */
public class TbCustomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbCustomDAO.class);
	// property constants
	public static final String CUSTOM_NAME = "customName";
	public static final String CUSTOM_ID_CARD_NUM = "customIdCardNum";
	public static final String CUSTOM_TELE_NUM = "customTeleNum";

	public void save(TbCustom transientInstance) {
		log.debug("saving TbCustom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbCustom persistentInstance) {
		log.debug("deleting TbCustom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbCustom findById(java.lang.Integer id) {
		log.debug("getting TbCustom instance with id: " + id);
		try {
			TbCustom instance = (TbCustom) getSession().get(
					"org.uml.hotelsystem.dao.TbCustom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbCustom instance) {
		log.debug("finding TbCustom instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbCustom")
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
		log.debug("finding TbCustom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbCustom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomName(Object customName) {
		return findByProperty(CUSTOM_NAME, customName);
	}

	public List findByCustomIdCardNum(Object customIdCardNum) {
		return findByProperty(CUSTOM_ID_CARD_NUM, customIdCardNum);
	}

	public List findByCustomTeleNum(Object customTeleNum) {
		return findByProperty(CUSTOM_TELE_NUM, customTeleNum);
	}

	public List findAll() {
		log.debug("finding all TbCustom instances");
		try {
			String queryString = "from TbCustom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbCustom merge(TbCustom detachedInstance) {
		log.debug("merging TbCustom instance");
		try {
			TbCustom result = (TbCustom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbCustom instance) {
		log.debug("attaching dirty TbCustom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbCustom instance) {
		log.debug("attaching clean TbCustom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}