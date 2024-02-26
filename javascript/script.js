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

//f7([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);



// while을 range로 대체
function f8(end){
    let i = 0;
    while (i < end){

        console.log(i);
        ++ i;
    }
}
// f8(10);

function f9(end){
    _.each(console.log, L.range(end));
}
// f9(10);



// 효과를 each로 대체
function f10(end){
    _.go(
        L.range(1, end, 2),
        _.each(console.log)
    );
}

// f10(10);



// // 별찍기
// function f11(){

//     const join = sep => _.reduce((a,b) => `${a}${sep}${b}`);  
//     _.go(
//         L.range(1, 6),
//         L.map(L.range),
//         L.map(L.map( => '*')), 
//         L.map(join('')),
//         join('\n'),                // 최대 갯수
//        console.log 
//     );

//     _.go(
//         L.range(1, 6),
//         L.map(s => go (
//             L.range(5),
//             L.map( => '*'),
//             _.reduce((a,b) => `${a}${b}`)
//         )),
//         _.reduce((a,b) => `${a}\n${b}`),                // 최대 갯수
//        console.log 
//     );
// }

//f11();

// 구구단

function f12(){
    const join = sep => _.reduce((a,b) => `${a}${sep}${b}`);  
    _.go(
        _.range(2, 10),
        _.map(a => _.go(
            _.range(1, 10),
            _.map(b => `${a} * ${b} = ${a*b}`),
            join('\n')
        )),
        join('\n\n'),
        console.log
    );
}

//f12();



// 명령형 습관 지우기
const users = [
    {name: 'aa', age: 21},
    {name: 'bb', age: 31},
    {name: 'cc', age: 41},
    {name: 'dd', age: 51},
    {name: 'ee', age: 61},
    {name: 'ff', age: 71},
    {name: 'gg', age: 81},
    {name: 'hh', age: 91},
    {name: 'ii', age: 101}
];

function f13(users){
    console.log(
        _.reduce((total, u) => total + u.age, 0, users)
    );
    
    const add = (a, b) => a + b;
    console.log(
        _.reduce(add, L.map(u => u.age, users)) 
    );
    
    // 조금 더 복잡하게~
    // 나이를 합산하는데 30세보다 적은 사람만 합산하기
    console.log(
        _.reduce((total, u) => u.age >= 30? total : total + u.age , 0, users)
    );
    
    // map, filter, reduce를 사용해서 구현
    console.log(
        _.reduce(add,
            _.map(u => u.age,
                _.filter(u => u.age <= 30, users)))
    );
    
    console.log(
        _.reduce(add,
            _.filter(n => n <= 30,
                _.map(u => u.age, users)))
    );
}

// f13(users);


// query, queryToObject 
const obj1 = {
    a : 1,
    b : undefined,
    c : 'CC',
    d : 'DD'
};

function f14(obj){
    // a=1&c=CC&d=DD
    
    function query1(obj){
        let res = '';
        for(const k in obj){
           const v = obj[k];
           if(v === undefined) continue;
           if(res != '') res += '&'; 
           res += k + '=' + v ;
        }
        return res;
    }

    function query2(obj){
        return Object
        .entries(obj)
        .reduce((query, [k, v], i) => {
            if(v === undefined) return query; 
            //return query + (i > 0 ? '&' : '') + k + '=' + v;
            return `${query}${i > 0? '&' : ''}${k}=${v}`;
            }, '');    
    }

    function query3(obj){
        return (
            _.reduce((a, b) => `${a}&${b}`,
            _.map(
                ([k, v]) => `${k}=${v}`,
                _.reject(([_, v]) => v === undefined,
                Object.entries(obj)
                )
            ))
        )
    };

    const join = _.curry((sep, iter) => 
        _.reduce((a, b) => `${a}${sep}${b}`, iter));

    const query4 = _.pipe(
        Object.entries,
        _.reject(([_, v]) => v === undefined),
        _.map(join('=')),
        join('&')
    ); 

    console.log(query4(obj));
};

//  f14(obj1);



// queryToObject
const split = _.curry((sep,str) => str.split(sep));
const queryToObject = _.pipe(
    split('&'),
    L.map(split('=')),
    L.map(([k, v]) => ({[k] : v})),
    _.reduce(Object.assign)
);
console.log(queryToObject('a=1&b=CC&c=DD'));