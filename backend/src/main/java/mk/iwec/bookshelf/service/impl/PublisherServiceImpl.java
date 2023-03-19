package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Publisher;
import mk.iwec.bookshelf.repository.PublisherRepository;
import mk.iwec.bookshelf.service.PublisherService;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public Publisher findById(Long id) {
		return publisherRepository.findById(id).get();
	}

	@Override
	public List<Publisher> findAll() {
		return publisherRepository.findAll();
	}

	@Override
	public Publisher insert(Publisher publisher) {
		Publisher publisherExists = publisherRepository.findPublisherByName(publisher.getName());
		if (publisherExists != null) {
			throw new IllegalStateException("Publisher already exists in database.");
		}
		return publisherRepository.save(publisher);
	}

	@Override
	public void deleteById(Long id) {
		boolean publisherExists = publisherRepository.existsById(id);
		if (!publisherExists) {
			throw new IllegalStateException("Publisher with the given id does not exist in database.");
		}
		publisherRepository.deleteById(id);
	}

	@Override
	public Publisher update(Long id, Publisher publisher) {
		Publisher publisherExists = publisherRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("Publisher with the given id does not exist in database."));

		publisherExists.setName(publisher.getName());

		return publisherExists;
	}

}
