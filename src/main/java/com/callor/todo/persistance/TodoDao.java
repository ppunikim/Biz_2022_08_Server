package com.callor.todo.persistance;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, Long>{

	public void create_todo_table();
	public TodoVO findById(long t_seq);
	public int insertTodo(String t_content);
	int insertTodo(Long t_seq);

}
