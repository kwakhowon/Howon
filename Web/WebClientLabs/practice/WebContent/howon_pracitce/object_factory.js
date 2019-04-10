function Person(name, first, second, third){
    this.name = name,
    this.first = first,
    this.second = second,
    this.third = third,
    this.sum = function(){
        return this.first+this.second+this.third;
    }
}
var kim = new Person('kim', 10, 20, 30);
var lee = new Person('lee', 10, 10, 10);


console.log("kim.sum()", kim.sum());
console.log("lee.sum()", lee.sum());
// prototype : 원형 자바스크립트를 지탱하는 기반이라 할 수 있다.