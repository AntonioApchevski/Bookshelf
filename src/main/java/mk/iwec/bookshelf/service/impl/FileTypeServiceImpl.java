package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.iwec.bookshelf.model.FileType;
import mk.iwec.bookshelf.repository.FileTypeRepository;
import mk.iwec.bookshelf.service.FileTypeService;

@Service
public class FileTypeServiceImpl implements FileTypeService {

	@Autowired
	private FileTypeRepository fileTypeRepository;

	@Override
	public FileType findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileType> findAll() {
		return fileTypeRepository.findAll();
	}

	@Override
	public int insert(FileType t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FileType t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
