// === ADD FORM ===
let addForm = document.querySelector('.add-form-container');
let addFormElement = document.querySelector('#add-form');

document.querySelector('#add-btn').onclick = () =>{
  addForm.classList.toggle('active');
}

document.querySelector('#close-add-btn').onclick = () =>{
  addForm.classList.remove('active');
};

addFormElement.addEventListener('submit', (event) => {
  event.preventDefault();
  addBook();
});

// === UPDATE FORM === 
let updateForm = document.querySelector('.update-form-container');
let updateFormElement = document.querySelector('#update-form');

document.querySelector('#update-btn').onclick = () =>{
  updateForm.classList.toggle('active');
}

document.querySelector('#close-update-btn').onclick = () =>{
  updateForm.classList.remove('active');
};

updateFormElement.addEventListener('submit', (event) => {
  event.preventDefault();
  updateBook();
});

// === DELETE FORM ===
let deleteForm = document.querySelector('.delete-form-container');
let deleteFormElement = document.querySelector('#delete-form');

document.querySelector('#delete-btn').onclick = () =>{
  deleteForm.classList.toggle('active');
}

document.querySelector('#close-delete-btn').onclick = () =>{
  deleteForm.classList.remove('active');
};

deleteFormElement.addEventListener('submit', (event) => {
  event.preventDefault();
  deleteBook();
});

// === BOOKS SWIPER ===
var swiper = new Swiper(".books-slider", {
    loop:true,
    spaceBetween: 1,
    centeredSlides: false,
    autoplay: {
      delay: 8000,
      disableOnInteraction: false,
    },
    breakpoints: {
      0: {
        slidesPerView: 1,
      },
      768: {
        slidesPerView: 2,
      },
      1024: {
        slidesPerView: 4,
      },
    },
  });