// classes : JAVASCRIPT 표준 >> ECMA6부터 추가된 문법
// classes 문법은 javascript에 새로운 문법을 만드는 것이 아니라
// 객체지향 언어였고 prototype기반의 언어
// 이미 가지고 있는 기능을 활용해서 양념을 하는 느낌

//constructor : 객체를 만들고, 객체의 초기상태를 세팅

class Person{
    constructor(name, first, second){
        this.name = name;
        this.first = first;
        this.second = second
    }
}
var kim = new Person('kim', 10, 20);
console.log('kim', kim);
// kim.sum = function(){
//     return 'this : ' +(this.first+this.second);
// }
// var lee = new Person('lee', 10, 10);
// console.log("kim.sum()", kim.sum());
// console.log("lee.sum()", lee.sum());
