package mk.iwec.bookshelf.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(nullable = false)
	private String title;

	private String subtitle;

	@Column(name = "edition_number", columnDefinition = "Integer default 1")
	private Integer editionNumber;

	@Column(name = "page_number", nullable = false)
	private Integer pageNumber;

	@Column(name = "publication_date", nullable = false)
	private Date publicationDate;

	@Column(length = 50)
	private String isbn;

	@Column(name = "cover_file_name")
	private String coverFileName;

	@Column(name = "book_file_name", nullable = false, unique = true)
	private String bookFileName;

	@OneToOne(cascade = CascadeType.ALL)
	private Language language;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Publisher publisher;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "r_books_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "r_books_translators", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "translator_id"))
	private Set<Translator> translators;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "r_books_genres", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genres;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "r_books_file_types", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "file_type_id"))
	private Set<FileType> fileTypes;

}
