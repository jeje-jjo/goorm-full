const list = document.getElementById('list');
const createBtn = document.getElementById('create-btn');


// 배열 안에 리스트를 넣고 하나씩 출력을 위해 만드는 것
// {id : oewdkf, text : '밥먹기', complete : false}
let todos = [];

createBtn.addEventListener('click', createNewTodo);

function createNewTodo(){
    // 새로운 아이템 객체 생성하기
    const item = {
        id : new Date().getTime(), 
        text : '', 
        complete : false}

    // 배열 처음에 새로운 아이템 추가
    todos.unshift(item);

    // 요소 생성하기
    const {itemEl, inputEl, editBtnEl, removeBtnEl} = createTodoElement(item);
    list.prepend(itemEl);


    inputEl.removeAttribute('disabled');
    inputEl.focus();

    saveToLocalStorage();
}


function createTodoElement(item){
    const itemEl = document.createElement('div');
    itemEl.classList.add('item');

    const checkboxEl = document.createElement('input');
    checkboxEl.type = 'checkbox';
    checkboxEl.checked = item.complete;

    if(item.complete){
        itemEl.classList.add('complete');
    }

    const inputEl = document.createElement('input');
    inputEl.type = 'text';
    inputEl.value = item.text;
    inputEl.setAttribute('disabled', '');

    const actionEl = document.createElement('div');
    actionEl.classList.add('actions');

    const editBtnEl = document.createElement('button');
    editBtnEl.classList.add('material-icons');
    editBtnEl.innerText = 'edit';

    const removeBtnEl = document.createElement('button');
    removeBtnEl.classList.add('material-icons', 'remove-btn');
    removeBtnEl.innerText = 'remove_circles';

    checkboxEl.addEventListener('change', (e) => {
        item.complete = e.target.checked;

        if(item.complete){
            itemEl.classList.add('complete');
        }else{
            itemEl.classList.remove('complete');
        }

        saveToLocalStorage();
    });

    inputEl.addEventListener('blur', (e) => {
        inputEl.setAttribute('disabled', '');
        saveToLocalStorage();
    })

    inputEl.addEventListener('input', (e) => {
        item.text = e.target.value;
    });

    editBtnEl.addEventListener('click', (e) => {
        inputEl.removeAttribute('disabled');
        inputEl.focus();
    });

    removeBtnEl.addEventListener('click', (e) => {
        todos = todos.filter(todo => todo.id !== item.id);
        itemEl.remove();
        saveToLocalStorage();
    });


    actionEl.append(editBtnEl);
    actionEl.append(removeBtnEl);

    itemEl.append(checkboxEl);
    itemEl.append(inputEl);
    itemEl.append(actionEl);

    return {itemEl, inputEl, editBtnEl, removeBtnEl};
}


function saveToLocalStorage(){
    const data = JSON.stringify(todos);
gl
    localStorage.setItem('my_todos', data);
}


function loadFromLocalStorage(){
    const data = localStorage.getItem('my_todos');

  todos = JSON.parse(data);
}

function displayTodos(){
    loadFromLocalStorage();

    for(let i = 0; i < todos.length; i++){
        const item = todos[i];
        const {itemEl} = createTodoElement(item);



        list.append(itemEl);
    }
}

displayTodos();