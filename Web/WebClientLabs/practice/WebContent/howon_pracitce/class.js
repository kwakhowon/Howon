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
    sum(){
        return 'prototype : ' +(this.first+this.second);
    }
}

class PersonPlus extends Person{
    constructor(name, first, second, third){
        super(name, first, second);
        this.third = third;
    }
    sum(){
        return super.sum()+this.third;
    }
    avg(){
        return (this.first+this.second+this.third)/3;
    }
    
}

var kim = new PersonPlus('kim', 10, 20,30);

console.log(kim.sum());
console.log(kim.avg());
