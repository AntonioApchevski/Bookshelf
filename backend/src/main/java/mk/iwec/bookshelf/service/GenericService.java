package mk.iwec.bookshelf.service;

import java.util.List;

public interface GenericService<T> {

	public T findById(Long id);

	public List<T> findAll();

	public T insert(T t);

	public void deleteById(Long id);

	public T update(Long id, T t);

}
