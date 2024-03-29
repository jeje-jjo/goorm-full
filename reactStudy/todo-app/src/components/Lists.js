import React from 'react'
import { DragDropContext, Draggable, Direction, Droppable } from 'react-beautiful-dnd';
import List from './List';

const Lists = React.memo(({handleClick, todoData, setTodoData}) => {

  const handleEnd = (result) => {
    console.log('result' ,result)

    if(!result.destination) return;
    const newTodoData = [...todoData];
    
    // 1. 변경시키는 아이템을 배열에서 삭제.
    // 2. return 값으로 지워진 아이템을 잡아줌
    const [redorderedItem] = newTodoData.splice(result.source.index, 1);

    // 원하는 자리에 redorderItem을 넣어줌
    newTodoData.splice(result.destination.index, 0, redorderedItem);
    setTodoData(newTodoData);
    localStorage.setItem("todoData", JSON.stringify(newTodoData));
  }



  return (
    <div>
        <DragDropContext onDragEnd={handleEnd}>
            <Droppable droppableId="todo">
                {(provided) => (
                <div {...provided.droppableProps} ref={provided.innerRef}>
                {todoData.map((data, index) => (
                    <Draggable
                        key = {data.id}
                        draggableId={data.id.toString()}
                        index={index} >
                        {(provided, snapshot) => (
                          <List 
                            key = {data.id}
                            id = {data.id}
                            title = {data.title}
                            completed = {data.completed}
                            todoData = {todoData}
                            setTodoData = {setTodoData}
                            provided = {provided}
                            snapshot = {snapshot}
                            handleClick = {handleClick}
                          />
                        )}
                    </Draggable>
                ))}
                {provided.placeholder}
                </div>
                )}
            </Droppable>
        </DragDropContext>
    </div>
  )
})

export default Lists
