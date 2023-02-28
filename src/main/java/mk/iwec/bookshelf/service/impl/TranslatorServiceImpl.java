package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.iwec.bookshelf.model.Translator;
import mk.iwec.bookshelf.repository.TranslatorRepository;
import mk.iwec.bookshelf.service.TranslatorService;

@Service
public class TranslatorServiceImpl implements TranslatorService {

	@Autowired
	private TranslatorRepository translatorRepository;

	@Override
	public Translator findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Translator> findAll() {
		return translatorRepository.findAll();
	}

	@Override
	public int insert(Translator t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Translator t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
