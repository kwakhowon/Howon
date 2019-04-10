// prototype : 원형 자바스크립트를 지탱하는 기반이라 할 수 있다.
// 공통된 부분들을 prototype로 선언해서 메모리도 절약하고 코드의 재사용성 증가


function Person(name, first, second){
    this.name = name,
    this.first = first,
    this.second = second;
    
}
Person.prototype.sum = function(){
    return 'prototype : '+(this.first+this.second);
}

var kim = new Person('kim', 10, 20);
kim.sum = function(){
    return 'this : ' +(this.first+this.second);
}
var lee = new Person('lee', 10, 10);
console.log("kim.sum()", kim.sum());
console.log("lee.sum()", lee.sum());
