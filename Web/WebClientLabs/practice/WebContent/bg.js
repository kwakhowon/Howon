const body = document.querySelector("body");
const IMG_MUMBER = 3;

function handleImgLoad(){
    console.log("finished loading");
}

function paintImage(imgNumber){
    const image= new Image();
    image.src = `image/${imgNumber+1}.jpg`;
    image.classList.add("bgImage");
    body.prepend(image);
    
}

function genRandom(){
    const number = Math.floor(Math.random()*IMG_MUMBER);
    return number;
}

function init(){
    const randomNumber = genRandom();
    paintImage(randomNumber);
}

init();