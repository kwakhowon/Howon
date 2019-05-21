console.log([1,2,3,4,5,6].concat(7,8,9));
console.log([1,2,3,4,5,6].map(x=> x*2));
console.log([1,2,3,4,5,6].filter(x=>x%2===0));
console.log([1,2,3,4,5,6].reduce((acc, cur)=>acc+cur));

const deliveryBoy = {
    //key + value
    name : "Jupiter" ,
    age : 35 , 
    occupation : {
        title : 'Boss',
        experience : 10
    },
    //field or property
    handleMessage : (message, handler) => handler(message),
    
    

    receive : function(){
        this.handleMessage("hello, " ,(message) => {
            console.log(message + this.name)
        })
    }
}

console.log(deliveryBoy["name"]);
console.log(deliveryBoy["age"]);
console.log(deliveryBoy["occupation"]);
console.log(deliveryBoy.receive());

if(true){
    let age = 25;
    console.log('age : ' +age);
}

//const age = 15;
// value of number , string of const can't be changed
// but, value of object, array, list can be changed
// but, the address of memory block where array or object reside can't be changed
const age = [15,20,25];
console.log('age : ' +age);
age.push(30);
console.log('age : ' +age);

function doSomething(){
    let age = 25;
}
doSomething();
console.log(age);

const obj = {
    key : "Jupeter",
    occupation : 'coder'
}
obj.key = 'Superman';
console.log(obj);

const add = (a,b) => a+b;


console.log(add(1,2));