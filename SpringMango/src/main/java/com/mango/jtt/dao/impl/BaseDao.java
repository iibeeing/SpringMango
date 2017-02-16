package com.mango.jtt.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*import com.alibaba.dubbo.common.utils.CollectionUtils;  
 import com.github.pagehelper.PageHelper;  
 import com.github.pagehelper.PageInfo;  */

import com.mango.jtt.util.GenericsUtils;

@Repository("baseDao")
public class BaseDao<T, PK extends Serializable> extends SqlSessionDaoSupport
		implements Serializable {

	private static final long serialVersionUID = 7623507504198633838L;

	private final String POSTFIX = "Dao";

	private final String _INSERT = ".insert";

	private final String _INSERTSELECTIVE = ".insertSelective";

	public final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";

	private final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";

	private final String _UPDATEBYPRIMARYKEYSELECTIVE = ".updateByPrimaryKeySelective";

	private final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/*
	 * GenericsUtils为工具类，请见下方代码
	 * 泛型获得XXXEntity，将其转换为XXXEntityDao，具体操作替换掉Entity变成XXXDao
	 * ，对应Mapper.xml中的namespace命名
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getNampSpace() {
		Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this
				.getClass());
		String simpleName = clazz.getSimpleName() + POSTFIX;
		return simpleName;
	}

	public int insert(T entity) {
		return getSqlSession()
				.insert((this.getNampSpace().contains("Entity") ? this
						.getNampSpace().replace("Entity", "")
						: this.getNampSpace())
						+ _INSERT, entity);
	}

	public int insertSelective(T record) {
		return getSqlSession().insert(
				(this.getNampSpace().contains("Entity") ? this.getNampSpace()
						.replace("Entity", "") : this.getNampSpace())
						+ _INSERTSELECTIVE, record);
	}

	public T selectByPrimaryKey(PK id) {
		return getSqlSession().selectOne(
				(this.getNampSpace().contains("Entity") ? this.getNampSpace()
						.replace("Entity", "") : this.getNampSpace())
						+ _SELECTBYPRIMARYKEY, id);
	}

	public int updateByPrimaryKey(T record) {
		return getSqlSession().update(
				(this.getNampSpace().contains("Entity") ? this.getNampSpace()
						.replace("Entity", "") : this.getNampSpace())
						+ _UPDATEBYPRIMARYKEY, record);
	}

	public int updateByPrimaryKeySelective(T record) {
		return getSqlSession().update(
				(this.getNampSpace().contains("Entity") ? this.getNampSpace()
						.replace("Entity", "") : this.getNampSpace())
						+ _UPDATEBYPRIMARYKEYSELECTIVE, record);
	}

	public int deleteByPrimaryKey(PK id) {
		return getSqlSession().delete(
				(this.getNampSpace().contains("Entity") ? this.getNampSpace()
						.replace("Entity", "") : this.getNampSpace())
						+ _DELETEBYPRIMARYKEY, id);
	}

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public PageInfo<T>
	 * pageFind(String statementKey, PageForm pageForm, Object parameter,
	 * Boolean isSimplePage) throws IllegalAccessException,
	 * InvocationTargetException, NoSuchMethodException { Map params = new
	 * HashMap(); if (parameter != null) { if (parameter instanceof Map) {
	 * params.putAll((Map) parameter); } else { Map parameterObject =
	 * PropertyUtils.describe(parameter); params.putAll(parameterObject); } }
	 * PageHelper.startPage(pageForm.getPage(), pageForm.getRows()); List<T>
	 * list = getSqlSession().selectList(statementKey, params); PageInfo<T>
	 * pageInfo = new PageInfo(list);
	 * 
	 * return pageInfo; }
	 * 
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public List<T> findTop(int
	 * top, String statementKey, Object parameter) throws
	 * IllegalAccessException, InvocationTargetException, NoSuchMethodException
	 * { Map params = new HashMap(); if (parameter != null) { if (parameter
	 * instanceof Map) { params.putAll((Map) parameter); } else { Map
	 * parameterObject = PropertyUtils.describe(parameter);
	 * params.putAll(parameterObject); } } List<T> list =
	 * getSqlSession().selectList(statementKey, params, new RowBounds(0, top));
	 * return list; }
	 * 
	 * public T findTopOne(String statementKey, Object parameter) throws
	 * IllegalAccessException, InvocationTargetException, NoSuchMethodException
	 * { List<T> list = findTop(1, statementKey, parameter); return
	 * CollectionUtils.isEmpty(list) ? null : list.get(0); }
	 * 
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public <M> PageInfo<M>
	 * pageFindModel(String statementKey, PageForm pageForm, Object parameter)
	 * throws IllegalAccessException, InvocationTargetException,
	 * NoSuchMethodException { Map params = new HashMap(); if (parameter !=
	 * null) { if (parameter instanceof Map) { params.putAll((Map) parameter); }
	 * else { Map parameterObject = PropertyUtils.describe(parameter);
	 * params.putAll(parameterObject); } }
	 * PageHelper.startPage(pageForm.getPage(), pageForm.getRows()); List<M>
	 * list = getSqlSession().selectList(statementKey, params); PageInfo<M>
	 * pageInfo = new PageInfo(list);
	 * 
	 * return pageInfo; }
	 */
}
