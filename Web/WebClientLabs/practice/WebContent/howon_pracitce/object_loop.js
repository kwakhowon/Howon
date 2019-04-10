var memberArray = ['egoing' , 'graphittie', 'leezhce'];

console.group('array loop');
var i = 0;
while(i < memberArray.length){
    console.log(i , memberArray[i]);
    i += 1;
}
console.groupEnd('array loop');

for(var name in memberObject){
    console.log(name);
}
var memberObject = {
    manager : 'egoing',
    developer : 'graphittie',
    designer : 'leezche'

}