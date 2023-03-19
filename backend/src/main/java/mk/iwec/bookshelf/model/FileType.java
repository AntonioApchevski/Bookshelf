package mk.iwec.bookshelf.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "file_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name", nullable = false, unique = true)
	private String fullName;

	@Column(name = "short_name", length = 50, nullable = false, unique = true)
	private String shortName;

	@ManyToMany(mappedBy = "fileTypes", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Book> books;
}
