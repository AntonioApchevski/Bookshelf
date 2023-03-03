package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

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
		return fileTypeRepository.findById(id).get();
	}

	@Override
	public List<FileType> findAll() {
		return fileTypeRepository.findAll();
	}

	@Override
	public void insert(FileType fileType) {
		Optional<FileType> fileTypeExists = fileTypeRepository.findFileTypeByFullName(fileType.getFullName());
		if (fileTypeExists.isPresent()) {
			throw new IllegalStateException("File type already exists in database.");
		}
		fileTypeRepository.save(fileType);
	}

	@Override
	public void deleteById(Integer id) {
		boolean fileTypeExists = fileTypeRepository.existsById(id);
		if (!fileTypeExists) {
			throw new IllegalStateException("File type with the given id does not exist in database.");
		}
	}

	@Override
	public void update(Integer id, FileType fileType) {
		FileType fileTypeExists = fileTypeRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("File type with the given id does not exist in database."));

		fileTypeExists.setFullName(fileType.getFullName());
		fileTypeExists.setShortName(fileType.getShortName());
		fileTypeExists.setBooks(fileType.getBooks());

	}

}
