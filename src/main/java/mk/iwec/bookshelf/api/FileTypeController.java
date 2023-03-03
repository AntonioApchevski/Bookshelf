package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("fileTypes")
public class FileTypeController {

	@Autowired
	private FileTypeService fileTypeService;

	@GetMapping
	public List<FileType> findAll() {
		return fileTypeService.findAll();
	}

	@GetMapping("/fileType/{id}")
	public FileType getFileTypeById(@PathVariable("id") Integer id) {
		return fileTypeService.findById(id);
	}

	@PostMapping
	public void registerNewFileType(@RequestBody FileType fileType) {
		fileTypeService.insert(fileType);
	}

	@PutMapping("/fileType/{id}")
	public void updateFileType(@PathVariable("id") Integer id, @RequestBody FileType fileType) {
		fileTypeService.update(id, fileType);
	}

	@DeleteMapping("fileType/{id}")
	public void deleteFileType(@PathVariable("id") Integer id) {
		fileTypeService.deleteById(id);
	}
}
