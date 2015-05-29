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
 * TbBill entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.uml.hotelsystem.dao.TbBill
 * @author MyEclipse Persistence Tools
 */
public class TbBillDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbBillDAO.class);
	// property constants
	public static final String BILL_ROOM_TYPE = "billRoomType";
	public static final String BILL_ROOM_NAME = "billRoomName";
	public static final String BILL_ROOM_PRICE = "billRoomPrice";
	public static final String BILL_CUSTOM_ID = "billCustomId";
	public static final String BILL_CUSTOM_NAME = "billCustomName";
	public static final String BILL_CUSTOM_CARD_ID = "billCustomCardId";
	public static final String BILL_CUSTOM_TELE = "billCustomTele";
	public static final String BILL_CREATE_ACCOUNT_ID = "billCreateAccountId";
	public static final String BILL_CREATE_ACCOUNT_NAME = "billCreateAccountName";
	public static final String BILL_TOTAL_PRICE = "billTotalPrice";

	public void save(TbBill transientInstance) {
		log.debug("saving TbBill instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbBill persistentInstance) {
		log.debug("deleting TbBill instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbBill findById(java.lang.Integer id) {
		log.debug("getting TbBill instance with id: " + id);
		try {
			TbBill instance = (TbBill) getSession().get(
					"org.uml.hotelsystem.dao.TbBill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbBill instance) {
		log.debug("finding TbBill instance by example");
		try {
			List results = getSession()
					.createCriteria("org.uml.hotelsystem.dao.TbBill")
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
		log.debug("finding TbBill instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbBill as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBillRoomType(Object billRoomType) {
		return findByProperty(BILL_ROOM_TYPE, billRoomType);
	}

	public List findByBillRoomName(Object billRoomName) {
		return findByProperty(BILL_ROOM_NAME, billRoomName);
	}

	public List findByBillRoomPrice(Object billRoomPrice) {
		return findByProperty(BILL_ROOM_PRICE, billRoomPrice);
	}

	public List findByBillCustomId(Object billCustomId) {
		return findByProperty(BILL_CUSTOM_ID, billCustomId);
	}

	public List findByBillCustomName(Object billCustomName) {
		return findByProperty(BILL_CUSTOM_NAME, billCustomName);
	}

	public List findByBillCustomCardId(Object billCustomCardId) {
		return findByProperty(BILL_CUSTOM_CARD_ID, billCustomCardId);
	}

	public List findByBillCustomTele(Object billCustomTele) {
		return findByProperty(BILL_CUSTOM_TELE, billCustomTele);
	}

	public List findByBillCreateAccountId(Object billCreateAccountId) {
		return findByProperty(BILL_CREATE_ACCOUNT_ID, billCreateAccountId);
	}

	public List findByBillCreateAccountName(Object billCreateAccountName) {
		return findByProperty(BILL_CREATE_ACCOUNT_NAME, billCreateAccountName);
	}

	public List findByBillTotalPrice(Object billTotalPrice) {
		return findByProperty(BILL_TOTAL_PRICE, billTotalPrice);
	}

	public List findAll() {
		log.debug("finding all TbBill instances");
		try {
			String queryString = "from TbBill";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbBill merge(TbBill detachedInstance) {
		log.debug("merging TbBill instance");
		try {
			TbBill result = (TbBill) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbBill instance) {
		log.debug("attaching dirty TbBill instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbBill instance) {
		log.debug("attaching clean TbBill instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}