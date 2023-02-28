package mk.iwec.bookshelf.service;

import java.util.List;

public interface GenericService<T> {

	public T findById(Integer id);

	public List<T> findAll();

	public int insert(T t);

	public int deleteById(Integer id);

	public int update(T t);

}
