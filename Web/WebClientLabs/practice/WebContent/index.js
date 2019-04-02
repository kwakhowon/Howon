console.log('Im Working. Im JS. Im Beautiful. Imworth it');
const mon = "Mon";
const tue = "Tue";
const wed = "Wed";
const thu = "Thu";
const fri = "Fri";

const dayOfWeek = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" , true , 26];
console.log(dayOfWeek[2]);

const userInfo = ["howon","26", true, "seoul"];

console.log(userInfo[0]);

const howon = {
		name : "howon",
		age : 26,
		gender : "male",
		isHandsome:false,
		favMovies:["Lotr", "oldboy", "mine"],
		favFood : [ {name : "kimchi", fatty:false}, 
		{name : "cheese burger", fatty : true }]
}

function sayHello(name, age){
	return `Hello", ${name} you are ${age} years old`;
}

console.log(howon.favFood[0].fatty, howon.favMovies[0]);
sayHello("howon",15);

const greetHowon = sayHello("howon", 15)
console.log(greetHowon)
const calculator = {
	plus : function(a,b){
		return a+b;
	}
}
const plus = calculator.plus(5,5)
console.log(plus)