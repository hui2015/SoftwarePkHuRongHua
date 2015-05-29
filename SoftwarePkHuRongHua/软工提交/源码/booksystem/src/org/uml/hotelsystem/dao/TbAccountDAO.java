package org.uml.hotelsystem.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbAccount entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbAccount
 * @author MyEclipse Persistence Tools
 */
public class TbAccountDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbAccountDAO.class);
	// property constants
	public static final String ACCOUNT_USER = "accountUser";
	public static final String ACCOUNT_NAME = "accountName";
	public static final String ACCOUNT_PASSWORD = "accountPassword";
	public static final String ACCOUNT_AUTHORITY = "accountAuthority";
	public static final String ACCOUNT_USABLE = "accountUsable";

	public void save(TbAccount transientInstance) {
		log.debug("saving TbAccount instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbAccount persistentInstance) {
		log.debug("deleting TbAccount instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbAccount findById(java.lang.Integer id) {
		log.debug("getting TbAccount instance with id: " + id);
		try {
			TbAccount instance = (TbAccount) getSession().get(
					"org.uml.hotelsystem.dao.TbAccount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbAccount instance) {
		log.debug("finding TbAccount instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbAccount")
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
		log.debug("finding TbAccount instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbAccount as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccountUser(Object accountUser) {
		return findByProperty(ACCOUNT_USER, accountUser);
	}

	public List findByAccountName(Object accountName) {
		return findByProperty(ACCOUNT_NAME, accountName);
	}

	public List findByAccountPassword(Object accountPassword) {
		return findByProperty(ACCOUNT_PASSWORD, accountPassword);
	}

	public List findByAccountAuthority(Object accountAuthority) {
		return findByProperty(ACCOUNT_AUTHORITY, accountAuthority);
	}

	public List findByAccountUsable(Object accountUsable) {
		return findByProperty(ACCOUNT_USABLE, accountUsable);
	}

	public List findAll() {
		log.debug("finding all TbAccount instances");
		try {
			String queryString = "from TbAccount";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbAccount merge(TbAccount detachedInstance) {
		log.debug("merging TbAccount instance");
		try {
			TbAccount result = (TbAccount) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbAccount instance) {
		log.debug("attaching dirty TbAccount instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbAccount instance) {
		log.debug("attaching clean TbAccount instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}