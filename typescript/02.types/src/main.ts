

// 타입 지정하기 

// Boolean
let boolean : boolean
let falseBoolean : boolean = false;


// Number
let numbar : number
let integer : number = 6;
let float : number = 1.2345;

// String
let string : string
let firstName : string = 'JJo';

// Array
// 한가지 타입만 가지는 배열 
let names1 : string[] = ['jjo', 'kim'];
let names2 : Array<string> = ['Jjo', 'Kim'];

// 여러 타입을 가지는 배열(유니언 타입 사용)
let array1 : (string | number)[] = ['JJo', 1, 2];
let array2 : Array<string | number> = ['JJo', 1, 2];

// 여러 타입을 지정할 수 없을 경우 (any 타입 사용)
let someArray : any[] = ['JJo', 1, [], {}, false];

// Interface, Type 

// 읽기 전용
let stringArray : readonly string[] = ['A', 'B'];
let numberArray : ReadonlyArray<number> = [1, 2, 3];

// stringArray.push('C'); // Error
// numberArray[0] = 3; // Error

// Tuple
// Tuple 타입은 해당 자리에 정해진 타입과 고정된 길이를 지켜야 함 
let tuple1 : [string, number];
tuple1 = ['a', 1];
// tuble1 = [1, 'a']; // Error
// tuple1 = ['a', 1, '1']; // Error

// Tuple 타입은 Array 형태로 선언할 수 있음
let users : [number, string][];
users = [[1, 'JJo'], [2, 'Kim']];

let tuple2 : [string, number]
tuple2 = ['a', 1];
// 다음과 같이 push를 통해 값을 추가할 수 있음
tuple2.push(2);
// 지정된 타입만 추가할 수 있음
// tuple2.push(false); // Error


// any
let any : any = 'abc';
any = 1;
any = [];

// unknown : 이 타입이 들어가있는 변수는 다른 변수에 재할당이 불가능
let unknown : unknown = 123;
// let string1 : string : unknown; // Error
let atring2 : boolean = unknown as boolean; // 자바의 강제형변환과 같은 방식으로 사용 가능

// Object
let obj : object = {};
let arr : object = [];
//let nul : object = null;    // null 형식은 object로 할당 x
let date : object = new Date();

const obj1 : object = {
    id : 1,
    title : 'title1'
}

const obj2 : { id : number, title : string } = {
    id : 2,
    title : 'title2'
    // , description : 'description' // Error
}

// Union  or 형식으로 둘 중 하나의 타입을 지정할 수 있음
let union : (string | number);
union = 'hi';
union = 1;
// union = false; // Error

// function
let fun1 : (arg1 : number, arg2 : number) => number;
fun1 = function(x, y) {
    return x * y;
}

let fun2 : () => void;          // 반환값이 없는 함수
fun2 = function(){
    console.log('hi');
}

// null, undefined
// strictNullChecks 옵션을 사용하면 null, undefined를 다른 타입에 할당할 수 없음
// strictNullChecks 옵션을 사용하지 않으면 null, undefined를 다른 타입에 할당할 수 있음
// let number1 : number = undefined;       
// let string9 : string = null;
// let object : {a : 10, b : false} = undefined; 
// let undefined1 : undefined = null;
// let null1 : null = undefined;
// let void1 : void = null;
let void2 : void = undefined;               // void 타입에는 undefined만 할당 가능 (null은 할당 불가능)

// void
// 함수에서 리턴을 하지 않을 때 사용. 
// 실제로 아무것도 리턴하지 않을 때에는 void에서 undefined를 리턴함. 그렇기 때문에 undefined를 할당할 수 있음
function greeting() : void {
    console.log('hi');
}

const hi : void = greeting();
console.log('hi');

// never
// 함수에서 절대로 리턴하지 않을 때 사용 (예외를 던지거나 무한루프 등)
// 빈 배열을 리턴하는 함수는 never 타입으로 지정할 수 있음
// never 타입은 모든 타입의 서브타입이기 때문에 모든 타입에 할당할 수 있음
// 하지만 never 타입에는 어떤 타입도 할당할 수 없음

function throwError() : never {
    throw new Error('error');
}

function keepProcessing() : never {
    while(true) {
        console.log('processing');
    };
};

const never : [] = [];
// never.push(1);
