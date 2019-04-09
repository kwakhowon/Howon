const body = document.querySelector("body");
const animalList = document.querySelector(".animalList");
const animalNameBox = document.querySelector("#animalNameBox");
const animalBox = document.querySelector("#animalBox");

const PIG_ID = "pig";
const BIRD_ID = "bird";
const SHEEP_ID = "sheep";
const CAT_ID = "cat";
const CONAN_ID = "conan";


const PIG = "돼지";
const BIRD = "새";
const SHEEP = "양";
const CAT = "고양이";
const CONAN = "코난";

const EMPTY = "empty";

function getNameAndSound(animalId) {
  const audio = document.querySelector("audio");
  if (audio !== null) {
    body.removeChild(audio);
  }
  showAnimalName(animalId);
  playAnimalSound(animalId);
}

function showAnimalName(animalId) {
  const name = findAnimalName(animalId);
  animalNameBox.innerText = name;
}

function playAnimalSound(animalId) {
  const audio = document.createElement("audio");
  const audioFile = "../audios/" + animalId + ".ogg";
  audio.setAttribute("src", audioFile);
  audio.innerText = "지원하지 않는 브라우저입니다.";
  audio.autoplay = true;
  body.appendChild(audio);
}

function findAnimalName(name) {
  let animalName = "";
  if (name === PIG_ID) {
    animalName = PIG;
  } else if (name === BIRD_ID) {
    animalName = BIRD;
  } else if (name === SHEEP_ID) {
    animalName = SHEEP;
  } else if (name === CAT_ID) {
    animalName = CAT;
  } else if (name === CONAN_ID) {
	animalName = CONAN;
  }
  return animalName;
}

function drag(event) {
  const draggedId = event.target.id;
  event.dataTransfer.setData("text", draggedId);
}

function allowDrop(event) {
  event.preventDefault();
}

function drop(event) {
  event.preventDefault();
  const droppedId = event.dataTransfer.getData("text");
  const animalPicture = document.querySelector(`#${droppedId}`);
  const emptyList = animalPicture.parentNode;
  const animalInBox = animalBox.querySelector(".animal");
  if (animalInBox !== null) {
    emptyList.appendChild(animalInBox);
  }
  animalBox.appendChild(animalPicture);
  getNameAndSound(droppedId);
}

function init() {
  const animals = animalList.querySelectorAll(".animal");
  animals.forEach(function (animal) {
    animal.addEventListener("dragstart", drag);
  });
  animalBox.addEventListener("dragover", allowDrop);
  animalBox.addEventListener("drop", drop);
}

init();