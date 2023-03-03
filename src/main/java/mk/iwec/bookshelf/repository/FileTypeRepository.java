package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.FileType;

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Integer> {

	public Optional<FileType> findFileTypeByFullName(String fullName);

}
