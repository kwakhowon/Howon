var superObj = {superVal:'super'}
//var subObj = {subVal : 'sub'}
//subObj.__proto__ = superObj;
var subObj = Object.create(superObj); //superObj를 부모로하는 새로운 객체 생성
console.log('subObj.subVal =>', subObj.subVal);
console.log('subObj.subVal =>', subObj.superVal);
subObj.superVal = 'sub';
debugger;
console.log(subObj.superVal); //__proto__를 바꾸지 않는이상 sub로 바뀌지 않는다.
subObj.__proto__ = 'sub';
