* Hibernate Properties:
  * hibernate.dialect
  * hibernate.connection.driver_class
  * hibernate.connection.url
  * hibernate.connection.username
  * hibernate.connection.password
  * hibernate.connection.pool_size
  * hibernate.connection.autocommit

* Session Interface Methods:
  * Transaction beginTransaction()
  * void cancelQuery()
  * void clear()
  * Connection close()
  * Criteria createCriteria(Class persistentClass)
  * Criteria createCriteria(String entityName)
  * Serializable getIdentifier(Object object)
  * Query createFilter(Object collection, String queryString)
  * Query createQuery(String queryString)
  * SQLQuery createSQLQuery(String queryString)
  * void delete(Object object)
  * void delete(String entityName, Object object)
  * Session get(String entityName, Serializable id)
  * SessionFactory getSessionFactory()
  * void refresh(Object object)
  * Transaction getTransaction()
  * boolean isConnected()
  * boolean isDirty()
  * boolean isOpen()
  * Serializable save(Object object)
  * void saveOrUpdate(Object object)
  * void update(Object object)
  * void update(String entityName, Object object)

* Pagination using Query
  * Query setFirstResult(int startPosition)
  * Query setMaxResults(int maxResult)

* Criteria
  * add - Restrictions.gt, ln, like, ilike, between, isNull, and, or, isEmpty
  * addOrder - Order.desc, asc
  * setProjection - Projections.rowCount, avg, sum, min, max, countDistinct
  * setFirstResult
  * setMaxResults

First-level cache:
	The first-level cache is the Session cache and is a mandatory cache through which all requests must pass. The Session object keeps an object under its own power before committing it to the database. If you issue multiple updates to an object, Hibernate tries to delay doing the update as long as possible to reduce the number of update SQL statements issued.

Second-level cache:
  Second level cache is an optional cache and first-level cache will always be consulted before any attempt is made to locate an object in the second-level cache. The second-level cache can be configured on a per-class and per-collection basis and mainly responsible for caching objects across sessions.
	Concurrency strategies-Transactional, Read-write, Nonstrict-read-write, Read-only
	in employee.hbm.xml file <cache usage="read-write"/>
	in hibernate config xml <property name="hibernate.cache.provider_class"> org.hibernate.cache.EhCacheProvider </property>
	in clsspath ehcache.xml 
		<diskStore path="java.io.tmpdir"/>
		<defaultCache maxElementsInMemory="1000" eternal="false" timeToIdleSeconds="120" timeToLiveSeconds="120" overflowToDisk="true" />
		<cache name="Employee" maxElementsInMemory="500" eternal="true" timeToIdleSeconds="0" timeToLiveSeconds="0" overflowToDisk="false" />

Query-level cache:
  Hibernate also implements a cache for query resultsets that integrates closely with the second-level cache.
	in hibernate config xml hibernate.cache.use_query_cache="true"
	query.setCacheable(true);

* Hibernate Interceptors
  * EmptyInterceptor - extend pass the object while creating session - Session session = factory.openSession( new MyInterceptor() );
  * findDirty()
  * instantiate()
  * isUnsaved()
  * onDelete()
  * onFlushDirty()
  * onLoad()
  * onSave()
  * postFlush()
  * preFlush()


many-to-one: 
  <many-to-one name="address" column="address"  class="Address" not-null="true"/>
one-to-one: 
  <many-to-one name="address" column="address" unique="true" class="Address" not-null="true"/>
one-to-many:
	<set name="certificates" cascade="all">
		 <key column="employee_id"/>
		 <one-to-many class="Certificate"/>
	</set>
many-to-many:
      <set name="certificates" cascade="save-update" table="EMP_CERT">
         <key column="employee_id"/>
         <many-to-many column="certificate_id" class="Certificate"/>
      </set>

