package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.iwec.bookshelf.model.Publisher;
import mk.iwec.bookshelf.repository.PublisherRepository;
import mk.iwec.bookshelf.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public Publisher findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> findAll() {
		return publisherRepository.findAll();
	}

	@Override
	public int insert(Publisher t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Publisher t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
