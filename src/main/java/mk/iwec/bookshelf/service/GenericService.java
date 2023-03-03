package mk.iwec.bookshelf.service;

import java.util.List;

public interface GenericService<T> {

	public T findById(Integer id);

	public List<T> findAll();

	public void insert(T t);

	public void deleteById(Integer id);

	public void update(Integer id, T t);

}
