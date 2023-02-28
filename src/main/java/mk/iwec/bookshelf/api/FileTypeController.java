package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
