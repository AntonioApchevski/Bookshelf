package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.FileType;

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Long> {

	public FileType findFileTypeByFullName(String fullName);

}
