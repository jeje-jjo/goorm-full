const { L, C } = window._;

/* `// const add = (acc, cur) => acc + cur;` is defining a function called `add` that takes two
arguments `acc` and `cur` and returns their sum. This function is later used in the `f2` function to
calculate the sum of the squared odd numbers in a given list. */
// const add = (acc, cur) => acc + cur;

// 함수형 프로그래밍


// 1. 홀수 순회하기
// 1-1 기존 방식 (for 문 사용)
function f1(limit, list){
    for(const a of list){
        if(a % 2){
         const b = a * a; 
         console.log(b);
        if(--limit == 0) break;
    }
    }
}
//f1(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

function f2(limit, list){
    let acc = 0;
    // 기존에 list에서 순회할 때는 무조건 순회를 거치기 때문에 전부 한번씩 순회를 하게 된다.
    // filter를 사용하면 조건에 맞는 것만 순회를 하기 때문에 효율적이다.
    for(const a of L.filter(a => a % 2, list)){
        const b = a * a;
        acc += b;
        console.log(b);
        if(--limit == 0) break;
    }
 }

// f2(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);



function f3(limit, list){
    let acc = 0;
    // L.map(a => a*a, L.filter(a => a % 2, list)) : list에서 홀수만 걸러내서 제곱을 한다.
    // map 객체에 a*a를 담는다, filter로 걸러진 홀수만.
    for(const a of L.map(a => a*a, L.filter(a => a % 2, list))){
        acc += a;
        if(--limit == 0) break;
    }
    console.log(acc);
 }
 
 //f3(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

 function f4(limit, list){
    let acc = 0;
    // take : limit만큼만 가져온다.
    for(const a of L.take(limit, L.map(a => a*a, L.filter(a => a % 2, list)))){
        acc += a;
    }
    console.log(acc);
 }

 // f4(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

function f5(limit, list){
    console.log(
        // reduce : 축약 및 합산을 도와주는 함수
        // reduce로 합산식을 정해놓을 수 있다.
        _.reduce((acc, a) => acc + a,
        0,
        L.take(limit, L.map(a => a*a, L.filter(a => a % 2, list)))
        )
    )
}

// f5(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);


function f6(limit, list){
    // a, b가 들어오면 a+b를 반환해서 add에 담는다.
    const add = (a, b) => a + b;

    // _.go를 이용해 함수를 역순 호출할 수 있다(사람이 읽기 쉽도록 함)
    _.go(list,
        L.filter( a => a % 2),
        L.map( a => a * a),
        L.take(limit),
        _.reduce(add),
        console.log);
}

//f6(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);


function mpnFn(numbers){
    // const item = numbers.map(function(number){return number * number;});
    // const item = numbers.map(number => number * number);
    const item = [];
    for(const a of L.map(a => a*a, numbers)){
        item.push(a);
    }
    return item;
}

function takeFn(numbers){

    const item = [];
    const size = 5;

    /*
    for(const a of L.map(a => a*a, numbers)){
        item.push(a);
    }
    */

    for(const a of L.take(size, numbers.map(a => a * a, numbers))){
        item.push(a);
    }
    return item;
}

function f7(list){
    console.log(takeFn(list));
}

f7([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);