# Bookshelf

The Bookshelf project is a web application that allows users to manage a collection of books in a PostgreSQL database. The project is built using Spring Boot and Hibernate on the back-end, and HTML, CSS and JavaScript on the front-end.

## Installation

To use the Bookshelf project, follow these steps:

1. Clone the repository to your local machine:
git clone https://AntonioApchevski@bitbucket.org/antonioapchevski/bookshelf.git

2. Set up the database by creating a PostgreSQL database:
    1. Install PostgreSQL if you haven't already done so.
    2. Open a terminal or command prompt and start the PostgreSQL command-line interface.
    3. Create a new database for the bookshelf project: 
    CREATE DATABASE bookshelf;
    4. Connect to the newly created database: 
    \c bookshelf
    5. Import the SQL file containing the tables and data:
     \i ./db/bookshelf.sql
    6. Configure the application (go to the application.properties file and set the db username and password accordingly.)
    7. Verify that the tables and data have been created by running a SELECT query on the tables:
     SELECT * FROM book;

3. Build and run the Spring Boot back-end application by navigating to the backend/ directory and running the following command:
mvn spring-boot:run

## Usage

Once you have the Bookshelf project up and running, you can use the following features on the website:

* View all books: Navigate to the home page to view a list of all books in the database.

* View book's description: Click on the cover image of any book on the bookshelf on the home page. 

* Add a book: Click the "Add Book" button on the home page to register a new book to the database.

* Update a book: Click the "Update Book" button on the home page to update a book's information.

* Delete a book: Click the "Delete Book" button on the home page to remove an existing book from the database.

## Postman Payload

// Payload 1
{
   "title" : "Атомски навики",
   "subtitle" : "Мали промени, големи резултати",
   "pageNumber" : 320,
   "editionNumber" : 1,
   "publicationDate" : "2020-01-01",
   "isbn" : "978-608-243-343-1",
   "coverFileName" : "Book-1.jpg",
   "bookFileName" : "Book-1",
   "summary" : "Дали тешко ги менувате своите навики? Ако е така, проблемот не сте вие. Проблемот е во вашиот систем. Лошите навики се повторуваат одново и одново, не затоа што вие не сакате да се промените, туку затоа што имате погрешен систем за промена. Оваа книга содржи проверен и докажан систем, кој може да ве издигне до нови височини. „Атомски навики“ ќе го преобликуваат начинот на кој размислувате за успехот и за напредокот и ќе ви ги дадат потребните алатки и стратегии за трансформација на вашите навики – сеедно дали сте тим што сака да освои првенство, компанија што се стреми да се издигне над конкуренцијата или едноставно поединец што сака да престане да пуши, да ја намали тежината, да го победи стресот или да постигне некоја друга цел. Навиките се оној ситен детаљ што може да донесе огромен пакет од позитивни промени кај секого од нас.",
   "language" : 
       {
           "name" : "Македонски"
       },
   "publisher" : 
       {
           "name" : "Антолог"
       },
    "authors" : [
        {
            "firstName" : "James",
            "lastName" : "Clear"
        }
    ],
    "genres" : [
        {
            "name" : "Self-help"
        }
    ]
}


// Payload 2
{
   "title" : "Creepy Presents Alex Toth",
   "subtitle" : "The Definitive Collections of the Artist's Work from Creepy and Eerie",
   "pageNumber" : 168,
   "editionNumber" : 1,
   "publicationDate" : "2015-07-15",
   "isbn" : "978-1616556921",
   "coverFileName" : "Book-2.jpg",
   "bookFileName" : "Book-2",
   "summary" : "A brilliant storyteller who wielded a dynamic, minimalist style, Alex Toth is considered a master in the fields of comic book storytelling, animation, and design. With Creepy Presents Alex Toth, all of his vibrant and thrilling stories from Creepy and Eerie are collected in a deluxe, magazine-sized hardcover for the first time ever! With an introduction by Darwyn Cooke (DC: The New Frontier, Richard Stark's Parker), this collection of timeless tales will thrill, educate, and excite fans of horror, comics, and stellar illustration work. Major collaborations with Archie Goodwin, Doug Moench, Carmine Infantino, and others are included!",
   "language" : 
       {
           "name" : "English"
       },
   "publisher" : 
       {
           "name" : "Dark Horse Books"
       },
    "authors" : [
        {
            "firstName" : "Alex",
            "lastName" : "Toth"
        },
        {
            "firstName" : "Various",
            "lastName" : "Authors"
        }
    ],
    "genres" : [
        {
            "name" : "Graphic Novel"
        },
        {
            "name" : "Horror"
        }
    ]
}

// Payload 3
{
   "title" : "The Alchemist",
   "pageNumber" : 175,
   "editionNumber" : 1,
   "publicationDate" : "1988-01-01",
   "isbn" : "978-3-16-148410-0",
   "coverFileName" : "Book-3.jpg",
   "bookFileName" : "Book-3",
   "summary" : "Combining magic, mysticism, wisdom, and wonder into an inspiring tale of self-discovery, The Alchemist has become a modern classic, selling millions of copies around the world and transforming the lives of countless readers across generations. Paulo Coelho's masterpiece tells the mystical story of Santiago, an Andalusian shepherd boy who yearns to travel in search of a worldly treasure. His quest will lead him to riches far different—and far more satisfying—than he ever imagined. Santiago's journey teaches us about the essential wisdom of listening to our hearts, recognizing opportunity and learning to read the omens strewn along life's path, and, most importantly, following our dreams.",
   "language" : 
       {
           "name" : "English"
       },
   "publisher" : 
       {
           "name" : "HarperOne"
       },
    "authors" : [
        {
            "firstName" : "Paulo",
            "lastName" : "Coelho"
        }
    ],
    "translators" : [
        {
            "firstName" : "Alann",
	    "middleName" : "R.",
            "lastName" : "Clarke"
        }
    ],
    "genres" : [
        {
            "name" : "Novel"
        },
        {
            "name" : "Drama"
        },
        {
            "name" : "Adventure"
        }
    ]	
}


// Payload 4
{
   "title" : "Thinking, Fast and Slow",
   "pageNumber" : 499,
   "editionNumber" : 1,
   "publicationDate" : "2013-04-02",
   "isbn" : "978-0374533557",
   "coverFileName" : "Book-4.jpg",
   "bookFileName" : "Book-4",
   "summary" : "Why is there more chance we'll believe something if it's in a bold type face? Why are judges more likely to deny parole before lunch? Why do we assume a good-looking person will be more competent? The answer lies in the two ways we make choices: fast, intuitive thinking, and slow, rational thinking. This book reveals how our minds are tripped up by error and prejudice (even when we think we are being logical), and gives you practical techniques for slower, smarter thinking. It will enable to you make better decisions at work, at home, and in everything you do.",
   "language" : 
       {
           "name" : "English"
       },
   "publisher" : 
       {
           "name" : "Penguin"
       },
    "authors" : [
        {
            "firstName" : "Daniel",
            "lastName" : "Kahneman"
        }
    ],
    "genres" : [
        {
            "name" : "Psychology"
        }
    ]
}   

## Contributing

If you would like to contribute to the Bookshelf project, feel free to fork the repository and submit a pull request with your changes.

- - -
© Created by Antonio Apchevski - 2023