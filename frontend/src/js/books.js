let url = "http://localhost:8080/books";

let init = {
    mode: 'cors',
    method: 'get',
    headers: {
        'Content-Type': 'application/json; charset=UTF-8',
    }
};

// Function to put the book covers on the bookshelf using Ajax
function loadAjaxBooks() {
    loadAjaxRequest(url, createBookCovers);
}

// Function to put the book covers on the bookshelf with fetch
function loadBooks() {
    fetch(url)
        .then(response => response.json())
        .then(json => createBookCovers(json))
        .catch(error => console.error('Error fetching books:', error));
        ;
}

// Function to get the book cover file names and put them in the tag
function createBookCovers(response) {
    let result = '';

    for(let i = 0; i < response.length; i++) {
        result += `<a href="#footer" class="swiper-slide" onclick="getBookDescription(${response[i].id})" id="${response[i].id}">
        <img src="image/${response[i].coverFileName}" alt="" onerror="this.style.display='none'">
        </a>`;
    }

    document.getElementById("book-covers").innerHTML = result;
}

// Function to get book information when clicking on the cover image 
function getBookDescription(bookId) {
    const bookUrl = `http://localhost:8080/books/book/${bookId}`;

    fetch(bookUrl)
        .then(response => response.json())
        .then(book => {
            let subtitle = book.subtitle ? book.subtitle : "";
            if (book.authors) {
                authors = book.authors.map(author => `${author.firstName} ${author.lastName}`).join(", ");
            }
            let publisher = book.publisher ? book.publisher.name : "";
            let language = book.language ? book.language.name : "";
            let result = `<h2 id="title">${book.title}</h2>
                <h3 id="subtitle">${subtitle}</h3>
                <h3>By</h3>
                <h3 id="authors">${authors}</h3>
                <h4 id="publisher">Published by: ${publisher}</h4>
                <p id="summary">${book.summary}</p>
                <p>Edition number: ${book.editionNumber} | Publication date: ${book.publicationDate} | Page number: ${book.pageNumber} | ISBN: ${book.isbn} | Language: ${language} </p>`;

            document.getElementById("book-description").innerHTML = result;
        })
        .catch(error => console.error(`Error fetching book with ID ${bookId}:`, error));
}

// Function to register a new book in the database
function addBook() {
    let book = {
        "title" : document.getElementById("title").value,
        "subtitle" : document.getElementById("subtitle").value,
        "editionNumber" : document.getElementById("edition-number").value,
        "pageNumber" : document.getElementById("page-number").value,
        "publicationDate" : document.getElementById("publication-date").value,
        "coverFileName" : document.getElementById("cover-file-name").value,
        "isbn" : document.getElementById("isbn").value,
        "summary" : document.getElementById("summary").value,
        "language" : {
            "name" : document.getElementById("language-name").value
        },
        "publisher" : {
            "name" : document.getElementById("publisher-name").value
        },
        "authors" : [
            {
                "firstName" : document.getElementById("author-first-name").value,
                "lastName" : document.getElementById("author-last-name").value
            }
        ]
    };

    init.method = 'post';
    init.body = JSON.stringify(book);

    fetch(url, init).then(() => {
        // close the form
        document.querySelector('.add-form-container').classList.remove('active');
        // update the swiper
        const swiper = document.querySelector('.books-slider').swiper;
        swiper.removeAllSlides();
        addBooksToSwiper();
        swiper.update();
        // update the book list
        loadAjaxBooks();
      })
      .catch(error => console.error('Error adding book:', error));

}

// Function to update an existing book in the database
function updateBook() {
    const bookUrl = `http://localhost:8080/books/book/`;
    let id = document.getElementById("update-id").value;

    let book = {
        "title" : document.getElementById("u-title").value,
        "subtitle" : document.getElementById("u-subtitle").value,
        "pageNumber" : document.getElementById("u-page-number").value,
        "publicationDate" : document.getElementById("u-publication-date").value,
        "coverFileName" : document.getElementById("u-cover-file-name").value,
        "isbn" : document.getElementById("u-isbn").value,
        "summary" : document.getElementById("u-summary").value,
        "language" : {
            "name" : document.getElementById("u-language-name").value
        },
        "publisher" : {
            "name" : document.getElementById("u-publisher-name").value
        },
        "authors" : [
            {
                "firstName" : document.getElementById("u-author-first-name").value,
                "lastName" : document.getElementById("u-author-last-name").value
            }
        ]
    };

    init.method = 'put';
    init.body = JSON.stringify(book);

    fetch(bookUrl + id, init).then(() => {
        // close the form
        document.querySelector('.update-form-container').classList.remove('active');
        // update the swiper
        const swiper = document.querySelector('.books-slider').swiper;
        swiper.removeAllSlides();
        addBooksToSwiper();
        swiper.update();
        // update the book list
        loadAjaxBooks();
      })
      .catch(error => console.error('Error updating book:', error));
  
}

// Function to delete an existing book from the database
function deleteBook() {
    const bookUrl = `http://localhost:8080/books/book/`;
    let id = document.getElementById("delete-id").value;
    init.method = 'delete';
    fetch(bookUrl + id, init).then(() => {
      // close the form
      document.querySelector('.delete-form-container').classList.remove('active');
      // remove the deleted book from the swiper
      const swiper = document.querySelector('.books-slider').swiper;
      swiper.removeSlide(swiper.activeIndex);
      // update the swiper
      swiper.removeAllSlides();
      addBooksToSwiper();
      swiper.update();
      // reload the book list
      loadAjaxBooks();
      })
      .catch(error => console.error('Error deleting book:', error));
}

function addBooksToSwiper() {
    const booksUrl = `http://localhost:8080/books`;
    fetch(booksUrl)
      .then(response => response.json())
      .then(books => {
        const swiper = document.querySelector('.books-slider').swiper;
        books.forEach(book => {
          const bookHtml = `
            <div class="swiper-slide">
              <h3>${book.title}</h3>
              <p>${book.summary}</p>
              <img src="${book.coverFileName}" alt="${book.title}" />
              <a href="#" onclick="deleteBook('${book.id}');">Delete</a>
              <a href="#" onclick="showUpdateForm('${book.id}');">Update</a>
            </div>
          `;
          swiper.appendSlide(bookHtml);
        });
      })
      .catch(error => console.error('Error loading books:', error));
  }
