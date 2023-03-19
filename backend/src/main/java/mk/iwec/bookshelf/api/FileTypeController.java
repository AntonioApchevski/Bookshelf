package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.FileType;
import mk.iwec.bookshelf.service.FileTypeService;

@RestController
@RequestMapping("file-types")
public class FileTypeController {

	@Autowired
	private FileTypeService fileTypeService;

	@GetMapping
	public List<FileType> findAll() {
		return fileTypeService.findAll();
	}

	@GetMapping("/file-type/{id}")
	public FileType getFileTypeById(@PathVariable("id") Long id) {
		return fileTypeService.findById(id);
	}

	@PostMapping
	public ResponseEntity<FileType> registerNewFileType(@RequestBody FileType fileType) {
		FileType newFileType = fileTypeService.insert(fileType);
		return new ResponseEntity<>(newFileType, HttpStatus.CREATED);
	}

	@PutMapping("/file-type/{id}")
	public ResponseEntity<FileType> updateFileType(@PathVariable("id") Long id, @RequestBody FileType fileType) {
		return new ResponseEntity<>(fileTypeService.update(id, fileType), HttpStatus.OK);
	}

	@DeleteMapping("file-type/{id}")
	public void deleteFileType(@PathVariable("id") Long id) {
		fileTypeService.deleteById(id);
	}
}
