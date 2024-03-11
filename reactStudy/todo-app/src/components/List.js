import React from 'react'

export default function List({todoData, setTodoData}) {


  // btn style 정의
  const btnStyle = {
    color : "#fff",
    border : "none",
    padding : "5px 9px",
    borderRadius : "50%",
    cursor : "pointer",
    float : "right"
  }

  const getStyle = (completed) => {
    return {
      padding : "10px",
      borderBottom : "1px #ccc dotted",
      textDecoration : completed ? "line-through" : "none"
    }
  }

  
  const handleClick = (id) => {
    let newTodoData = todoData.filter((data) => data.id !== id);
    //this.setState({ todoData : newTodoData });
    setTodoData(newTodoData);
  }

  const handleCompletedChange = (id) => {
    let newTodoData = todoData.map(data => {//this.state.todoData.map(data => {
      if(data.id === id){
        data.completed = !data.completed;
      }
      return data;
    })

   // this.setState({ todoData : newTodoData})
   setTodoData(newTodoData);
  }




  return (
    <div>
    {todoData.map((data) => (
        <div style={getStyle(data.completed)} key={data.id}>
          <input type="checkbox" 
                  defaultChecked={false} 
                  onChange={() => handleCompletedChange(data.id)}/>
            {data.title}
          <button style={btnStyle} onClick={() => handleClick(data.id)}>x</button>
        </div>
    ))}
    </div>
  )
}
