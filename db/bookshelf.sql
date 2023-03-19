--
-- PostgreSQL database dump
--

-- Dumped from database version 12.13
-- Dumped by pg_dump version 12.13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: authors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authors (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    middle_name character varying(255)
);


ALTER TABLE public.authors OWNER TO postgres;

--
-- Name: authors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authors_id_seq OWNER TO postgres;

--
-- Name: authors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.authors_id_seq OWNED BY public.authors.id;


--
-- Name: authors_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authors_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authors_seq OWNER TO postgres;

--
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id bigint NOT NULL,
    book_file_name character varying(255),
    cover_file_name character varying(255) NOT NULL,
    edition_number integer,
    isbn character varying(50),
    page_number integer,
    publication_date date,
    subtitle character varying(255),
    summary character varying(1500),
    title character varying(255) NOT NULL,
    language_id bigint,
    publisher_id bigint
);


ALTER TABLE public.books OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- Name: books_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_seq OWNER TO postgres;

--
-- Name: file_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.file_types (
    id bigint NOT NULL,
    full_name character varying(255) NOT NULL,
    short_name character varying(50) NOT NULL
);


ALTER TABLE public.file_types OWNER TO postgres;

--
-- Name: file_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.file_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.file_types_id_seq OWNER TO postgres;

--
-- Name: file_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.file_types_id_seq OWNED BY public.file_types.id;


--
-- Name: file_types_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.file_types_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.file_types_seq OWNER TO postgres;

