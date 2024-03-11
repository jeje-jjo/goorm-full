import React, { Component } from "react";
import "./App.css";

export default class App extends Component {

  state = {
    todoData : [],
    value : ""
  }

  // btn style 정의
  btnStyle = {
    color : "#fff",
    border : "none",
    padding : "5px 9px",
    borderRadius : "50%",
    cursor : "pointer",
    float : "right"
  }

  // 동적 변경 역ㅇ역이기 때문에
  getStyle = (completed) => {
    return {
      padding : "10px",
      borderBottom : "1px #ccc dotted",
      textDecoration : completed ? "line-through" : "none"
    }
  }

  

  handleClick = (id) => {
    let newTodoData = this.state.todoData.filter((data) => data.id !== id);
    this.setState({ todoData : newTodoData });
  }

  handleChange = (e) => {
    this.setState({ value : e.target.value});
  }

  handleSubmit = (e) => {
    // 페이지 리로딩 방지
    e.preventDefault();

    // 새로운 todoData 생성
    let newTodo = {
      id : Date.now(),
      title : this.state.value,
      completed : false
    }

    // 기존 todoData에 새로운 todoData 추가
    // 전개 연산자 : 특정 객체 또는 배열의 값을 다른 객체, 배열로 복제하거나 옮길 때 사용. 연산자 기호는 (...) 이다.
    // 배열 조합의 경우 ...item 을 사용하여 배열을 복사하고 새로운 요소를 추가할 수 있다.
    // 객체 조합의 경우 ..., item 을 사용하여 객체를 복사하고 새로운 속성을 추가할 수 있다.
    this.setState({ todoData : [...this.state.todoData, newTodo], value  : ""})
  }

  handleCompletedChange = (id) => {
    let newTodoData = this.state.todoData.map(data => {
      if(data.id === id){
        data.completed = !data.Component;
      }
      return data;
    })

    this.setState({ todoData : newTodoData})
  }
  


  render() {
    return (
      // jsx는 class 작성을 할 때 className이라고 작성
        <div className="container">
          <div className="todoBlock">
            <div className="title">
                <h1>할 일 목록</h1>
            </div>

            {this.state.todoData.map((data) => (
            <div style={this.getStyle(data.completed)} key={data.id}>
              <input type="checkbox" 
                     defaultChecked={false} 
                     onChange={() => this.handleCompletedChange(data.id)}/>
               {data.title}
              <button style={this.btnStyle} onClick={() => this.handleClick(data.id)}>x</button>
            </div>
            ))}

            <form style={{display : 'flex'}} onSubmit={this.handleSubmit}>
              <input type="text" name="value" style={{flex : '10', padding : '5px'}} placeholder="내용 입력" value={this.state.value} onChange={this.handleChange}/>
              <input type="submit" value="입력" className="btn" style={{flex : '1'}}/>
            </form>
            
          </div>
        </div>
      );
  }
}