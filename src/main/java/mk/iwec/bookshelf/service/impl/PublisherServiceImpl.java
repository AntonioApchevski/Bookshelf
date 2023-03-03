package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

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
		return publisherRepository.findById(id).get();
	}

	@Override
	public List<Publisher> findAll() {
		return publisherRepository.findAll();
	}

	@Override
	public void insert(Publisher publisher) {
		Optional<Publisher> publisherExists = publisherRepository.findPublisherByName(publisher.getName());
		if (publisherExists.isPresent()) {
			throw new IllegalStateException("Publisher already exists in database.");
		}
		publisherRepository.save(publisher);
	}

	@Override
	public void deleteById(Integer id) {
		boolean publisherExists = publisherRepository.existsById(id);
		if (!publisherExists) {
			throw new IllegalStateException("Publisher with the given id does not exist in database.");
		}
		publisherRepository.deleteById(id);
	}

	@Override
	public void update(Integer id, Publisher publisher) {
		Publisher publisherExists = publisherRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("Publisher with the given id does not exist in database."));

		publisherExists.setName(publisher.getName());
		publisherExists.setLocation(publisher.getLocation());
	}

}