--
-- Name: genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genres (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.genres OWNER TO postgres;

--
-- Name: genres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genres_id_seq OWNER TO postgres;

--
-- Name: genres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genres_id_seq OWNED BY public.genres.id;


--
-- Name: genres_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genres_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genres_seq OWNER TO postgres;

--
-- Name: languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.languages (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.languages OWNER TO postgres;

--
-- Name: languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.languages_id_seq OWNER TO postgres;

--
-- Name: languages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.languages_id_seq OWNED BY public.languages.id;


--
-- Name: languages_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.languages_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.languages_seq OWNER TO postgres;

--
-- Name: locations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.locations (
    id integer NOT NULL,
    city_name character varying(255) NOT NULL,
    country_name character varying(255) NOT NULL
);


ALTER TABLE public.locations OWNER TO postgres;

--
-- Name: locations_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.locations_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locations_seq OWNER TO postgres;

--
-- Name: publishers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publishers (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.publishers OWNER TO postgres;

--
-- Name: publishers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publishers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publishers_id_seq OWNER TO postgres;

--
-- Name: publishers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.publishers_id_seq OWNED BY public.publishers.id;


--
-- Name: publishers_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publishers_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publishers_seq OWNER TO postgres;

--
-- Name: r_books_authors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.r_books_authors (
    book_id bigint NOT NULL,
    author_id bigint NOT NULL
);


ALTER TABLE public.r_books_authors OWNER TO postgres;

--
-- Name: r_books_file_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.r_books_file_types (
    book_id bigint NOT NULL,
    file_type_id bigint NOT NULL
);


ALTER TABLE public.r_books_file_types OWNER TO postgres;

--
-- Name: r_books_genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.r_books_genres (
    book_id bigint NOT NULL,
    genre_id bigint NOT NULL
);


ALTER TABLE public.r_books_genres OWNER TO postgres;

--
-- Name: r_books_translators; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.r_books_translators (
    book_id bigint NOT NULL,
    translator_id bigint NOT NULL
);


ALTER TABLE public.r_books_translators OWNER TO postgres;

--
-- Name: translators; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.translators (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    middle_name character varying(255)
);


ALTER TABLE public.translators OWNER TO postgres;

--
-- Name: translators_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.translators_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.translators_id_seq OWNER TO postgres;

--
-- Name: translators_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.translators_id_seq OWNED BY public.translators.id;


--
-- Name: translators_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.translators_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.translators_seq OWNER TO postgres;

--
-- Name: authors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authors ALTER COLUMN id SET DEFAULT nextval('public.authors_id_seq'::regclass);


--
-- Name: books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- Name: file_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.file_types ALTER COLUMN id SET DEFAULT nextval('public.file_types_id_seq'::regclass);


--
-- Name: genres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres ALTER COLUMN id SET DEFAULT nextval('public.genres_id_seq'::regclass);


--
-- Name: languages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages ALTER COLUMN id SET DEFAULT nextval('public.languages_id_seq'::regclass);


--
-- Name: publishers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publishers ALTER COLUMN id SET DEFAULT nextval('public.publishers_id_seq'::regclass);


--
-- Name: translators id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.translators ALTER COLUMN id SET DEFAULT nextval('public.translators_id_seq'::regclass);


--
-- Data for Name: authors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authors (id, first_name, last_name, middle_name) FROM stdin;
1	James	Clear	\N
2	Alex	Toth	\N
3	Various	Authors	\N
4	Paulo	Coelho	\N
5	Daniel	Kahneman	\N
\.


--
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.books (id, book_file_name, cover_file_name, edition_number, isbn, page_number, publication_date, subtitle, summary, title, language_id, publisher_id) FROM stdin;
1	Book-1	Book-1.jpg	1	978-608-243-343-1	320	2020-01-01	Мали промени, големи резултати	Дали тешко ги менувате своите навики? Ако е така, проблемот не сте вие. Проблемот е во вашиот систем. Лошите навики се повторуваат одново и одново, не затоа што вие не сакате да се промените, туку затоа што имате погрешен систем за промена. Оваа книга содржи проверен и докажан систем, кој може да ве издигне до нови височини. „Атомски навики“ ќе го преобликуваат начинот на кој размислувате за успехот и за напредокот и ќе ви ги дадат потребните алатки и стратегии за трансформација на вашите навики – сеедно дали сте тим што сака да освои првенство, компанија што се стреми да се издигне над конкуренцијата или едноставно поединец што сака да престане да пуши, да ја намали тежината, да го победи стресот или да постигне некоја друга цел. Навиките се оној ситен детаљ што може да донесе огромен пакет од позитивни промени кај секого од нас.	Атомски навики	1	1
2	Book-2	Book-2.jpg	1	978-1616556921	168	2015-07-15	The Definitive Collections of the Artist's Work from Creepy and Eerie	A brilliant storyteller who wielded a dynamic, minimalist style, Alex Toth is considered a master in the fields of comic book storytelling, animation, and design. With Creepy Presents Alex Toth, all of his vibrant and thrilling stories from Creepy and Eerie are collected in a deluxe, magazine-sized hardcover for the first time ever! With an introduction by Darwyn Cooke (DC: The New Frontier, Richard Stark's Parker), this collection of timeless tales will thrill, educate, and excite fans of horror, comics, and stellar illustration work. Major collaborations with Archie Goodwin, Doug Moench, Carmine Infantino, and others are included!	Creepy Presents Alex Toth	2	2
3	Book-3	Book-3.jpg	1	978-3-16-148410-0	175	1988-01-01	\N	Combining magic, mysticism, wisdom, and wonder into an inspiring tale of self-discovery, The Alchemist has become a modern classic, selling millions of copies around the world and transforming the lives of countless readers across generations. Paulo Coelho's masterpiece tells the mystical story of Santiago, an Andalusian shepherd boy who yearns to travel in search of a worldly treasure. His quest will lead him to riches far different—and far more satisfying—than he ever imagined. Santiago's journey teaches us about the essential wisdom of listening to our hearts, recognizing opportunity and learning to read the omens strewn along life's path, and, most importantly, following our dreams.	The Alchemist	2	3
4	Book-4	Book-4.jpg	1	978-0374533557	499	2013-04-02	\N	Why is there more chance we'll believe something if it's in a bold type face? Why are judges more likely to deny parole before lunch? Why do we assume a good-looking person will be more competent? The answer lies in the two ways we make choices: fast, intuitive thinking, and slow, rational thinking. This book reveals how our minds are tripped up by error and prejudice (even when we think we are being logical), and gives you practical techniques for slower, smarter thinking. It will enable to you make better decisions at work, at home, and in everything you do.	Thinking, Fast and Slow	2	4
\.


--
-- Data for Name: file_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.file_types (id, full_name, short_name) FROM stdin;
\.


--
-- Data for Name: genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genres (id, name) FROM stdin;
1	Self-help
2	Horror
3	Graphic Novel
4	Drama
5	Adventure
6	Novel
7	Psychology
\.


--
-- Data for Name: languages; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.languages (id, name) FROM stdin;
1	Македонски
2	English
\.


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.locations (id, city_name, country_name) FROM stdin;
\.


--
-- Data for Name: publishers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.publishers (id, name) FROM stdin;
1	Антолог
2	Dark Horse Books
3	HarperOne
4	Penguin
\.


--
-- Data for Name: r_books_authors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.r_books_authors (book_id, author_id) FROM stdin;
1	1
2	2
2	3
3	4
4	5
\.


--
-- Data for Name: r_books_file_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.r_books_file_types (book_id, file_type_id) FROM stdin;
\.


--
-- Data for Name: r_books_genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.r_books_genres (book_id, genre_id) FROM stdin;
1	1
2	2
2	3
3	4
3	5
3	6
4	7
\.


--
-- Data for Name: r_books_translators; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.r_books_translators (book_id, translator_id) FROM stdin;
3	1
\.


--
-- Data for Name: translators; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.translators (id, first_name, last_name, middle_name) FROM stdin;
1	Alann	Clarke	R.
\.


--
-- Name: authors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authors_id_seq', 5, true);


--
-- Name: authors_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authors_seq', 51, true);


--
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq', 4, true);


--
-- Name: books_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_seq', 1, true);


--
-- Name: file_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.file_types_id_seq', 1, false);


--
-- Name: file_types_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.file_types_seq', 1, false);


--
-- Name: genres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genres_id_seq', 7, true);


--
-- Name: genres_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genres_seq', 51, true);


--
-- Name: languages_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.languages_id_seq', 2, true);


--
-- Name: languages_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.languages_seq', 101, true);


--
-- Name: locations_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.locations_seq', 1, false);


--
-- Name: publishers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.publishers_id_seq', 4, true);


--
-- Name: publishers_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.publishers_seq', 51, true);


--
-- Name: translators_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.translators_id_seq', 1, true);


--
-- Name: translators_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.translators_seq', 1, true);


--
-- Name: authors authors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (id);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- Name: file_types file_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.file_types
    ADD CONSTRAINT file_types_pkey PRIMARY KEY (id);


--
-- Name: genres genres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (id);


--
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);


--
-- Name: locations locations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (id);


--
-- Name: publishers publishers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publishers
    ADD CONSTRAINT publishers_pkey PRIMARY KEY (id);


--
-- Name: r_books_authors r_books_authors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_authors
    ADD CONSTRAINT r_books_authors_pkey PRIMARY KEY (book_id, author_id);


--
-- Name: r_books_file_types r_books_file_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_file_types
    ADD CONSTRAINT r_books_file_types_pkey PRIMARY KEY (book_id, file_type_id);


--
-- Name: r_books_genres r_books_genres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_genres
    ADD CONSTRAINT r_books_genres_pkey PRIMARY KEY (book_id, genre_id);


--
-- Name: r_books_translators r_books_translators_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_translators
    ADD CONSTRAINT r_books_translators_pkey PRIMARY KEY (book_id, translator_id);


--
-- Name: translators translators_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.translators
    ADD CONSTRAINT translators_pkey PRIMARY KEY (id);


--
-- Name: file_types uk_5onjeacpkr9cio4gbpybvff7t; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.file_types
    ADD CONSTRAINT uk_5onjeacpkr9cio4gbpybvff7t UNIQUE (short_name);


--
-- Name: books uk_9fsgnsmokyo15l5vkcsckjp43; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT uk_9fsgnsmokyo15l5vkcsckjp43 UNIQUE (book_file_name);


--
-- Name: publishers uk_an1ucpx8sw2qm194mlok8e5us; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publishers
    ADD CONSTRAINT uk_an1ucpx8sw2qm194mlok8e5us UNIQUE (name);


--
-- Name: file_types uk_efrji9lgvkoer6elauabg195r; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.file_types
    ADD CONSTRAINT uk_efrji9lgvkoer6elauabg195r UNIQUE (full_name);


--
-- Name: languages uk_f6axmaokhmrbmm746866v0uyu; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT uk_f6axmaokhmrbmm746866v0uyu UNIQUE (name);


--
-- Name: locations uk_ic7p69yluxfa30m2hisuv6w4m; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT uk_ic7p69yluxfa30m2hisuv6w4m UNIQUE (country_name);


--
-- Name: books uk_oo5tadtvdr85k7237438dd3g7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT uk_oo5tadtvdr85k7237438dd3g7 UNIQUE (cover_file_name);


--
-- Name: genres uk_pe1a9woik1k97l87cieguyhh4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT uk_pe1a9woik1k97l87cieguyhh4 UNIQUE (name);


--
-- Name: r_books_translators fk30m8im0w131h3a80mu2om9mun; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_translators
    ADD CONSTRAINT fk30m8im0w131h3a80mu2om9mun FOREIGN KEY (book_id) REFERENCES public.books(id);


--
-- Name: r_books_file_types fk7mynh0b00vfykx7asx8f0s1se; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_file_types
    ADD CONSTRAINT fk7mynh0b00vfykx7asx8f0s1se FOREIGN KEY (file_type_id) REFERENCES public.file_types(id);


--
-- Name: r_books_authors fk8sym5bljhum4uego3rfde7df1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_authors
    ADD CONSTRAINT fk8sym5bljhum4uego3rfde7df1 FOREIGN KEY (author_id) REFERENCES public.authors(id);


--
-- Name: r_books_authors fk9145e0x3pgxrxaft794pj7ea; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_authors
    ADD CONSTRAINT fk9145e0x3pgxrxaft794pj7ea FOREIGN KEY (book_id) REFERENCES public.books(id);


--
-- Name: r_books_genres fkav0smmg73loe8oyva7q4vv07u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_genres
    ADD CONSTRAINT fkav0smmg73loe8oyva7q4vv07u FOREIGN KEY (book_id) REFERENCES public.books(id);


--
-- Name: books fkayy5edfrqnegqj3882nce6qo8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkayy5edfrqnegqj3882nce6qo8 FOREIGN KEY (publisher_id) REFERENCES public.publishers(id);


--
-- Name: books fkgcee4gd2csaf93meptle3s6uu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkgcee4gd2csaf93meptle3s6uu FOREIGN KEY (language_id) REFERENCES public.languages(id);


--
-- Name: r_books_translators fkhkvgl0vw9agio3yt4b55bqpyh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_translators
    ADD CONSTRAINT fkhkvgl0vw9agio3yt4b55bqpyh FOREIGN KEY (translator_id) REFERENCES public.translators(id);


--
-- Name: r_books_file_types fknv9m57psdgtpr0yuwdp2oc2ba; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_file_types
    ADD CONSTRAINT fknv9m57psdgtpr0yuwdp2oc2ba FOREIGN KEY (book_id) REFERENCES public.books(id);


--
-- Name: r_books_genres fktovi2c8u8vs40pooerj7ibgqd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.r_books_genres
    ADD CONSTRAINT fktovi2c8u8vs40pooerj7ibgqd FOREIGN KEY (genre_id) REFERENCES public.genres(id);


--
-- PostgreSQL database dump complete
--

