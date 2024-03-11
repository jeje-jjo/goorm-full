import React, {useState, useCallback} from "react";
import "./App.css";
import Lists from "./components/Lists";
import Form from "./components/Form";


const initialTodoData = localStorage.getItem("todoData") ? JSON.parse(localStorage.getItem("todoData")) : [];

 function App(){

  // state = {
  //   todoData : [],
  //   value : ""
  // }

  // [state, setState] = useState(initialState)
  const [todoData, setTodoData] = useState(initialTodoData);
  const [value, setValue] = useState("");

  // 동적 변경 역ㅇ역이기 때문에

  const handleSubmit = (e) => {
    // 페이지 리로딩 방지
    e.preventDefault();

    // 새로운 todoData 생성
    let newTodo = {
      id : Date.now(),
      title : value, //this.state.value, 
      completed : false
    }

    // 기존 todoData에 새로운 todoData 추가
    // 전개 연산자 : 특정 객체 또는 배열의 값을 다른 객체, 배열로 복제하거나 옮길 때 사용. 연산자 기호는 (...) 이다.
    // 배열 조합의 경우 ...item 을 사용하여 배열을 복사하고 새로운 요소를 추가할 수 있다.
    // 객체 조합의 경우 ..., item 을 사용하여 객체를 복사하고 새로운 속성을 추가할 수 있다.
    
    //this.setState({ todoData : [...this.state.todoData, newTodo], value  : ""})
    setTodoData( prev => [...prev, newTodo])
    localStorage.setItem("todoData", JSON.stringify([...todoData, newTodo]));
    setValue("");
  }

  const handleClick = useCallback((id) => {
    let newTodoData = todoData.filter((data) => data.id !== id);
    //this.setState({ todoData : newTodoData });
    setTodoData(newTodoData);
    localStorage.setItem("todoData", JSON.stringify(newTodoData));
}, [todoData]);


  const handleRemoveClick = () => {
    //this.setState({ todoData : [] });
    setTodoData([]);
    localStorage.setItem("todoData", JSON.stringify([]));
  }


  return (
    // jsx는 class 작성을 할 때 className이라고 작성
      <div className="flex items-center justify-center w-screen h-screen bg-blue-100">
        <div className="w-full p-6 m-4 bg-white rounded shadow lg:w-3/4 lg:max-w-lg">
          <div className="flex justify-between mb-3">
              <h1>할 일 목록</h1>
              <button onClick={handleRemoveClick}>Delete All</button>
          </div>

          <Lists handleClick={handleClick} todoData={todoData} setTodoData={setTodoData}/>

          <Form handleSubmit={handleSubmit} value={value} setValue={setValue} />
           
        </div>
      </div>
    );
}

export default App;