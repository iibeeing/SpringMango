package com.mango.jtt.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class MultiValueMapUtil<K, V> implements MultiValueMap<K, V> {

	private Map<K, V> map = new HashMap<K, V>();

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<java.util.Map.Entry<K, List<V>>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<V> get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<V> put(K key, List<V> value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends K, ? extends List<V>> m) {
		// TODO Auto-generated method stub

	}

	public List<V> remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<List<V>> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public V getFirst(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(K key, V value) {
		map.put(key, value);

	}

	public void set(K key, V value) {
		// TODO Auto-generated method stub

	}

	public void setAll(Map<K, V> values) {
		// TODO Auto-generated method stub

	}

	public Map<K, V> toSingleValueMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public MultiValueMapUtil(Map<K, V> map) {
		super();
		this.map = map;
	}

}
