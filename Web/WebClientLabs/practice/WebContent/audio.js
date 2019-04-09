var audio = document.getElementById("audio");
var play = document.getElementById("play");
var pause = document.getElementById("pause");
var mute = document.getElementById("mute");

play.addEventListener("click", playAudio);
pause.addEventListener("click", pauseAudio);
mute.addEventListener("click", muteAudio);

function playAudio(event){
    audio.play();
}

function pauseAudio(event){
    audio.pause();
}
function muteAudio(event){
    audio.muted = !audio.muted;
}