package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.FileType;
import mk.iwec.bookshelf.repository.FileTypeRepository;
import mk.iwec.bookshelf.service.FileTypeService;

@Service
@Transactional
public class FileTypeServiceImpl implements FileTypeService {

	@Autowired
	private FileTypeRepository fileTypeRepository;

	@Override
	public FileType findById(Long id) {
		return fileTypeRepository.findById(id).get();
	}

	@Override
	public List<FileType> findAll() {
		return fileTypeRepository.findAll();
	}

	@Override
	public FileType insert(FileType fileType) {
		FileType fileTypeExists = fileTypeRepository.findFileTypeByFullName(fileType.getFullName());
		if (fileTypeExists != null) {
			throw new IllegalStateException("File type already exists in database.");
		}
		return fileTypeRepository.save(fileType);
	}

	@Override
	public void deleteById(Long id) {
		boolean fileTypeExists = fileTypeRepository.existsById(id);
		if (!fileTypeExists) {
			throw new IllegalStateException("File type with the given id does not exist in database.");
		}
	}

	@Override
	public FileType update(Long id, FileType fileType) {
		FileType fileTypeExists = fileTypeRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("File type with the given id does not exist in database."));

		fileTypeExists.setFullName(fileType.getFullName());
		fileTypeExists.setShortName(fileType.getShortName());
		fileTypeExists.setBooks(fileType.getBooks());

		return fileTypeExists;
	}

}
